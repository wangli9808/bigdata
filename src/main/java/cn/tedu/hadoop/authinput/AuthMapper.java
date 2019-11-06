package cn.tedu.hadoop.authinput;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AuthMapper extends Mapper<Text, Text, Text, Score> {

    @Override
    public void map(Text key, Text value, Context context) throws IOException, InterruptedException {

        // key = tom
        // value = math 90 english 98
        String[] arr = value.toString().split(" ");
        Score s = new Score();
        s.setMath(Integer.parseInt(arr[1]));
        s.setEnglish(Integer.parseInt(arr[3]));
        context.write(key, s);

    }

}
