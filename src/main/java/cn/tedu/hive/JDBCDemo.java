package cn.tedu.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) throws Exception {

		// 注册驱动
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		// 获取连接
		Connection con = DriverManager.getConnection("jdbc:hive2://192.168.245.130:10000/hivedemo", "root", "root");
		// 获取表述
		Statement stat = con.createStatement();
		// 获取结果
		ResultSet rs = stat.executeQuery("select * from orders");
		while (rs.next()) {
			String oid = rs.getString("oid");
			System.out.println(oid);
		}
		// 关闭连接
		rs.close();
		stat.close();
		con.close();

	}

}

