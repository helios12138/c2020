package com.cn.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.ShoppingAddDao;
import com.cn.dao.UserDao;
import com.cn.model.ShippingAddress;
import com.cn.model.User;
import com.cn.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserUpdateAddress extends JInternalFrame {
	private JTable addresstable;
	private JTextField textuserid;
	private JTextField textprovince;
	private JTextField textcity;
	private JTextField textarea;
	private JTextField textaddress;
	private JTextField textusername;
	private JTextField textphone;
	private JTextField textaddressid;
	private String username;
	private User newuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUpdateAddress frame = new UserUpdateAddress(null);
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
	public UserUpdateAddress(User user) {
		setIconifiable(true);
		setClosable(true);
		setTitle("修改我的收货地址");
		setBounds(100, 100, 915, 577);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 726, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		
		JLabel lblid = new JLabel("用户ID：");
		
		textuserid = new JTextField();
		textuserid.setEditable(false);
		textuserid.setColumns(10);
		
		JLabel label = new JLabel("省  份：");
		
		textprovince = new JTextField();
		textprovince.setColumns(10);
		
		JLabel label_1 = new JLabel("城  市：");
		
		textcity = new JTextField();
		textcity.setColumns(10);
		
		JLabel label_2 = new JLabel("地  区：");
		
		textarea = new JTextField();
		textarea.setColumns(10);
		
		JLabel label_3 = new JLabel("详细地址：");
		
		textaddress = new JTextField();
		textaddress.setColumns(10);
		
		JLabel label_4 = new JLabel("联 系 人：");
		
		textusername = new JTextField();
		textusername.setEditable(false);
		textusername.setColumns(10);
		
		JLabel label_5 = new JLabel("电    话：");
		
		textphone = new JTextField();
		textphone.setColumns(10);
		
		JLabel lblId = new JLabel("地 址 ID：");
		
		textaddressid = new JTextField();
		textaddressid.setEditable(false);
		textaddressid.setColumns(10);
		
		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatepickrow();
			}
		});
		button.setIcon(new ImageIcon(UserUpdateAddress.class.getResource("/images/submit.png")));
		
		JButton button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delpickrow();
			}
		});
		button_1.setIcon(new ImageIcon(UserUpdateAddress.class.getResource("/images/删除(1).png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addComponent(lblid)
							.addGap(9)
							.addComponent(textuserid, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textcity, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
										.addComponent(textprovince)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textarea, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))))
					.addGap(61)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addGap(7)
							.addComponent(textaddress, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(67, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addComponent(label_5)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textphone))
									.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addComponent(label_4)
										.addGap(8)
										.addComponent(textusername, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblId)
									.addGap(10)
									.addComponent(textaddressid, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(63)
									.addComponent(button))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(61)
									.addComponent(button_1)))
							.addGap(72))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(32)
									.addComponent(lblid))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textuserid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_3))))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(20)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textprovince, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_1)
										.addComponent(textcity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_2)
										.addComponent(textarea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(23)
									.addComponent(label_4)
									.addGap(24)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_5)
										.addComponent(textphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(18)
											.addComponent(lblId))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(15)
											.addComponent(textaddressid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(textaddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(20)
									.addComponent(textusername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(26))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
									.addComponent(button)
									.addGap(26)))
							.addGap(25)))
					.addContainerGap(9, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(130, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(23))
		);
		panel.setLayout(gl_panel);
		
		addresstable = new JTable();
		addresstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickrow();
			}
		});
		addresstable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5730\u5740ID", "\u7528\u6237ID", "\u7701\u4EFD", "\u57CE\u5E02", "\u5730\u533A", "\u8BE6\u7EC6\u5730\u5740", "\u8054\u7CFB\u4EBA", "\u8054\u7CFB\u7535\u8BDD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(addresstable);
		getContentPane().setLayout(groupLayout);
		
		if (user != null){
			fillTable(user.getUsername());
			username = user.getUsername();
			
			UserDao userDao = new UserDao();
			ArrayList<User> list = userDao.getUser(username);
			if (list.size() != 0){
				newuser = list.get(0);
			}
		}	
	}

	private void updatepickrow() {
		// TODO Auto-generated method stub
		String province = this.textprovince.getText();
		if(StringUtil.isNull(province)){
			JOptionPane.showMessageDialog(null, "省份不能为空!");
			return;
		}
		
		String city = this.textcity.getText();
		if(StringUtil.isNull(city)){
			JOptionPane.showMessageDialog(null, "省份不能为空!");
			return;
		}
		String area = this.textarea.getText();
		if(StringUtil.isNull(area)){
			JOptionPane.showMessageDialog(null, "地区不能为空!");
			return;
		}
		String address = this.textaddress.getText();
		if(StringUtil.isNull(address)){
			JOptionPane.showMessageDialog(null, "详细地址不能为空!");
			return;
		}
		String phone = this.textphone.getText();
		if(StringUtil.isNull(phone)){
			JOptionPane.showMessageDialog(null, "电话不能为空!");
			return;
		}
		
		String username = this.textusername.getText();
		String addressid = this.textaddressid.getText();
		
		
		ShippingAddress shippingAddress = new ShippingAddress(Integer.parseInt(addressid), "", province, city, area, address, username, phone);
		ShoppingAddDao sad = new ShoppingAddDao(); 
		if (sad.updtate(shippingAddress) != 0){
			JOptionPane.showMessageDialog(null, "修改成功！");
			if (newuser != null){
				fillTable(newuser.getUsername());
			}else {
				fillTable("");
			}
		}else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
	}

	private void delpickrow() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该地址信息？");
		if (result == 0) {
			String id = this.textaddressid.getText();
			ShoppingAddDao sad = new ShoppingAddDao();
			sad.delAdd(Integer.parseInt(id));
			if (newuser != null){
				fillTable(newuser.getUsername());
			}else {
				fillTable("");
			}			
			initTable();
		}
	}

	private void initTable() {
		// TODO Auto-generated method stub
		
	}

	private void pickrow() {
		// TODO Auto-generated method stub
		int row = addresstable.getSelectedRow();
		this.textuserid.setText((String) addresstable.getValueAt(row, 1));
		this.textprovince.setText((String) addresstable.getValueAt(row, 2));
		this.textcity.setText((String) addresstable.getValueAt(row, 3));
		this.textarea.setText((String) addresstable.getValueAt(row, 4));
		this.textaddress.setText((String) addresstable.getValueAt(row, 5));
		this.textusername.setText((String) addresstable.getValueAt(row, 6));
		this.textphone.setText((String) addresstable.getValueAt(row, 7));
		this.textaddressid.setText((String) addresstable.getValueAt(row, 0));
	}

	private void fillTable(String username) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) addresstable.getModel();
		dtm.setRowCount(0);

		ShoppingAddDao sad = new ShoppingAddDao();
		ArrayList<ShippingAddress> list = sad.getAdd(username);

		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getUserid());
			v.add(list.get(i).getProvince());
			v.add(list.get(i).getCity());
			v.add(list.get(i).getArea());
			v.add(list.get(i).getAddress());
			v.add(list.get(i).getUsername());
			v.add(list.get(i).getPhone());

			dtm.addRow(v);
		}
	}
}
