package cn.tedu.hadoop.authinput;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AuthDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("mapreduce.output.basename", "auth");
		conf.set("mapreduce.output.textoutputformat.separator", "+++");
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(cn.tedu.hadoop.authinput.AuthDriver.class);
		job.setMapperClass(AuthMapper.class);
		job.setReducerClass(AuthReducer.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Score.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// 指定输入格式
		job.setInputFormatClass(AuthInputFormat.class);
		// job.setOutputFormatClass(cls);

		// Path p = new Path("hdfs://192.168.245.130:9000/txt/score3.txt");
		// MultipleInputs.addInputPath(job, p, inputFormatClass);
		// MultipleInputs.addInputPath(job, path, inputFormatClass,mapperClass);

		FileInputFormat.setInputPaths(job, new Path("hdfs://10.42.10.101:9000/txt/score3.txt"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://10.42.10.101:9000/result/authscore3"));

		if (!job.waitForCompletion(true)) {
			return;
		}
	}

}
