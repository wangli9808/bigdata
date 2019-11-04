package cn.tedu.hadoop.authinput;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import lombok.Data;
import org.apache.hadoop.io.Writable;
@Data
public class Score implements Writable {

	private int math;
	private int english;


	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(math);
		out.writeInt(english);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.math = in.readInt();
		this.english = in.readInt();
	}

}
