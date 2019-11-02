package cn.tedu.hadoop.charcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CharCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        char[] cs = value.toString().replaceAll("\\s", "").toCharArray();
        for (char c : cs) {
            context.write(new Text(c + ""), new LongWritable(1));
        }

    }

}
