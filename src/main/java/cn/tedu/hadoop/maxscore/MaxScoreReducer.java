package cn.tedu.hadoop.maxscore;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxScoreReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {

        // 在MapReduce中，为了减少对象的创建和销毁，采用了地址复用机制
        // 在迭代过程中，被迭代的对象只创建一次
        IntWritable max = new IntWritable(0);
        // key = Bob
        // values = 684 512 340 312
        // IntWritable val = new IntWritable();
        // val.set(684);
        // val.get() > max.get() -> 684 > 0 -> true
        // max = val; - 将val赋值给max，给的是地址，所以max和val的指向地址一致
        // val.set(512);
        // val.get() > max.get() -> 512 > 512 -> false
        // 最后max的值是最后一个被迭代的值
        for (IntWritable val : values) {
            if (val.get() > max.get())
                // max = val;
            {
                max.set(val.get());
            }
        }
        context.write(key, max);
    }

}
