package cn.tedu.hadoop.HDFS;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URI;


public class HDFSDemo {
    @Test
    public void get() throws IOException {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://10.42.10.101:9000"), conf);
        InputStream in = fileSystem.open(new Path("/a"));
        FileOutputStream out = new FileOutputStream("b");
        IOUtils.copyBytes(in, out, conf);
        in.close();
        out.close();


    }

    @Test
    public void put() throws IOException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://10.42.10.101:9000"), conf, "root");
        OutputStream out = fileSystem.create(new Path("/a.log"));
        FileInputStream in = new FileInputStream("b.txt");
        IOUtils.copyBytes(in, out, conf);
        in.close();
        out.close();

    }
}
