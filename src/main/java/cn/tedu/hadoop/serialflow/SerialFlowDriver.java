package cn.tedu.hadoop.serialflow;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SerialFlowDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "JobName");
        job.setJarByClass(cn.tedu.hadoop.serialflow.SerialFlowDriver.class);
        job.setMapperClass(SerialFlowMapper.class);
        job.setReducerClass(SerialFlowReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Flow.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.10.101:9000/txt/flow.txt"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.10.101:9000/result/serialflow"));

        if (!job.waitForCompletion(true)) {
            return;
        }
    }

}
