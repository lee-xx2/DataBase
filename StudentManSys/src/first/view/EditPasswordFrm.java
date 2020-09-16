package first.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.StringUtils;

import first.connect.AdminCon;
import first.connect.StudentCon;
import first.connect.TeacherCon;
import first.model.Admin;
import first.model.Student;
import first.model.Teacher;
import first.model.UserType;
import first.util.StringUtil;
import first.util.Util_one;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private JLabel currentUserLabel;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPasswordFrm frame = new EditPasswordFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public EditPasswordFrm() {
		
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		//*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/mimalanse1.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/mimalanse.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		newPasswordField = new JPasswordField();
		newPasswordField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/queren.png")));
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/yonghulanse.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEdit(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/querenlanse1.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/zhongzhilanse3.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		currentUserLabel = new JLabel("New label");
		currentUserLabel.setEnabled(true);
		currentUserLabel.setText("");
		
	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(337)
					.addComponent(resetButton)
					.addContainerGap(191, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(label_3)
							.addGap(18)
							.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_1))
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(confirmPasswordField, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
									.addComponent(newPasswordField, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
									.addComponent(submitButton)))))
					.addGap(122))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	
		if("系统管理员".equals(MainFrm.userType.getName())) {
			Admin admin = (Admin)MainFrm.userObject;
			currentUserLabel.setText("【系统管理员】："+admin.getName());
		}else if("学生".equals(MainFrm.userType.getName())) {
			Student student = (Student)MainFrm.userObject;
			currentUserLabel.setText("【学生】："+student.getName());
		}else{
			Teacher teacher = (Teacher)MainFrm.userObject;
			currentUserLabel.setText("【教师】："+teacher.getName());
		}
	}
	
	
	
	
	
	
	protected void submitEdit(ActionEvent ae) {
		// TODO 自动生成的方法存根
		String oldPassword = oldPasswordField.getText().toString();
		String newPassword = newPasswordField.getText().toString();
		String confirmPassword = confirmPasswordField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "请填写旧密码！");
			return;
		}
		if(StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "请填写新密码！");
			return;
		}
		if(StringUtil.isEmpty(confirmPassword)){
			JOptionPane.showMessageDialog(this, "请确认新密码！");
			return;
		}
		if(!newPassword.equals(confirmPassword)){
			JOptionPane.showMessageDialog(this, "两次密码输入不一致！");
			return;
		}
		if("系统管理员".equals(MainFrm.userType.getName())){
			AdminCon adminCon = new AdminCon();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MainFrm.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setId(admin.getId());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminCon.editPassword(adminTmp, newPassword));
			adminCon.closeCon();
			return;
		}
		else if("学生".equals(MainFrm.userType.getName())){
			StudentCon studentCon = new StudentCon();
			Student studentTmp = new Student();
			Student student = (Student)MainFrm.userObject;
			studentTmp.setName(student.getName());
			studentTmp.setPassword(oldPassword);
			studentTmp.setId(student.getId());
			JOptionPane.showMessageDialog(this, studentCon.editPassword(studentTmp, newPassword));
			studentCon.closeCon();
			return;
	}else {
		TeacherCon teacherCon = new TeacherCon();
		Teacher teacherTmp = new Teacher();
		Teacher teacher = (Teacher)MainFrm.userObject;
		teacherTmp.setName(teacher.getName());
		teacherTmp.setPassword(oldPassword);
		teacherTmp.setId(teacher.getId());
		JOptionPane.showMessageDialog(this, teacherCon.editPassword(teacherTmp, newPassword));
		teacherCon.closeCon();
		return;
		
	}
	}






	protected void resetValue(ActionEvent ae) {
		// TODO 自动生成的方法存根
		oldPasswordField.setText("");
		newPasswordField.setText("");
		confirmPasswordField.setText("");
		
	}
}
