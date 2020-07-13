package com.cn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cn.dao.ShoppingAddDao;
import com.cn.dao.UserDao;
import com.cn.model.ShippingAddress;
import com.cn.model.User;
import com.cn.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UserAddAddress extends JInternalFrame {
	private JTextField userid;
	private JTextField province;
	private JTextField city;
	private JTextField area;
	private JTextField address;
	private JTextField username;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddAddress frame = new UserAddAddress(null);
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
	public UserAddAddress(User user) {
		setTitle("新增收货地址");
		setBounds(100, 100, 306, 425);

		JLabel lblid = new JLabel("用 户 ID:");

		userid = new JTextField();
		userid.setEditable(false);
		userid.setColumns(10);

		JLabel label = new JLabel("省    份：");

		province = new JTextField();
		province.setColumns(10);

		JLabel label_1 = new JLabel("城    市：");

		city = new JTextField();
		city.setColumns(10);

		JLabel lblNewLabel = new JLabel("地    区：");

		area = new JTextField();
		area.setColumns(10);

		JLabel label_2 = new JLabel("地    址：");

		address = new JTextField();
		address.setColumns(10);

		JLabel label_3 = new JLabel("联 系 人：");

		username = new JTextField();
		username.setEditable(false);
		username.setColumns(10);

		JLabel label_4 = new JLabel("联系电话：");

		phone = new JTextField();
		phone.setColumns(10);

		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addShoppingAddress();
			}
		});
		button.setIcon(new ImageIcon(UserAddAddress.class.getResource("/images/submit.png")));

		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(UserAddAddress.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING, false).addGroup(groupLayout
														.createSequentialGroup().addGap(44).addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(label_1).addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(city))
																.addGroup(
																		groupLayout
																				.createSequentialGroup()
																				.addGroup(
																						groupLayout
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addComponent(lblid)
																								.addComponent(label))
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addGroup(groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(province)
																						.addComponent(userid,
																								GroupLayout.DEFAULT_SIZE,
																								127,
																								Short.MAX_VALUE)))))
												.addGroup(groupLayout.createSequentialGroup().addGap(43)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(label_2)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(address, GroupLayout.DEFAULT_SIZE,
																				128, Short.MAX_VALUE))
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblNewLabel)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(area))
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(label_3).addGap(3).addComponent(
																				username, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))))
										.addGroup(groupLayout.createSequentialGroup().addGap(43)
												.addComponent(label_4).addGap(3).addComponent(phone,
														GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(53).addComponent(button)
												.addGap(41).addComponent(button_1)))
										.addContainerGap(45, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(40)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid).addComponent(userid,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(province,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup().addGap(16).addComponent(city,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(16)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel).addComponent(
						area, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2).addComponent(
						address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup().addGap(16).addComponent(username,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(20).addComponent(label_4))
						.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(phone,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(37).addComponent(button))
						.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(button_1)))
				.addContainerGap(93, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

		if (user != null) {
			this.userid.setText(String.valueOf(user.getId()));
			this.username.setText(user.getUsername());
		}
	}

	private void addShoppingAddress() {
		// TODO Auto-generated method stub
		String userid = this.userid.getText();
		String province = this.province.getText();
		String city = this.city.getText();
		String area = this.area.getText();
		String address = this.address.getText();
		String username = this.username.getText();
		String phone = this.phone.getText();

		if (StringUtil.isNull(userid)) {
			JOptionPane.showMessageDialog(null, "用户ID不能为空!");
			return;
		} else {
			if (!StringUtil.isNumeric(userid)) {
				JOptionPane.showMessageDialog(null, "用户ID必须为数字!");
				return;
			}
		}

		if (StringUtil.isNull(province)) {
			JOptionPane.showMessageDialog(null, "省份不能为空!");
			return;
		}

		if (StringUtil.isNull(city)) {
			JOptionPane.showMessageDialog(null, "城市不能为空!");
			return;
		}

		if (StringUtil.isNull(area)) {
			JOptionPane.showMessageDialog(null, "地区不能为空!");
			return;
		}

		if (StringUtil.isNull(address)) {
			JOptionPane.showMessageDialog(null, "详细地址不能为空!");
			return;
		}

		if (StringUtil.isNull(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空!");
			return;
		} else {
			UserDao ud = new UserDao();
			ArrayList<User> list = ud.getUser(username);
			if (list.size() == 0) {
				JOptionPane.showMessageDialog(null, "该用户不存在，添加失败!");
				return;
			} else {
				if (Integer.parseInt(userid) != list.get(0).getId()) {
					JOptionPane.showMessageDialog(null, "用户名和id不匹配，添加失败!");
					return;
				}
			}
		}

		if (StringUtil.isNull(phone)) {
			JOptionPane.showMessageDialog(null, "联系电话不能为空!");
			return;
		}

		ShippingAddress shippingAddress = new ShippingAddress(0, userid, province, city, area, address, username,
				phone);

		ShoppingAddDao sad = new ShoppingAddDao();
		int num = sad.addAdd(shippingAddress);

		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功！");
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "新增失败！");
		}
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.province.setText("");
		this.city.setText("");
		this.area.setText("");
		this.address.setText("");
		//this.username.setText("");
		this.phone.setText("");
	}
}
