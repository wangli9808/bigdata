package cn.tedu.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

// 自定义函数
public class AuthFunction extends UDF {

	// 如果需要自定义函数，那么所有逻辑是写在evaluate
	// 例如：从一个字符串中来抽取其中的数字
	public int evaluate(String str) {
		return Integer.parseInt(str.replaceAll("\\D", ""));
	}

}
