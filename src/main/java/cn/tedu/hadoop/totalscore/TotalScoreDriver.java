package cn.tedu.hadoop.totalscore;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TotalScoreDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "JobName");
        job.setJarByClass(cn.tedu.hadoop.totalscore.TotalScoreDriver.class);
        job.setMapperClass(TotalScoreMapper.class);
        job.setReducerClass(TotalScoreReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.10.101:9000/txt/score2/"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.10.101:9000/result/totalscore"));

        if (!job.waitForCompletion(true)) {
            return;
        }
    }

}
