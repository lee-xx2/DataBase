package first.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import first.connect.ClassCon;
import first.model.StudentClass;
import first.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageClassFrm extends JInternalFrame {
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClassFrm frame = new ManageClassFrm();
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
	public ManageClassFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 734, 557);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/mingcheng.png")));
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentClass sc = new StudentClass();
				sc.setName(searchClassNameTextField.getText().toString());
				setTable(sc);
			}
		});
		searchButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		searchButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/chaxun.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/mingcheng.png")));
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label_1.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/jieshao.png")));
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setColumns(10);
		
		editClassInfoTextArea = new JTextArea();
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEdit(ae);
			}
		});
		submitEditButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		submitEditButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/querenlanse1.png")));
		
		JButton submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteClassAct(ae);
			}
		});
		submitDeleteButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/shanchu1.png")));
		submitDeleteButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editClassNameTextField)))
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(submitDeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(submitEditButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(searchButton)))))
					.addContainerGap(86, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(submitDeleteButton)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		classListTable.getColumnModel().getColumn(2).setPreferredWidth(278);
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new StudentClass());
	}
	
	
	
	protected void submitEdit (ActionEvent ae) {
		// TODO �Զ����ɵķ������
		ClassCon classCon = new ClassCon();
		int index = classListTable.getSelectedRow();//���ص�һ��ѡ���е����������û��ѡ�����У��򷵻� -1�� 
		if(index == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ�����!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		String className = dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo = dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
		String editClassName = editClassNameTextField.getText().toString();
		String editClassInfo = editClassInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editClassName)){
			JOptionPane.showMessageDialog(this, "����дҪ�޸ĵ�����!");
			return;
		}
		if(className.equals(editClassName) && classInfo.equals(editClassInfo)){
			JOptionPane.showMessageDialog(this, "����û�����κ��޸�!");
			return;
		}
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		StudentClass sc = new StudentClass();
		sc.setId(id);
		sc.setName(editClassName);
		sc.setInfo(editClassInfo);
		if(classCon.update(sc)){
			JOptionPane.showMessageDialog(this, "���³ɹ�!");
		}else{
			JOptionPane.showMessageDialog(this, "����ʧ��!");
		}
		classCon.closeCon();
		setTable(new StudentClass());
	}

	protected void deleteClassAct(ActionEvent ae) {
		// TODO �Զ����ɵķ������
		if(JOptionPane.showConfirmDialog(this, "��ȷ��ɾ��ô��") != JOptionPane.OK_OPTION){
			return;
		}
		int index = classListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ��������!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		ClassCon classCon = new ClassCon();
		if(classCon.delete(id)){
			JOptionPane.showMessageDialog(this, "ɾ���ɹ�!");
		}else{
			JOptionPane.showMessageDialog(this, "ɾ��ʧ��!");
		}
		classCon.closeCon();
		setTable(new StudentClass());
	}
	

	protected void selectedTableRow(MouseEvent me) {
		// TODO �Զ����ɵķ������
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());
		
		
		
	}

	private void setTable(StudentClass studentClass){
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		//���� TableModel ��һ��ʵ�֣���ʹ��һ�� Vector ���洢��Ԫ���ֵ���󣬸� Vector �ɶ�� Vector ���
		dft.setRowCount(0);
		ClassCon classCon = new ClassCon();
		List<StudentClass> classList = classCon.getClassList(studentClass);
		for (StudentClass sc : classList) {
			//��������
			/*for������{����}����Ǹ�JDK1.5����ǿforѭ��Ҳ��for-each.��Ϊ�˷�����������collection��.
			 * List<String> list=new ArrayList<String>();
               	list.add("a");
				list.add("b");
				list.add("c");
				for (String str : list) {
				System.out.println(str);
					}

		�������飬ʾ����
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] =2;
		arr[2] = 3;
		for(int i : arr){
		System.out.println(i);
		} 
			 * */
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);
		}
		classCon.closeCon();
	}
}
