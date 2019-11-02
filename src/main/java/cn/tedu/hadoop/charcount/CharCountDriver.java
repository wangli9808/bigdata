package cn.tedu.hadoop.charcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CharCountDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "JobName");
        job.setJarByClass(cn.tedu.hadoop.charcount.CharCountDriver.class);
        job.setMapperClass(CharCountMapper.class);
        job.setReducerClass(CharCountReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.10.101:9000/txt/characters.txt"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.10.101:9000/result/charcount"));

        if (!job.waitForCompletion(true)) {
            return;
        }
    }

}
