package cn.edu.zucc.supermark.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.supermark.a.UserDao;
import cn.edu.zucc.supermark.model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class UserMainPage extends JFrame {

	private JPanel contentPane;
	private static UserMainPage frame;
	private JDesktopPane table = null;
	private String username;
	private String password;
	private User newuser;
	
	/**
	 * Launch the application.
	 */
	
	
	
	static{
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserMainPage(null);
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
	public UserMainPage(User user) {
		setTitle("\u7528\u6237\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 746);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u751F\u9C9C\u91C7\u8D2D");
		menu.setIcon(new ImageIcon(UserMainPage.class.getResource("/images/\u8D2D\u7269.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("采购");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBuy userBuy = new UserBuy(user);
				userBuy.setVisible(true);
				table.add(userBuy);
			}
		});
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("\u8BA2\u5355\u67E5\u8BE2");
		menu_1.setIcon(new ImageIcon(UserMainPage.class.getResource("/images/\u8BA2\u5355.png")));
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		menu_2.setIcon(new ImageIcon(UserMainPage.class.getResource("/images/\u7528\u6237\u4FE1\u606F.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("个人信息维护");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfoUpdate userInfoUpdate = new UserInfoUpdate(newuser);
				userInfoUpdate.setVisible(true);
				table.add(userInfoUpdate);
			}
		});
		menu_2.add(menuItem_1);
		
		JMenu menu_3 = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		menu_3.setIcon(new ImageIcon(UserMainPage.class.getResource("/images/exit.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		menuItem.setIcon(new ImageIcon(UserMainPage.class.getResource("/images/exit.png")));
		menu_3.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(new Color(0, 128, 128));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		table.setLayout(null);
		
		//窗口居中
		this.setLocationRelativeTo(null);
		
		// 窗口最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		if (user != null){
			username = user.getUsername();
			password = user.getPassword();
		}
		
		UserDao userDao = new UserDao();
		ArrayList<User> list = userDao.getUser(username);
		if (list.size() != 0){
			newuser = list.get(0);
		}
	}

	private void exit() {
		// TODO Auto-generated method stub
		dispose();
	}
}
