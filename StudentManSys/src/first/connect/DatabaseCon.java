package first.connect;

import java.sql.Connection;
import java.sql.SQLException;

import first.util.DbUtil;

//���������ݿ�򽻵�����ȡ���ݿ����ӣ�����ÿһ��Ҫ�����ݿ⽻����model
public class DatabaseCon {
     public Connection con = new DbUtil().getCon();
     public void closeCon() {
    	 try {
			con.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
     }
}
