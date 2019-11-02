package cn.tedu.hadoop.wordcount2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "JobName");
        job.setJarByClass(cn.tedu.hadoop.wordcount2.WDriver.class);
        job.setMapperClass(WMapper.class);
        job.setReducerClass(WReducer.class);

        // Mapper和Reducer的输出结果类型一致的时候，可以只设置一次
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.10.101:9000/txt/words.txt"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.10.101:9000/result/wordcount2"));

        if (!job.waitForCompletion(true)) {
            return;
        }
    }

}
