package first.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import first.connect.ClassCon;
import first.model.StudentClass;
import first.util.StringUtil;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddClassFrm extends JInternalFrame {
	private JTextField classNameTextField;
	private JTextArea classInfoTextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClassFrm frame = new AddClassFrm();
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
	public AddClassFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u73ED\u7EA7");
		setBounds(100, 100, 605, 447);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(AddClassFrm.class.getResource("/images/mingcheng.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label_1.setIcon(new ImageIcon(AddClassFrm.class.getResource("/images/jieshao.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);
		
		classInfoTextArea = new JTextArea();
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submit(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddClassFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddClassFrm.class.getResource("/images/zhongzhilanse3.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(submitButton)
							.addGap(85)
							.addComponent(resetButton)
							.addGap(26))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
								.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addGap(64))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submit(ActionEvent ae) {
		// TODO 自动生成的方法存根
		String className = classNameTextField.getText().toString();
		String classInfo = classInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(className)) {
			JOptionPane.showMessageDialog(this,"班级名称不能为空");
			return;
		}
		StudentClass scl = new StudentClass();
		scl.setName(className);
		scl.setInfo(classInfo);
		ClassCon classCon = new ClassCon();
		if(classCon.addClass(scl)) {
			JOptionPane.showMessageDialog(this, "班级添加成功！");
		}else {
			JOptionPane.showMessageDialog(this, "班级添加失败！");
		}
		classCon.closeCon();
		resetValue(ae);
;	}

	protected void resetValue(ActionEvent ae) {
		// TODO 自动生成的方法存根
		classNameTextField.setText("");
		classInfoTextArea.setText("");
		
	}
}
