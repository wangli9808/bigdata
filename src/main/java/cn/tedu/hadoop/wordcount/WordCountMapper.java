package cn.tedu.hadoop.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// 需要指定Map阶段的处理逻辑
// MapReduce中，要求所有的对象都能够被序列化
// MapReduce所默认采取的序列化机制是AVRO
// KEYIN - 输入的键的类型 - 默认输入的键表示的是一行数据的字节偏移量
// VALUEIN - 输入的值的类型 - 默认输入的值表示的是读取的一行数据
// KEYOUT - 输出的键的类型
// VALUEOUT - 输出的值的类型
public class WordCountMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {

    // key - 行偏移量
    // value - 一行数据
    // context - 用于数据传递和指定环境参数
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {

        // hello tom hello bob
        // 先将这一行中每一个单词拆分出来
        String[] arr = value.toString().split(" ");
        // hello 2 tom 1 bob 1
        // hello 1 tom 1 hello 1 bob 1
        for (String str : arr) {
            context.write(new Text(str), new IntWritable(1));
        }

    }

}

