package first.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import first.connect.TeacherCon;
import first.model.Teacher;
import first.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTeacherFrm extends JInternalFrame {
	private JTextField teacherNameTextField;
	private JTextField teacherTitleTextField;
	private JTextField teacherAgeTextField;
	private JRadioButton teacherSexManRadioButton;
	private JRadioButton teacherSexFemaRadioButton;
	private JPasswordField teacherPasswordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherFrm frame = new AddTeacherFrm();
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
	public AddTeacherFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u6559\u5E08");
		setBounds(100, 100, 596, 386);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u8001\u5E08.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(10);
		
		JLabel label = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/xingbie.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherTitleTextField = new JTextField();
		teacherTitleTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/zhicheng.png")));
		
		teacherSexManRadioButton = new JRadioButton("\u7537");
		
		teacherSexFemaRadioButton = new JRadioButton("\u5973");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(teacherSexManRadioButton);
		buttonGroup.add(teacherSexFemaRadioButton);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u5E74\u9F84:");
		label_2.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/nianling.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				AddTeacherAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/querenlanse1.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E\u5185\u5BB9");
		resetButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/zhongzhilanse3.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		
		
		
		JLabel label_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/mimalanse1.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherPasswordField = new JPasswordField();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(133)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label)
									.addGap(18)
									.addComponent(teacherSexManRadioButton)
									.addGap(38)
									.addComponent(teacherSexFemaRadioButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_2)
										.addComponent(label_3))
									.addGap(7)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(teacherPasswordField, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
										.addComponent(teacherTitleTextField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
										.addComponent(teacherAgeTextField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))
							.addGap(147))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(161)
							.addComponent(submitButton)
							.addGap(69)
							.addComponent(resetButton)))
					.addGap(158))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(teacherSexManRadioButton)
						.addComponent(teacherSexFemaRadioButton))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(teacherPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO 自动生成的方法存根
		teacherNameTextField.setText("");
		teacherTitleTextField.setText("");
		teacherAgeTextField.setText("");
		teacherPasswordField.setText("");
		teacherSexManRadioButton.setSelected(true);
	}

	protected void AddTeacherAct(ActionEvent ae) {
		// TODO 自动生成的方法存根
		String teacherName = teacherNameTextField.getText().toString();
		String teacherSex = teacherSexManRadioButton.isSelected() ? teacherSexManRadioButton.getText().toString() : teacherSexFemaRadioButton.getText().toString();
		String teacherTitle = teacherTitleTextField.getText().toString();
		String teacherPassword = teacherPasswordField.getText().toString();
		int teacherAge = 0;
		try {
			teacherAge = Integer.parseInt(teacherAgeTextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
			return;
		}
		if(StringUtil.isEmpty(teacherName)){
			JOptionPane.showMessageDialog(this, "请填写教师姓名！");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)){
			JOptionPane.showMessageDialog(this, "请填写教师职称！");
			return;
		}
		if(teacherAge == 0 || teacherAge < 0){
			JOptionPane.showMessageDialog(this, "教师年龄必须大于0！");
			return;
		}
		if(teacherAge > 100){
			JOptionPane.showMessageDialog(this, "教师年龄必须小于100！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)){
			JOptionPane.showMessageDialog(this, "请填写教师登录密码！");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		
		
		TeacherCon teacherCon = new TeacherCon();
		if(teacherCon.addTeacher(teacher)){
			JOptionPane.showMessageDialog(this, "教师添加成功！");
		}else{
			JOptionPane.showMessageDialog(this, "教师添加失败！");
		}
		resetValue(ae);
	}
}
