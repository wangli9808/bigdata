package cn.tedu.hadoop.totalscore;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TotalScoreMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // Bob 50
        String[] arr = value.toString().split(" ");
        context.write(new Text(arr[0]),
                new IntWritable(Integer.parseInt(arr[1])));

    }

}
