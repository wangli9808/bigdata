package cn.tedu.hadoop.serialscore;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import lombok.Data;
import org.apache.hadoop.io.Writable;

@Data
public class Score implements Writable {

    private String name;
    private int chinese;
    private int math;
    private int english;


    @Override
    public void readFields(DataInput in) throws IOException {
        this.name = in.readUTF();
        this.chinese = in.readInt();
        this.math = in.readInt();
        this.english = in.readInt();
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(chinese);
        out.writeInt(math);
        out.writeInt(english);
    }

}
