package cn.tedu.hadoop.serialscore;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SerialScoreReducer extends Reducer<Text, Score, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<Score> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (Score val : values) {
            sum = val.getChinese() + val.getMath() + val.getEnglish();
        }
        context.write(key, new IntWritable(sum));
    }

}
