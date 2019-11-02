package cn.tedu.hadoop.serialflow;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SerialFlowMapper
        extends Mapper<LongWritable, Text, Text, Flow> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] arr = value.toString().split(" ");
        Flow f = new Flow();
        f.setPhone(arr[0]);
        f.setAddr(arr[1]);
        f.setName(arr[2]);
        f.setFlow(Integer.parseInt(arr[3]));

        context.write(new Text(f.getName()), f);

    }

}
