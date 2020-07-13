package com.cn.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.ls.LSInput;

import com.cn.dao.AppraiseDao;
import com.cn.dao.OrderDao;
import com.cn.dao.OrderDetailDao;
import com.cn.dao.UserDao;
import com.cn.model.Appraise;
import com.cn.model.Order;
import com.cn.model.OrderDetail;
import com.cn.model.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserOrder extends JInternalFrame {
	private JTextField findorderid;
	private JTable table;
	private JTable table_detail;
	private JTextField goodsid;
	private JTextField orderid;
	private JTextField content;
	private User newuser;
	private int userid;
	private String pickorderid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOrder frame = new UserOrder(null);
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
	public UserOrder(User user) {
		setIconifiable(true);
		setClosable(true);
		setTitle("我的订单明细");
		setBounds(100, 100, 988, 496);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("订单号：");
		
		findorderid = new JTextField();
		findorderid.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findOrder();
			}
		});
		btnNewButton.setIcon(new ImageIcon(UserOrder.class.getResource("/images/搜索.png")));
		
		JLabel label_1 = new JLabel("订单明细：");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblid = new JLabel("商品编号：");
		
		goodsid = new JTextField();
		goodsid.setEditable(false);
		goodsid.setColumns(10);
		
		JLabel label_2 = new JLabel("订单编号：");
		
		orderid = new JTextField();
		orderid.setEditable(false);
		orderid.setColumns(10);
		
		JLabel label_3 = new JLabel("评价：");
		
		content = new JTextField();
		content.setColumns(10);
		
		JButton button = new JButton("提交评价");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
				
			}
		});
		button.setIcon(new ImageIcon(UserOrder.class.getResource("/images/info.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(146)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(findorderid, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_1)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 813, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 814, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(orderid))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblid)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(goodsid, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
									.addGap(59)
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(276)
											.addComponent(button))
										.addComponent(content))))))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(findorderid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(goodsid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(content, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(orderid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		table_detail = new JTable();
		table_detail.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5E8F\u53F7", "\u8BA2\u5355\u7F16\u53F7", "\u5546\u54C1\u7F16\u53F7", "\u8BA2\u5355\u6570\u91CF", "\u4EF7\u683C", "\u6298\u6263", "\u6298\u6263ID"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_detail);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickRow();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u8BA2\u5355\u7F16\u53F7", "\u7528\u6237ID", "\u539F\u59CB\u91D1\u989D", "\u7ED3\u7B97\u91D1\u989D", "\u4F18\u60E0\u5238\u7F16\u53F7", "\u8981\u6C42\u9001\u8FBE\u65F6\u95F4", "\u914D\u9001\u5730\u5740\u7F16\u53F7", "\u8BA2\u5355\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		if (user!=null){
			UserDao userDao = new UserDao();
			ArrayList<User> list = userDao.getUser(user.getUsername());
			if (list.size() != 0) {
				newuser = list.get(0);
			}

			if (newuser != null) {
				userid = newuser.getId();
				filltable("", userid);
			}		
		}	
	}
	
	//提交评价
	private void submit() {
		// TODO Auto-generated method stub
		String goodsid = this.goodsid.getText();
		String content = this.content.getText();
		Timestamp contentdata = new Timestamp(System.currentTimeMillis());
		
		Appraise appraise = new Appraise(0, Integer.parseInt(goodsid), userid, content, contentdata);
		AppraiseDao appraiseDao = new AppraiseDao();
		int num = appraiseDao.addAppraise(appraise);
	
		if (num != 0){
			JOptionPane.showMessageDialog(null, "评价成功！");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "评价失败！");
		}
	}
	
	
	private void findOrder() {
		// TODO Auto-generated method stub
		String orderid = this.findorderid.getText();
		filltable(orderid, userid);
	}

	private void pickRow() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		pickorderid = (String) table.getValueAt(row, 0);
		this.orderid.setText(pickorderid);
		filltabledetail(pickorderid);
		
	}

	private void filltabledetail(String id) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table_detail.getModel();
		dtm.setRowCount(0);
		
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		ArrayList<OrderDetail> list = orderDetailDao.getOrderDetail(id);
		
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getOrderid());		
			v.add(list.get(i).getGoodsid());
			v.add(list.get(i).getOrdernum());
			v.add(list.get(i).getPrice());
			v.add(list.get(i).getDiscount());
			v.add(list.get(i).getDiscountid());
			
			this.goodsid.setText(String.valueOf(list.get(i).getGoodsid()));
			dtm.addRow(v);
		}
	}

	private void filltable(String id, int userid) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		OrderDao orderDao = new OrderDao();
		ArrayList<Order> list = orderDao.getOrder(id, userid);
		
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getUserid());
			v.add(list.get(i).getOrgprice());
			v.add(list.get(i).getPayprice());
			v.add(list.get(i).getCouponid());
			v.add(list.get(i).getOrdertime());
			v.add(list.get(i).getAddressid());
			v.add(list.get(i).getOrderstate());

			dtm.addRow(v);
		}
	}

}
