package first.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import first.connect.ClassCon;
import first.connect.StudentCon;
import first.model.Student;
import first.model.StudentClass;
import first.util.StringUtil;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageStudentFrm extends JInternalFrame {
	private JTextField searchStudentNameTextField;
	private JTable studentListTable;
	private JTextField editStudentNameTextField;
	private JPasswordField editStudentPasswordField;
	private JButton submitEditButton;
	private JComboBox editStudentClassComboBox;
	private JComboBox searchStudentClassComboBox;
	private List<StudentClass> studentClassList;
	private JRadioButton editStudentSexManRadioButton;
	private JRadioButton editStudentSexFemaRadioButton;
	private JRadioButton editStudentSexUnknowRadioButton;
	private ButtonGroup editSexButtonGroup;
	private JButton searchButton;
	private JButton deleteStudentButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentFrm frame = new ManageStudentFrm();
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
	public ManageStudentFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 790, 539);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_1.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchButton = new JButton("\u67E5\u627E");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchStudent(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u641C\u7D22.png")));
		
		searchStudentClassComboBox = new JComboBox();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStudentNameTextField = new JTextField();
		editStudentNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u73ED\u7EA7\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_3.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		
		editStudentClassComboBox = new JComboBox();
		
		JLabel label_4 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_4.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStudentPasswordField = new JPasswordField();
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/xingbie.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStudentSexManRadioButton = new JRadioButton("\u7537");
		editStudentSexManRadioButton.setSelected(true);
		editStudentSexManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStudentSexFemaRadioButton = new JRadioButton("\u5973");
		editStudentSexFemaRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStudentSexUnknowRadioButton = new JRadioButton("\u4FDD\u5BC6");
		editStudentSexUnknowRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editSexButtonGroup = new ButtonGroup();
		editSexButtonGroup.add(editStudentSexManRadioButton);
		editSexButtonGroup.add(editStudentSexFemaRadioButton);
		editSexButtonGroup.add(editStudentSexUnknowRadioButton);
		
		
		submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/querenlanse1.png")));
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		deleteStudentButton = new JButton("\u786E\u8BA4\u5220\u9664");
		deleteStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteStudent(ae);
				
			}
		});
		deleteStudentButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		deleteStudentButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u5220\u9664.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentClassComboBox, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editStudentClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_4)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(editStudentPasswordField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(editStudentSexManRadioButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editStudentSexFemaRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editStudentSexUnknowRadioButton)))
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteStudentButton)
								.addComponent(submitEditButton)))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchStudentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(33)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(editStudentPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_3)
							.addComponent(editStudentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(editStudentSexManRadioButton)
							.addComponent(editStudentSexFemaRadioButton)
							.addComponent(editStudentSexUnknowRadioButton)
							.addComponent(deleteStudentButton)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		
		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {     //鼠标点击表格中某一行事件
				selectedTableRow(ae);
			}
		});
		studentListTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u5B66\u751F\u73ED\u7EA7", "\u767B\u5F55\u5BC6\u7801", "\u5B66\u751F\u6027\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(studentListTable);
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
		setTable(new Student() );
		setAuthority();
	}
	
	
	protected void submitEditAct(ActionEvent ae) {
		// TODO 自动生成的方法存根
		int row = studentListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String studentName = editStudentNameTextField.getText().toString();
		String studentPassword = editStudentPasswordField.getText().toString();
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "请填写学生姓名！");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(this, "请填写密码！");
			return;
		}
		
		Student student = new Student();
		student.setName(studentName);
		student.setPassword(studentPassword);
		StudentClass sc = (StudentClass)editStudentClassComboBox.getSelectedItem();
		student.setClassId(sc.getId());
		student.setId(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()));
		if(editStudentSexManRadioButton.isSelected())
			student.setSex(editStudentSexManRadioButton.getText().toString());
		if(editStudentSexFemaRadioButton.isSelected())
			student.setSex(editStudentSexFemaRadioButton.getText().toString());
		if(editStudentSexUnknowRadioButton.isSelected())
			student.setSex(editStudentSexUnknowRadioButton.getText().toString());
		
		StudentCon studentCon = new StudentCon();
		if(studentCon.update(student)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		
		studentCon.closeCon();
		setTable(new Student());
		
	}

	protected void selectedTableRow(MouseEvent ae) {
		// TODO 自动生成的方法存根
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		editStudentNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 1).toString());
		editStudentPasswordField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 3).toString());
		String className = dft.getValueAt(studentListTable.getSelectedRow(), 2).toString();
		for(int i=0;i<editStudentClassComboBox.getItemCount();i++){
			StudentClass sc = (StudentClass)editStudentClassComboBox.getItemAt(i);
			if(className.equals(sc.getName())){
				editStudentClassComboBox.setSelectedIndex(i);
			}
		}
		String sex = dft.getValueAt(studentListTable.getSelectedRow(), 4).toString();
		editSexButtonGroup.clearSelection();
		if(sex.equals(editStudentSexManRadioButton.getText()))
			editStudentSexManRadioButton.setSelected(true);
		if(sex.equals(editStudentSexFemaRadioButton.getText()))
			editStudentSexFemaRadioButton.setSelected(true);
		if(sex.equals(editStudentSexUnknowRadioButton.getText()))
			editStudentSexUnknowRadioButton.setSelected(true);
	}

	protected void deleteStudent(ActionEvent ae) {
		// TODO 自动生成的方法存根
		int row = studentListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		StudentCon studentCon = new StudentCon();
		if(studentCon.delete(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		studentCon.closeCon();
		setTable(new Student());
	}
	

	protected void searchStudent(ActionEvent ae) {
		// TODO 自动生成的方法存根
		Student student = new Student();
		student.setName(searchStudentNameTextField.getText().toString());
		StudentClass sc = (StudentClass)searchStudentClassComboBox.getSelectedItem();
		student.setClassId(sc.getId());
		setTable(student);
	}

	
	
	private void setTable(Student student){
		if("学生".equals(MainFrm.userType.getName())){
			Student s = (Student)MainFrm.userObject;
			student.setName(s.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		//这是 TableModel 的一个实现，它使用一个 Vector 来存储单元格的值对象，该 Vector 由多个 Vector 组成
		dft.setRowCount(0);
		StudentCon studentCon = new StudentCon();
		List<Student> studentList = studentCon.getStudentList(student);
		for (Student s : studentList) {
			Vector v = new Vector();
			v.add(s.getId());
			v.add(s.getName());
			v.add(getClassNameById(s.getClassId()));
			v.add(s.getPassword());
			v.add(s.getSex());
			dft.addRow(v);
		}
		studentCon.closeCon();
	}
	
	
	private void setStudentClassInfo(){
		//从数据库里获取班级列表，遍历列表，将值添加（默认调用toString方法的结果作为复选框里的值）到复选框里
		ClassCon classCon = new ClassCon();
		studentClassList = classCon.getClassList(new StudentClass());
		for (StudentClass sc : studentClassList) {
			searchStudentClassComboBox.addItem(sc);
			editStudentClassComboBox.addItem(sc);
		}
		classCon.closeCon();
	}
	
	
	
	private String getClassNameById(int id){
		for (StudentClass sc : studentClassList) {
			if(sc.getId() == id)
				return sc.getName();
		}
		return "";
}
	
	
	private void setAuthority() {
		if("学生".equals(MainFrm.userType.getName())) {
			Student s= (Student)MainFrm.userObject;
			searchStudentNameTextField.setText(s.getName());
			searchStudentNameTextField.setEnabled(false);
			deleteStudentButton.setEnabled(false);
			
			for(int i=0;i<searchStudentClassComboBox.getItemCount();i++){
				StudentClass sc = (StudentClass) searchStudentClassComboBox.getItemAt(i);
				if(sc.getId() == s.getClassId()){
					searchStudentClassComboBox.setSelectedIndex(i);
					break;
				}
			}
			searchStudentClassComboBox.setEnabled(false);
			
			for(int i=0;i<editStudentClassComboBox.getItemCount();i++){
				StudentClass sc = (StudentClass) editStudentClassComboBox.getItemAt(i);
				if(sc.getId() == s.getClassId()){
					editStudentClassComboBox.setSelectedIndex(i);
					break;
				}
			}
			editStudentClassComboBox.setEnabled(false);
		}
	}
	
	
}
