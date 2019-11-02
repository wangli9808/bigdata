package cn.tedu.hadoop.maxscore;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxScoreDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "JobName");
        job.setJarByClass(cn.tedu.hadoop.maxscore.MaxScoreDriver.class);
        job.setMapperClass(MaxScoreMapper.class);
        job.setReducerClass(MaxScoreReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.10.101:9000/txt/score2.txt"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.10.101:9000/result/maxscore"));

        if (!job.waitForCompletion(true)) {
            return;
        }
    }

}
