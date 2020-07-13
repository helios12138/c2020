package com.cn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cn.dao.UserDao;
import com.cn.model.User;
import com.cn.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UserInfoUpdate extends JInternalFrame {
	private JTextField username;
	private JTextField password;
	private JTextField phone;
	private JTextField email;
	private JTextField city;
	private JTextField sex;
	private JTextField signtime;
	private JTextField ismember;
	private JTextField membertime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfoUpdate frame = new UserInfoUpdate(null);
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
	public UserInfoUpdate(User user) {
		setIconifiable(true);
		setClosable(true);
		setTitle("个人信息维护");
		setBounds(100, 100, 289, 490);

		JLabel label = new JLabel("账号：");

		username = new JTextField();
		username.setEditable(false);
		username.setColumns(10);

		JLabel label_1 = new JLabel("密码：");

		password = new JTextField();
		password.setColumns(10);

		JLabel label_2 = new JLabel("电话：");

		phone = new JTextField();
		phone.setColumns(10);

		JLabel label_3 = new JLabel("邮箱：");

		email = new JTextField();
		email.setColumns(10);

		JLabel label_4 = new JLabel("城市：");

		city = new JTextField();
		city.setColumns(10);

		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});
		button.setIcon(new ImageIcon(UserInfoUpdate.class.getResource("/images/submit.png")));

		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(UserInfoUpdate.class.getResource("/images/reset.png")));

		JLabel label_5 = new JLabel("性别：");

		sex = new JTextField();
		sex.setEditable(false);
		sex.setColumns(10);

		JLabel label_6 = new JLabel("注册时间：");

		signtime = new JTextField();
		signtime.setEditable(false);
		signtime.setColumns(10);

		JLabel label_7 = new JLabel("是否会员：");

		ismember = new JTextField();
		ismember.setEditable(false);
		ismember.setColumns(10);

		JLabel label_8 = new JLabel("会员时间：");

		membertime = new JTextField();
		membertime.setEditable(false);
		membertime.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_4)
								.addComponent(label_3)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label_5)
								.addComponent(label_6)
								.addComponent(label_7)
								.addComponent(label_8))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(membertime)
								.addComponent(sex)
								.addComponent(city)
								.addComponent(email)
								.addComponent(phone)
								.addComponent(password, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(username, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(ismember)
								.addComponent(signtime, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(sex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(signtime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(ismember, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(membertime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(37))
		);
		getContentPane().setLayout(groupLayout);
		
		filltable(user.getUsername());
	}

	private void filltable(String name) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		ArrayList<User> list = userDao.getUser(name);
		if (list.size() != 0){
			this.username.setText(list.get(0).getUsername());
			this.password.setText(list.get(0).getPassword());
			this.phone.setText(list.get(0).getPhone());
			this.email.setText(list.get(0).getEmail());
			this.city.setText(list.get(0).getCity());
			this.sex.setText(list.get(0).getSex());
			this.signtime.setText(String.valueOf(list.get(0).getSigntime()));
			this.ismember.setText(list.get(0).getIsmember());
			this.membertime.setText(String.valueOf(list.get(0).getMembertime()));
		}	
	}

	private void updateUser() {
		// TODO Auto-generated method stub
		String username = this.username.getText();
		String password = this.password.getText();
		String phone = this.phone.getText();
		String email = this.email.getText();
		String city = this.city.getText();

		if (StringUtil.isNull(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}

		if (StringUtil.isNull(phone)) {
			JOptionPane.showMessageDialog(null, "电话不能为空!");
			return;
		}

		if (StringUtil.isNull(email)) {
			JOptionPane.showMessageDialog(null, "邮箱不能为空!");
			return;
		}

		if (StringUtil.isNull(city)) {
			JOptionPane.showMessageDialog(null, "城市不能为空!");
			return;
		}

		User user = new User(username, password, phone, email, city);
		UserDao ud = new UserDao();
		int num = ud.updateUser1(user);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.password.setText("");
		this.phone.setText("");
		this.email.setText("");
		this.city.setText("");
	}

}
