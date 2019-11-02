package cn.tedu.hadoop.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// Reduce的数据从Map来，那么也就意味着Map的输出就是Reduce的输入
// KEYIN, VALUEIN
// 最后应该是输出每一个单词对应的总次数
// KEYOUT, VALUEOUT
public class WordCountReducer
        extends Reducer<Text, IntWritable, Text, IntWritable> {

    // key - 输入的键
    // values - 键所对应的所有的值
    // hello
    // values = 1,1,1,1,1,1,1...
    // context - 将结果写到HDFS上
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,
                          Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }

        context.write(key, new IntWritable(sum));

    }

}
