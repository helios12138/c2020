package cn.edu.zucc.supermark.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainPage extends JFrame {

	private JPanel contentPane;
	private static AdminMainPage adminMainPage;
	private AdminAddUser aau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMainPage = new AdminMainPage();
					//adminMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMainPage = new AdminMainPage();
					adminMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMainPage() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 846);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7528\u6237\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("用户信息维护");
		menu.add(menu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("新增用户信息");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		menu_2.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("维护用户信息");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUserInfo();
			}
		});
		menu_2.add(menuItem_2);
		
		JMenu menu_3 = new JMenu("配�?�地�?维护");
		menu.add(menu_3);
		
		JMenuItem menuItem_3 = new JMenuItem("新增配�?�地�?");
		menu_3.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("维护配�?�地�?");
		menu_3.add(menuItem_4);
		
		JMenu menu_10 = new JMenu("订单信息维护");
		menu.add(menu_10);
		
		JMenuItem menuItem_15 = new JMenuItem("新增订单信息");
		menu_10.add(menuItem_15);
		
		JMenuItem menuItem_16 = new JMenuItem("维护订单信息");
		menu_10.add(menuItem_16);
		
		JMenu mnNewMenu_1 = new JMenu("\u4F18\u60E0\u4FE1\u606F\u7BA1\u7406");
		
		menuBar.add(mnNewMenu_1);
		
		JMenu menu_4 = new JMenu("优惠券信息维�?");
		mnNewMenu_1.add(menu_4);
		
		JMenuItem menuItem_5 = new JMenuItem("新增优惠�?");
		menu_4.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("维护优惠券信�?");
		menu_4.add(menuItem_6);
		
		JMenu menu_8 = new JMenu("满折信息维护");
		mnNewMenu_1.add(menu_8);
		
		JMenuItem mntmXin = new JMenuItem("新增满折信息");
		menu_8.add(mntmXin);
		
		JMenuItem menuItem_12 = new JMenuItem("维护满折信息");
		menu_8.add(menuItem_12);
		
		JMenu menu_9 = new JMenu("促销信息维护");
		mnNewMenu_1.add(menu_9);
		
		JMenuItem menuItem_13 = new JMenuItem("新增促销信息");
		menu_9.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("维护促销信息");
		menu_9.add(menuItem_14);
		
		JMenu mnNewMenu = new JMenu("\u751F\u9C9C\u4FE1\u606F\u7BA1\u7406");
		
		menuBar.add(mnNewMenu);
		
		JMenu menu_5 = new JMenu("生鲜类别维护");
		mnNewMenu.add(menu_5);
		
		JMenuItem menuItem_7 = new JMenuItem("新增生鲜类别");
		menu_5.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("维护生鲜类别");
		menu_5.add(menuItem_8);
		
		JMenu menu_6 = new JMenu("商品信息维护");
		mnNewMenu.add(menu_6);
		
		JMenuItem menuItem_9 = new JMenuItem("新增商品");
		menu_6.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("维护商品信息");
		menu_6.add(menuItem_10);
		
		JMenu mnNewMenu_2 = new JMenu("\u7BA1\u7406\u5458\u4FE1\u606F\u7BA1\u7406");
		
		menuBar.add(mnNewMenu_2);
		
		JMenu menu_7 = new JMenu("管理员信息维�?");
		mnNewMenu_2.add(menu_7);
		
		JMenuItem mntmX = new JMenuItem("新增管理�?");
		menu_7.add(mntmX);
		
		JMenuItem menuItem_11 = new JMenuItem("管理员信息维�?");
		menu_7.add(menuItem_11);
		
		JMenu menu_1 = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		menu_1.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 707, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 439, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		//窗口居中
		this.setLocationRelativeTo(null);
		//窗口�?大化
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void exit() {
		// TODO Auto-generated method stub
		dispose();
		adminMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void updateUserInfo() {
		// TODO Auto-generated method stub
		AdminUpdateUser adminUpdateUser = new AdminUpdateUser();
		adminUpdateUser.setVisible(true);
		adminMainPage.getContentPane().add(adminUpdateUser);
	}

	private void addUser() {
		// TODO Auto-generated method stub
//		UserRegist ur = new UserRegist();
//		ur.setVisible(true);
		aau = new AdminAddUser();
		aau.setVisible(true);
		adminMainPage.getContentPane().add(aau);
	}

}
