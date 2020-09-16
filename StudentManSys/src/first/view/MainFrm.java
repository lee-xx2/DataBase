package first.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import first.model.UserType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.URI;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuItem addStudentMenuItem;
	private JMenuItem addClassMenuItem;
	private JMenuItem addTeacherMenuItem;
	private JMenu manageStudentMenu;
	private JMenu manageClassMenu;
	private JMenu manageTeacherMenu;
	public static UserType userType;
	public static Object userObject;
	
	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm(UserType userType,Object userObject) {
		setFont(new Font("΢���ź�", Font.PLAIN, 14));
		this.userType=userType;
		this.userObject=userObject;
		setTitle("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 751);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//ϵͳ����
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);
		JMenuItem menuItem1 = new JMenuItem("\u9000\u51fa\u7cfb\u7edf");
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "ȷ���˳���") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menuItem1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51FA.png")));
		menu.add(menuItem1);
		
		
		//ѧ������
	    manageStudentMenu = new JMenu("\u5B66\u751F\u7BA1\u7406");
		manageStudentMenu.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		manageStudentMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		menuBar.add(manageStudentMenu);
		
		addStudentMenuItem = new JMenuItem("\u6dfb\u52a0\u5b66\u751f");//���ѧ��
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				AddClass(ae);
			}
		});
		addStudentMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		manageStudentMenu.add(addStudentMenuItem);
		
		
		
		JMenuItem menuItem3 = new JMenuItem("\u5b66\u751f\u5217\u8868");//ѧ���б�
		menuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  ManageStudentFrm manageStudentFrm = new ManageStudentFrm();
				manageStudentFrm.setVisible(true);
				desktopPane.add(manageStudentFrm);
			}
		});
		menuItem3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menuItem3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		manageStudentMenu.add(menuItem3);
		
		
		
		//�༶����
		manageClassMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		manageClassMenu.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		manageClassMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(manageClassMenu);
		
		addClassMenuItem = new JMenuItem("\u6dfb\u52a0\u73ed\u7ea7");//��Ӱ༶
		addClassMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudentClass(ae);
			}
		});
		addClassMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		addClassMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		manageClassMenu.add(addClassMenuItem);
		JMenuItem menuItem5 = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");//�༶�б�
		menuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageClassFrm manageClassFrm = new ManageClassFrm();
				manageClassFrm.setVisible(true);
				desktopPane.add(manageClassFrm);
			}
		});
		menuItem5.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menuItem5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		manageClassMenu.add(menuItem5);
		
		//��ʦ����
		manageTeacherMenu = new JMenu("\u6559\u5E08\u7BA1\u7406");
		manageTeacherMenu.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		manageTeacherMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8001\u5E08.png")));
		menuBar.add(manageTeacherMenu);
		
		addTeacherMenuItem = new JMenuItem("\u6dfb\u52a0\u6559\u5e08");//��ӽ�ʦ
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addTeacher(ae);
			}
		});
		addTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		addTeacherMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		JMenuItem menuItem9 = new JMenuItem("\u6559\u5e08\u5217\u8868");//��ʦ�б�
		menuItem9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Ae) {
				ManageTeacherFrm manageTeacherFrm = new ManageTeacherFrm();
				manageTeacherFrm.setVisible(true);
				desktopPane.add(manageTeacherFrm);
			}
		});
		menuItem9.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		menuItem9.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		manageTeacherMenu.add(addTeacherMenuItem);
		manageTeacherMenu.add(menuItem9);
		
		
		
		//����
		JMenu menu_2 = new JMenu("\u5E2E\u52A9");
		menu_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5E2E\u52A9.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem6 = new JMenuItem("\u5173\u4e8e\u6211\u4eec");//��������
		menuItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}

		});
		menuItem6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menu_2.add(menuItem6);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(220, 220, 220));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setAuthority();
	}

	

	protected void AddClass(ActionEvent ae) {
		// TODO �Զ����ɵķ������
		AddStudentFrm addStudentFrm = new AddStudentFrm();
		addStudentFrm.setVisible(true);
		desktopPane.add(addStudentFrm);
	}



	protected void addTeacher(ActionEvent ae) {
		// TODO �Զ����ɵķ������
		AddTeacherFrm sca = new AddTeacherFrm();
		sca.setVisible(true);
		desktopPane.add(sca);
	}



	protected void addStudentClass(ActionEvent ae) {
		// TODO �Զ����ɵķ������
		AddClassFrm sca = new AddClassFrm();
		sca.setVisible(true);
		desktopPane.add(sca);
	}



	protected void editPassword(ActionEvent ae) {
		// TODO �Զ����ɵķ������
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
		}



	private void aboutUs(ActionEvent ae) {
		// TODO �Զ����ɵķ������
		//JOptionPane.showMessageDialog(this, "���ݿ�γ���ƣ�");
		String info = "�㶫��ҵ��ѧ\n";
		info += "У԰��ַ��http://www.gdut.edu.cn/";
		String[] buttons = {"ȥ����!","������!"};
		int ret = JOptionPane.showOptionDialog(this, info, "��������", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(Login.class.getResource("/images/xuesheng.png")), buttons, null);
		if(ret == 0){
			//Java ����ϵͳ�����
			try {
				URI uri = new URI("http://www.gdut.edu.cn/");
				Desktop.getDesktop().browse(uri);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(this, "�ðɣ�");
		}
	}
	
	private void setAuthority() {
		if("ѧ��".equals(userType.getName())) {
			addStudentMenuItem.setEnabled(false);
			manageClassMenu.setEnabled(false);
			manageTeacherMenu.setEnabled(false);
		}
		if("��ʦ".equals(userType.getName())){
			addTeacherMenuItem.setEnabled(false);
			manageStudentMenu.setEnabled(false);
			manageClassMenu.setEnabled(false);
		}
	}
}
