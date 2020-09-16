package first.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import first.connect.ClassCon;
import first.connect.StudentCon;
import first.connect.TeacherCon;
import first.model.Student;
import first.model.StudentClass;
import first.model.Teacher;
import first.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageTeacherFrm extends JInternalFrame {
	private JTable teacherListTable;
	private JTextField searchTeacherNameTextField;
	private JTextField editTeacherNameTextField;
	private JTextField editTeacherTitleTextField;
	private JTextField editTeacherAgeTextField;
	private JPasswordField editTeacherPasswordField;
	private JRadioButton editTeacherSexManRadioButton;
	private JRadioButton editTeacherSexFemaRadioButton;
	private JButton deleteTeacherButton;
	private List<Teacher> teacherList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTeacherFrm frame = new ManageTeacherFrm();
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
	public ManageTeacherFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 721, 553);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/jieshao.png")));
		
		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setColumns(10);
		
		JButton searchTeacherButton = new JButton("\u67E5\u8BE2");
		searchTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchTeacher(ae);
			}
		});
		searchTeacherButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		searchTeacherButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u641C\u7D22.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6559\u5E08\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(67)
							.addComponent(searchTeacherButton)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
							.addGap(79))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchTeacherButton))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 130, Short.MAX_VALUE)
					.addGap(22))
		);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/jieshao.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherNameTextField = new JTextField();
		editTeacherNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u6027\u522B.png")));
		
		editTeacherTitleTextField = new JTextField();
		editTeacherTitleTextField.setColumns(10);
		
		editTeacherSexManRadioButton = new JRadioButton("\u7537");
		editTeacherSexManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherSexFemaRadioButton = new JRadioButton("\u5973");
		editTeacherSexFemaRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(editTeacherSexManRadioButton);
		buttonGroup.add(editTeacherSexFemaRadioButton);
		
		JLabel label_3 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		label_3.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/zhicheng.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_4.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u5E74\u9F84.png")));
		
		editTeacherAgeTextField = new JTextField();
		editTeacherAgeTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_5.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherPasswordField = new JPasswordField();
		
		JButton editTeacherSubmitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editTeacherSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editTeacherAct(ae);
			}
		});
		editTeacherSubmitButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/querenlanse1.png")));
		editTeacherSubmitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		deleteTeacherButton = new JButton("\u5220\u9664\u4FE1\u606F");
		deleteTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteTeacher(ae);
			}
		});
		deleteTeacherButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/zhongzhilanse3.png")));
		deleteTeacherButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_5)
						.addComponent(label_1)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(editTeacherPasswordField)
						.addComponent(editTeacherTitleTextField)
						.addComponent(editTeacherNameTextField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addGap(18)
							.addComponent(editTeacherSexManRadioButton)
							.addGap(26)
							.addComponent(editTeacherSexFemaRadioButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(editTeacherSubmitButton)
							.addGap(14)
							.addComponent(deleteTeacherButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editTeacherAgeTextField)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(editTeacherSexManRadioButton)
						.addComponent(editTeacherSexFemaRadioButton))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(editTeacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(editTeacherPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editTeacherSubmitButton)
						.addComponent(deleteTeacherButton))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		teacherListTable = new JTable();
		teacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				selectedTableRow(ae);
			}
		});
		teacherListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08id", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u6027\u522B", "\u6559\u5E08\u804C\u79F0", "\u6559\u5E08\u5E74\u9F84", "\u767B\u5F55\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(teacherListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Teacher());
		setAuthority();
	}
	
	//修改老师信息
	protected void editTeacherAct(ActionEvent ae) {
		// TODO 自动生成的方法存根
		int row = teacherListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
		    return;
		}
		String teacherName = editTeacherNameTextField.getText().toString();
		String teacherSex = editTeacherSexManRadioButton.isSelected() ? editTeacherSexManRadioButton.getText().toString() : editTeacherSexFemaRadioButton.getText().toString();
		String teacherTitle = editTeacherTitleTextField.getText().toString();
		String teacherPassword = editTeacherPasswordField.getText().toString();
		int teacherAge = 0;
		try {
			teacherAge = Integer.parseInt(editTeacherAgeTextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
			return;
		}

		if(StringUtil.isEmpty(teacherName)){
			JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)){
			JOptionPane.showMessageDialog(this, "教师职称必须填写！");
			return;
		}
		if(teacherAge == 0 || teacherAge < 0 || teacherAge >100){
			JOptionPane.showMessageDialog(this, "教师年龄必须大于0小于100！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)){
			JOptionPane.showMessageDialog(this, "教师登录密码必须填写！");
			return;
		}
		
		
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(teacherListTable.getValueAt(row, 0).toString()));
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		TeacherCon teacherCon = new TeacherCon();
		if(teacherCon.update(teacher)){
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else{
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		teacherCon.closeCon();
		setTable(new Teacher());
	}

	
	protected void selectedTableRow(MouseEvent ae) {
		// TODO 自动生成的方法存根
		DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
		editTeacherNameTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 1).toString());
		editTeacherTitleTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 3).toString());
		editTeacherAgeTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 4).toString());
		editTeacherPasswordField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 5).toString());
		
		String sex = dft.getValueAt(teacherListTable.getSelectedRow(), 2).toString();
		
		if(sex.equals(editTeacherSexManRadioButton.getText()))
			editTeacherSexManRadioButton.setSelected(true);
		if(sex.equals(editTeacherSexFemaRadioButton.getText()))
			editTeacherSexFemaRadioButton.setSelected(true);
	}

	
	
	protected void deleteTeacher(ActionEvent ae) {
		// TODO 自动生成的方法存根
		int row = teacherListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要删除的数据！");
			return;
		}
		
		if(JOptionPane.showConfirmDialog(this, "确定要删除么？") != JOptionPane.OK_OPTION)
			return;
		int id = Integer.parseInt(teacherListTable.getValueAt(row, 0).toString());
		TeacherCon teacherCon = new TeacherCon();
		if(teacherCon.delete(id)){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		teacherCon.closeCon();
		setTable(new Teacher());
	}

	
	protected void searchTeacher(ActionEvent ae) {
		// TODO 自动生成的方法存根
		// TODO 自动生成的方法存根
		Teacher teacher = new Teacher();
		teacher.setName(searchTeacherNameTextField.getText().toString());
		setTable(teacher);
	}

	
	
	private void setTable(Teacher teacher){
		if("教师".equals(MainFrm.userType.getName())){
			Teacher tLogined = (Teacher) MainFrm.userObject;
			teacher.setName(tLogined.getName());
			searchTeacherNameTextField.setText(teacher.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
		//这是 TableModel 的一个实现，它使用一个 Vector 来存储单元格的值对象，该 Vector 由多个 Vector 组成
		dft.setRowCount(0);
		TeacherCon teacherCon = new TeacherCon();
		List<Teacher> teachertList = teacherCon.getTeacherList(teacher);
		for (Teacher t : teachertList) {
			Vector v = new Vector();
			v.add(t.getId());
			v.add(t.getName());
			v.add(t.getSex());
			v.add(t.getTitle());
			v.add(t.getAge());
			v.add(t.getPassword());
			dft.addRow(v);
		}
		teacherCon.closeCon();
	}
	
	
	
	
	
	
	
	private void setAuthority(){
		if("教师".equals(MainFrm.userType.getName())){
			deleteTeacherButton.setEnabled(false);
			searchTeacherNameTextField.setEditable(false);
		}
	}
	
	
}
