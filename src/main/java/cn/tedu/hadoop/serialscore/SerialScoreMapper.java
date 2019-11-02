package cn.tedu.hadoop.serialscore;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SerialScoreMapper extends Mapper<LongWritable, Text, Text, Score> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        Score s = new Score();
        s.setName(arr[0]);
        s.setChinese(Integer.parseInt(arr[1]));
        s.setMath(Integer.parseInt(arr[2]));
        s.setEnglish(Integer.parseInt(arr[3]));
        context.write(new Text(s.getName()), s);
    }

}
