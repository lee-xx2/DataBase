package first.connect;

import java.sql.Connection;
import java.sql.SQLException;

import first.util.DbUtil;

//用来与数据库打交道，获取数据库连接，传给每一个要跟数据库交互的model
public class DatabaseCon {
     public Connection con = new DbUtil().getCon();
     public void closeCon() {
    	 try {
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
     }
}
