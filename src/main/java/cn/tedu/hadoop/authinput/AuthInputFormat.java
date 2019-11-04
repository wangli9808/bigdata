package cn.tedu.hadoop.authinput;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.util.LineReader;

public class AuthInputFormat extends FileInputFormat<Text, Text> {

	@Override
	public RecordReader<Text, Text> createRecordReader(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {
		return new AuthReader();
	}

}

class AuthReader extends RecordReader<Text, Text> {

	private static final Text blank = new Text(" ");
	private LineReader reader;
	private Text key = new Text();
	private Text value = new Text();

	// 初始化
	// 在这个初始化方法中先获取到流
	@Override
	public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {

		// 从切片中确定要读取的文件
		FileSplit fSplit = (FileSplit) split;
		// 获取文件路径
		Path p = fSplit.getPath();
		// 连接HDFS
		FileSystem fs = FileSystem.get(URI.create(p.toString()), context.getConfiguration());
		// 获取到针对文件的输入流
		InputStream in = fs.open(p);
		// 将字节流转化为字符流 --- 这个字符流最好能按行读取
		reader = new LineReader(in);

	}

	// 读取文件
	// 如果读到了，则表示还有键和值需要处理
	// 如果没有读到，则表示已经没有数据了
	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		// 按照当前说法，这个方法，只需要试着读取三行
		// 如果读到了三行表示有数据需要处理，需要返回true

		Text tmp = new Text();
		// 表示会将读到这一行数据放入传的tmp中
		// readLine方法返回值表示读取的这一行的字节数
		if (reader.readLine(tmp) == 0) {
			return false;
		}
		// 读取完第一行，需要将第一行的数据作为键来使用
		key.set(tmp.toString());
		// 第二行和第三行拼接作为值来使用
		// math 90
		// english 98
		// math 90 english 98
		if (reader.readLine(tmp) == 0) {
			return false;
		}
		value.set(tmp.toString());
		value.append(blank.getBytes(), 0, blank.getLength());
		if (reader.readLine(tmp) == 0) {
			return false;
		}
		value.append(tmp.getBytes(), 0, tmp.getLength());

		return true;
	}

	@Override
	public Text getCurrentKey() throws IOException, InterruptedException {
		return key;
	}

	@Override
	public Text getCurrentValue() throws IOException, InterruptedException {
		return value;
	}

	// 获取执行进度
	@Override
	public float getProgress() throws IOException, InterruptedException {
		return 0;
	}

	@Override
	public void close() throws IOException {
		if (reader != null) {
			reader.close();
		}
		key = null;
		value = null;
	}

}
