package first.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import first.connect.AdminCon;
import first.connect.StudentCon;
import first.connect.TeacherCon;
import first.model.Admin;
import first.model.Student;
import first.model.Teacher;
import first.model.UserType;
import first.util.Util_one;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	private JComboBox userTypeComboBox; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel label =  new JLabel("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/xuesheng.png")));
		label.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("\u8D26\u53F7\uFF1A");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/images/password.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_3.setIcon(new ImageIcon(Login.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.TEACHTER, UserType.STUDENT}));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAction(ae);
			}
		});
		loginButton.setIcon(new ImageIcon(Login.class.getResource("/images/\u767B\u5F55.png")));
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restvalue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(Login.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(loginButton)
							.addGap(41)
							.addComponent(resetButton)
							.addGap(14))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_2)
										.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1)
									.addGap(32)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(userTypeComboBox, 0, 169, Short.MAX_VALUE))))
					.addGap(120))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(156, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(137))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(label)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(loginButton))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	//登录发生事件，
	protected void loginAction(ActionEvent ae) {
		// TODO 自动生成的方法存根
		String userName = userNameTextField.getText();
		String password = passwordField.getText();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		if(Util_one.isEmpty(userName)){
			JOptionPane.showMessageDialog(this,"用户名不能为空");
			return;
		}
		if(Util_one.isEmpty(password)){
			JOptionPane.showMessageDialog(this,"密码不能为空");
			return;
		}
		
		//身份验证
		Admin admin = null;
		if("系统管理员".equals(selectedItem.getName())) {
			
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			
			AdminCon adminCon = new AdminCon();
			admin = adminCon.login(adminTmp);
			adminCon.closeCon();
			
			if(admin == null) {
				JOptionPane.showMessageDialog(this," 用户名或密码错误！");
				return;
			}
			
			//登录后页面跳转
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】"+admin.getName()+"登录！");
			this.dispose();
			new MainFrm(selectedItem,admin).setVisible(true);
			
			
			
			
		}else if("教师".equals(selectedItem.getName())) {
			Teacher teacher = null;
			Teacher teacherTmp = new Teacher();
			teacherTmp.setName(userName);
			teacherTmp.setPassword(password);
			
			TeacherCon teacherCon = new TeacherCon();
			teacher = teacherCon.login(teacherTmp);
			teacherCon.closeCon();
			
			if(teacher == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+teacher.getName()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, teacher).setVisible(true);
		
		
		}else {
			Student student = null; 
			Student studentTmp = new Student();
			studentTmp.setName(userName);
			studentTmp.setPassword(password);
			
			StudentCon studentCon = new StudentCon();
			student = studentCon.login(studentTmp);
			studentCon.closeCon();
			
			if(student == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+student.getName()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, student).setVisible(true);
		}
	}

	
	//重置发生事件，清空数据
	protected void restvalue(ActionEvent ae) {
		// TODO 自动生成的方法存根
		userNameTextField.setText("");
		passwordField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}

}
