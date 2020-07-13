package com.cn.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.DefaultRowSorter;
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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class AdminUpdateShopAddress extends JInternalFrame {
	private JTable addresstable;
	private JTextField findusername;
	private JTextField textuserid;
	private JTextField textprovince;
	private JTextField textcity;
	private JTextField textarea;
	private JTextField textaddress;
	private JTextField textusername;
	private JTextField textphone;
	private JTextField textaddressid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateShopAddress frame = new AdminUpdateShopAddress();
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
	public AdminUpdateShopAddress() {
		setIconifiable(true);
		setClosable(true);
		setTitle("维护地址信息");
		setBounds(100, 100, 752, 563);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("联系人：");

		findusername = new JTextField();
		findusername.setColumns(10);

		JButton button = new JButton("查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findaddress();
			}
		});
		button.setIcon(new ImageIcon(AdminUpdateShopAddress.class.getResource("/images/搜索.png")));

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(101).addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(findusername, GroupLayout.PREFERRED_SIZE, 161,
												GroupLayout.PREFERRED_SIZE)
										.addGap(20).addComponent(button).addContainerGap(325, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addContainerGap(63, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														617, Short.MAX_VALUE))
										.addGap(56)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(33, Short.MAX_VALUE).addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(38).addComponent(label))
										.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(
												findusername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(25))
						.addGroup(groupLayout.createSequentialGroup().addComponent(button).addGap(24)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addGap(35).addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addGap(45)));

		JLabel lblid = new JLabel("用户id：");

		textuserid = new JTextField();
		textuserid.setEditable(false);
		textuserid.setColumns(10);

		JLabel label_1 = new JLabel("省  份：");

		textprovince = new JTextField();
		textprovince.setColumns(10);

		JLabel label_2 = new JLabel("城  市：");

		textcity = new JTextField();
		textcity.setColumns(10);

		JLabel label_3 = new JLabel("地  区：");

		textarea = new JTextField();
		textarea.setColumns(10);

		JLabel label_4 = new JLabel("详细地址：");

		textaddress = new JTextField();
		textaddress.setColumns(10);

		JLabel label_5 = new JLabel("联 系 人：");

		textusername = new JTextField();
		textusername.setEditable(false);
		textusername.setColumns(10);

		JLabel label_6 = new JLabel("电    话：");

		textphone = new JTextField();
		textphone.setColumns(10);

		JButton button_1 = new JButton("修改");
		button_1.setIcon(new ImageIcon(AdminUpdateShopAddress.class.getResource("/images/submit.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatepickrow();
			}
		});

		JButton button_2 = new JButton("删除");
		button_2.setIcon(new ImageIcon(AdminUpdateShopAddress.class.getResource("/images/删除(1).png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delpickrow();
			}
		});
		
		JLabel lblid_1 = new JLabel("地 址 id：");
		
		textaddressid = new JTextField();
		textaddressid.setEditable(false);
		textaddressid.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addGap(3)
									.addComponent(textcity, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textprovince))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblid)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textuserid, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(38)
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textarea)))
					.addGap(50)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textaddress, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textphone))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textusername, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblid_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textaddressid)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2)
								.addComponent(button_1))))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(textuserid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(textaddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textprovince, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(textusername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textcity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_6)
							.addComponent(textphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_2)))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textarea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblid_1)
						.addComponent(textaddressid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		addresstable = new JTable();
		addresstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickrow(e);
			}
		});
		addresstable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "\u5730\u5740id", "\u7528\u6237id", "\u7701\u4EFD", "\u57CE\u5E02", "\u5730\u533A",
						"\u8BE6\u7EC6\u5730\u5740", "\u8054\u7CFB\u4EBA", "\u7535\u8BDD" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(addresstable);
		getContentPane().setLayout(groupLayout);

		this.fillTable("");

	}

	protected void updatepickrow() {
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
			fillTable("");
		}else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
		
	}

	// 清空列表
	private void initTable() {
		this.textuserid.setText("");
		this.textprovince.setText("");
		this.textcity.setText("");
		this.textarea.setText("");
		this.textaddress.setText("");
		this.textusername.setText("");
		this.textphone.setText("");
	}

	private void delpickrow() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该地址信息？");
		if (result == 0) {
			String id = this.textaddressid.getText();
			ShoppingAddDao sad = new ShoppingAddDao();
			sad.delAdd(Integer.parseInt(id));
			fillTable("");
			initTable();
		}
	}

	private void pickrow(MouseEvent e) {
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

	private void findaddress() {
		// TODO Auto-generated method stub
		String username = this.findusername.getText();
		fillTable(username);
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
