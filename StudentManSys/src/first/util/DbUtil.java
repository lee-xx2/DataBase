package first.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//�����ݿ⽨������
public class DbUtil {
	//���ݿ����ӵ�ַ                                                                                            ���ݿ�����  ָ������
	private String dbUrl="jdbc:mysql://localhost:3306/db_student?useUnicode=true&characterEncoding=utf8";
	private String dbUserName="root";//�û���
	private String dbPassword="2454824729";//����
	private String jdbcName="com.mysql.jdbc.Driver";//��������
	//ctrl+shift+o�����
	
	
	/*��ȡ���ݿ�����*/
	public Connection getCon() {
		try {
			Class.forName(jdbcName);//����������
		}catch(ClassNotFoundException E) {
			E.printStackTrace();
		}
		//��������
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/*�ر����ݿ�����*/
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
		
	}
}
