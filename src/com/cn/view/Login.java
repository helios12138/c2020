package com.cn.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cn.dao.AdminDao;
import com.cn.dao.UserDao;
import com.cn.model.Admin;
import com.cn.model.User;
import com.cn.util.StringUtil;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JRadioButton adminButton;
	private JRadioButton userButton;
	private static Login frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
		setTitle("欢迎来到生鲜超市管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("生鲜网超管理系统");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/super.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));

		JLabel label = new JLabel("账号");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 14));

		username = new JTextField();
		username.setColumns(10);

		JLabel label_1 = new JLabel("密码");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/images/password.png")));
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));

		password = new JPasswordField();

		adminButton = new JRadioButton("管理员");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		userButton = new JRadioButton("用户");

		JButton button = new JButton("登录");
		button.setIcon(new ImageIcon(Login.class.getResource("/images/login.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		JButton btnNewButton = new JButton("注册");
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/images/register.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designUser();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(101)
					.addComponent(lblNewLabel)
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(10)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminButton))
					.addGap(55))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(130, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(120))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(adminButton)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(userButton)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		ButtonGroup group = new ButtonGroup();
		group.add(adminButton);
		group.add(userButton);

		// 居中显示
		this.setLocationRelativeTo(null);
	}

	private void login() {
		// TODO Auto-generated method stub
		String username = this.username.getText();
		String password = new String(this.password.getPassword());

		if (StringUtil.isNull(username)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空!");
			return;
		}

		if (StringUtil.isNull(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}

		if (this.adminButton.isSelected()) {
			Admin admin = new Admin(username, password);
			AdminDao adminDao = new AdminDao();
			if(adminDao.login(admin)){
				frame.setVisible(false);
				AdminMainPage adminMainPage = new AdminMainPage();
				adminMainPage.setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "管理员账户或密码错误，登录失败!");
			}
		}else if (this.userButton.isSelected()) {
			User user = new User(username, password);
			UserDao ud = new UserDao();
			if (ud.login(user)) {
				//dispose();
				frame.setVisible(false);
				UserMainPage userMainPage = new UserMainPage(user);
				userMainPage.setVisible(true);
			} else {
				
				JOptionPane.showMessageDialog(null, "用户账号或密码错误，登录失败!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "请选择用户类型!");
		}	
	}

	private void designUser() {
		// TODO Auto-generated method stub
		UserRegist ur = new UserRegist();
		ur.setVisible(true);
	}

}
