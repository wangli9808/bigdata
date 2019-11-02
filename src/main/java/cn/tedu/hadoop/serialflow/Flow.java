package cn.tedu.hadoop.serialflow;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import lombok.Data;
import org.apache.hadoop.io.Writable;

@Data
public class Flow implements Writable {

    private String phone;
    private String addr;
    private String name;
    private int flow;


    // 反序列化
    // 按照什么顺序写的，就得按照什么顺序读
    @Override
    public void readFields(DataInput in) throws IOException {
        this.phone = in.readUTF();
        this.addr = in.readUTF();
        this.name = in.readUTF();
        this.flow = in.readInt();
    }

    // 序列化
    // 只需要将有必要的属性来依次写出即可序列化
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(phone);
        out.writeUTF(addr);
        out.writeUTF(name);
        out.writeInt(flow);
    }

}

