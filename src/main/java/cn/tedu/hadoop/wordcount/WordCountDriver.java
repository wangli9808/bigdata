package cn.tedu.hadoop.wordcount;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @author tarena
 */
public class WordCountDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        // 先向Hadoop申请一个job任务执行逻辑
        Job job = Job.getInstance();

        // 设置入口类
        job.setJarByClass(WordCountDriver.class);
        // 设置Mapper类
        job.setMapperClass(WordCountMapper.class);
        // 设置Reducer类
        job.setReducerClass(WordCountReducer.class);

        // 设置Mapper的输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        // 设置Reducer的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 设置输入文件
        FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.10.101:9000/txt/words.txt"));
        // 设置输出路径
        // 输出路径要求不存在
        FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.10.101:9000/result/wordcount"));

        // 启动执行
        job.waitForCompletion(true);
    }

}
