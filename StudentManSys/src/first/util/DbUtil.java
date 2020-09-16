package first.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//与数据库建立连接
public class DbUtil {
	//数据库连接地址                                                                                            数据库名称  指定编码
	private String dbUrl="jdbc:mysql://localhost:3306/db_student?useUnicode=true&characterEncoding=utf8";
	private String dbUserName="root";//用户名
	private String dbPassword="2454824729";//密码
	private String jdbcName="com.mysql.jdbc.Driver";//驱动名称
	//ctrl+shift+o导入包
	
	
	/*获取数据库连接*/
	public Connection getCon() {
		try {
			Class.forName(jdbcName);//加载驱动类
		}catch(ClassNotFoundException E) {
			E.printStackTrace();
		}
		//建立连接
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/*关闭数据库连接*/
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		
	}
}
