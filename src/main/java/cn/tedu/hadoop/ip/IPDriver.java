package cn.tedu.hadoop.ip;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class IPDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "JobName");
        job.setJarByClass(cn.tedu.hadoop.ip.IPDriver.class);
        job.setMapperClass(IPMapper.class);
        job.setReducerClass(IPReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        // 如果输入的路径是指定文件，则只读取这个文件
        // 如果输入的路径是目录，则读取这个目录下所有的文件
        FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.10.101:9000/txt/ip.txt"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.10.101:9000/result/ip"));

        if (!job.waitForCompletion(true)) {
            return;
        }
    }

}
