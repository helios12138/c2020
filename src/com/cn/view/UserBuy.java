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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.CouponDao;
import com.cn.dao.DiscountDao;
import com.cn.dao.DiscountGoodsDao;
import com.cn.dao.GoodsDao;
import com.cn.dao.OrderDao;
import com.cn.dao.OrderDetailDao;
import com.cn.dao.ShoppingAddDao;
import com.cn.dao.UserDao;
import com.cn.model.Coupon;
import com.cn.model.Discount;
import com.cn.model.DiscountGoods;
import com.cn.model.Goods;
import com.cn.model.Order;
import com.cn.model.OrderDetail;
import com.cn.model.ShippingAddress;
import com.cn.model.User;
import com.cn.util.StringUtil;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;

public class UserBuy extends JInternalFrame {
	private JTextField name;
	private JTextField freshclassid;
	private JTable table;
	private JTable table_coupon;
	private JTable table_discount;
	private JTextField pickgoodsname;
	private JTextField buyprice;
	private JTextField discountprice;
	private String pickgoodsid;		//选择商品id
	private JTextField pickcouponid;
	private JTextField buynumber;
	private JTextField totalprice;
	private User newuser;
	private String memberprice;
	private String nomemberprice;
	private String ismember;
	private Double useamount;
	private Double creditamount;
	private int discountnum = 0;
	private Double discount = 0.0;
	private String confirmnum; // 确认采购数量
	private String stocknum; // 商品库存
	private String username; // 用户名
	private int buygoodsid; // 购买商品id
	private JTable table_address;
	private JTextField pickaddress; // 选择地址ID栏
	private int addressid;
	private JTextField buytime; // 要求送达时间
	private int userid; // 用户id
	private Double count; // 原始金额
	private Double jiesuan; // 结算金额
	private JTextField pickgoodsid1;
	private String price;
	private int discountid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserBuy frame = new UserBuy(null);
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
	public UserBuy(User user) {
		setIconifiable(true);
		setClosable(true);
		setTitle("用户采购");
		setBounds(100, 100, 973, 634);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("商品名称：");

		name = new JTextField();
		name.setColumns(10);

		JButton btnNewButton = new JButton("搜索");
		btnNewButton.setIcon(new ImageIcon(UserBuy.class.getResource("/images/搜索.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findGoods();
			}
		});

		JLabel label_1 = new JLabel("商品类别：");

		freshclassid = new JTextField();
		freshclassid.setColumns(10);

		JLabel label_2 = new JLabel("可选优惠券：");
		label_2.setIcon(new ImageIcon(UserBuy.class.getResource("/images/优惠券.png")));

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel label_3 = new JLabel("满折信息：");
		label_3.setIcon(new ImageIcon(UserBuy.class.getResource("/images/优惠券.png")));

		JScrollPane scrollPane_2 = new JScrollPane();

		JLabel label_4 = new JLabel("选择商品名称：");

		pickgoodsname = new JTextField();
		pickgoodsname.setEditable(false);
		pickgoodsname.setColumns(10);

		JLabel label_5 = new JLabel("输入购买数量：");

		JButton button = new JButton("计算总价");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countPrice();
			}
		});
		button.setIcon(new ImageIcon(UserBuy.class.getResource("/images/info.png")));

		JLabel label_6 = new JLabel("采购总价：");

		buyprice = new JTextField();
		buyprice.setEditable(false);
		buyprice.setColumns(10);

		JLabel label_7 = new JLabel("优惠金额：");

		discountprice = new JTextField();
		discountprice.setEditable(false);
		discountprice.setColumns(10);

		JLabel label_8 = new JLabel("结算金额：");

		JButton btnNewButton_1 = new JButton("确认购买");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				querengoumai();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UserBuy.class.getResource("/images/购物.png")));

		JLabel lblid = new JLabel("所选优惠券id：");

		pickcouponid = new JTextField();
		pickcouponid.setEditable(false);
		pickcouponid.setColumns(10);

		buynumber = new JTextField();
		buynumber.setColumns(10);

		totalprice = new JTextField();
		totalprice.setEditable(false);
		totalprice.setColumns(10);

		JScrollPane scrollPane_3 = new JScrollPane();

		JLabel label_9 = new JLabel("选择配送地址");
		label_9.setIcon(new ImageIcon(UserBuy.class.getResource("/images/地址.png")));

		JLabel label_10 = new JLabel("选择收货地址：");

		pickaddress = new JTextField();
		pickaddress.setEditable(false);
		pickaddress.setColumns(10);

		JLabel label_11 = new JLabel("要求送达时间：");

		buytime = new JTextField();
		buytime.setColumns(10);
		
		JLabel label_12 = new JLabel("选择商品编号：");
		
		pickgoodsid1 = new JTextField();
		pickgoodsid1.setEditable(false);
		pickgoodsid1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(freshclassid, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
								.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
								.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_10)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(pickaddress))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_4)
												.addComponent(label_6))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(buyprice)
												.addComponent(pickgoodsname, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_11)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(buytime, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_12))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblid)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(label_7)
													.addGap(28)))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(discountprice, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
												.addComponent(pickcouponid, Alignment.TRAILING))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_8)
												.addComponent(label_5))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(totalprice, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
										.addComponent(buynumber, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
										.addComponent(pickgoodsid1, 132, 132, 132))
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(button)
										.addComponent(btnNewButton_1)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(104)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addComponent(label_9)))
					.addGap(107))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(freshclassid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_10)
						.addComponent(pickaddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11)
						.addComponent(buytime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12)
						.addComponent(pickgoodsid1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(pickgoodsname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblid)
								.addComponent(pickcouponid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5)
								.addComponent(buynumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6)
								.addComponent(buyprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7)
								.addComponent(discountprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8)
								.addComponent(totalprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(btnNewButton_1)))
					.addContainerGap(26, Short.MAX_VALUE))
		);

		table_address = new JTable();
		table_address.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickaddressifo();
			}
		});
		table_address.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5730\u5740ID", "\u7528\u6237ID", "\u7701\u4EFD", "\u57CE\u5E02", "\u5730\u533A", "\u8BE6\u7EC6\u5730\u5740", "\u7528\u6237\u540D", "\u7535\u8BDD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_3.setViewportView(table_address);

		table_discount = new JTable();
		table_discount
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null, null, null },
								{ null, null, null, null, null, null }, },
						new String[] { "\u6EE1\u6298id", "\u5185\u5BB9", "\u5546\u54C1\u6570\u91CF", "\u6298\u6263",
								"\u5F00\u59CB\u65F6\u95F4", "\u622A\u6B62\u65F6\u95F4" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPane_2.setViewportView(table_discount);

		table_coupon = new JTable();
		table_coupon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				couponPickRow();
			}
		});
		table_coupon.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u4F18\u60E0\u5238id", "\u5185\u5BB9", "\u9002\u7528\u91D1\u989D", "\u51CF\u514D\u91D1\u989D", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_coupon);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickrow();
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "\u5546\u54C1id", "\u5546\u54C1\u540D\u79F0", "\u4EF7\u683C", "\u4F1A\u5458\u4EF7\u683C",
						"\u5E93\u5B58\u6570\u91CF", "\u89C4\u683C", "\u7C7B\u522Bid", "\u8BE6\u60C5" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

		this.fillTable("", "");
		if (user != null) {
			UserDao userDao = new UserDao();
			ArrayList<User> list = userDao.getUser(user.getUsername());
			if (list.size() != 0) {
				newuser = list.get(0);
			}

			if (newuser != null) {
				ismember = newuser.getIsmember();
				userid = newuser.getId();
			}
		}
		if (user != null) {
			fillTableAddress(user);
		}
	}

	// 选择地址信息
	private void pickaddressifo() {
		// TODO Auto-generated method stub
		int row = table_address.getSelectedRow();
		//addressid = Integer.parseInt((String.valueOf(table_address.getValueAt(row, 0))));
		this.pickaddress.setText((String) table_address.getValueAt(row, 0));
		addressid = Integer.parseInt(this.pickaddress.getText());
	}

	// 填充地址表
	private void fillTableAddress(User user) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table_address.getModel();
		dtm.setRowCount(0);

		ShoppingAddDao sad = new ShoppingAddDao();
		ArrayList<ShippingAddress> list = sad.getAdd(user.getUsername());

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

	// 确认购买
	private void querengoumai() {
		// TODO Auto-generated method stub
		GoodsDao goodsDao = new GoodsDao();

		Timestamp buytime = null;
		if (StringUtil.isNull(this.buytime.getText())) {
			JOptionPane.showMessageDialog(null, "送货时间不能为空！");
			return;
		} else {
			if (StringUtil.isValidDate(this.buytime.getText())) {
				buytime = new Timestamp(System.currentTimeMillis());
				buytime = Timestamp.valueOf(this.buytime.getText());
			} else {
				JOptionPane.showMessageDialog(null, "时间格式错误，请重新输入格式：2000-02-02 20:10:20！");
				return;
			}
		}

		if (StringUtil.isNull(confirmnum)) {
			JOptionPane.showMessageDialog(null, "请先计算总价，再进行购买！");
			return;
		}

		// 剩余数量 = 库存-采购
		int number = Integer.parseInt(stocknum) - Integer.parseInt(confirmnum);

		if (number < 0) {
			JOptionPane.showMessageDialog(null, "库存不足，采购失败！");
			return;
		}

		int num = goodsDao.updateGoods(number, buygoodsid);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "采购成功！");

			int id = (int) System.currentTimeMillis();
			//写入商品订单表
			Order order = new Order(id, userid, count, jiesuan, Integer.parseInt(this.pickcouponid.getText()), buytime,
					addressid, "下单");
			OrderDao orderDao = new OrderDao();
			orderDao.addOrder(order);
			
			//写入订单详情表
			OrderDetail orderDetail = new OrderDetail(0, id, Integer.parseInt(pickgoodsid), Integer.parseInt(this.buynumber.getText()), Double.parseDouble(price), discount, discountid);
			OrderDetailDao orderDetailDao = new OrderDetailDao();
			orderDetailDao.addOrderDetail(orderDetail);
			

			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "采购失败！");
		}
	}

	// 计算总价格
	private void countPrice() {
		// TODO Auto-generated method stub
		if ("是".equals(ismember)) {
			price = new String(memberprice);
		} else {
			price = new String(nomemberprice);
		}

		if (StringUtil.isNull(this.buynumber.getText())) {
			JOptionPane.showMessageDialog(null, "数量不能为空！");
			return;
		}

		// 采购总价
		count = Double.parseDouble(price) * Double.parseDouble(this.buynumber.getText());
		this.buyprice.setText(String.valueOf(count));

		// 优惠金额
		Double jianmian = 0.0;

		confirmnum = this.buynumber.getText();
		if (Integer.parseInt(this.buynumber.getText()) > discountnum) {
			jianmian = count * (1 - discount);
		}

		if (count > useamount) {
			jianmian = jianmian + creditamount;
		}

		// 优惠金额
		this.discountprice.setText(String.valueOf(jianmian));

		jiesuan = count - jianmian;
		// 结算金额
		this.totalprice.setText(String.valueOf(count - jianmian));
	}

	// 选择优惠券
	private void couponPickRow() {
		// TODO Auto-generated method stub
		int row = table_coupon.getSelectedRow();
		this.pickcouponid.setText((String) table_coupon.getValueAt(row, 1));
		useamount = (Double) table_coupon.getValueAt(row, 2);
		creditamount = (Double) table_coupon.getValueAt(row, 3);
	}

	// 选择商品
	private void pickrow() {
		// TODO Auto-generated method stub
		fillTableCoupon("");
		fillTableDiscount(0);
		int row = table.getSelectedRow();
		String goodsid = (String) table.getValueAt(row, 0);
		pickgoodsid = new String(goodsid);
		
		this.pickgoodsid1.setText(pickgoodsid);
		// 填充折扣表
		DiscountGoodsDao discountGoodsDao = new DiscountGoodsDao();
		ArrayList<DiscountGoods> discountGoods = discountGoodsDao.getDiscountGoods_goods(goodsid);
		if (discountGoods.size() != 0) {
			discountid = discountGoods.get(0).getDiscountid();
			fillTableDiscount(discountid);
		}

		this.pickgoodsname.setText((String) table.getValueAt(row, 1));
		this.memberprice = String.valueOf(table.getValueAt(row, 3));
		this.nomemberprice = String.valueOf(table.getValueAt(row, 2));
		this.stocknum = String.valueOf(table.getValueAt(row, 4));
		this.buygoodsid = Integer.parseInt((String) table.getValueAt(row, 0));
	}

	// 填充优惠券表
	private void fillTableCoupon(String string) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table_coupon.getModel();
		dtm.setRowCount(0);

		CouponDao couponDao = new CouponDao();
		ArrayList<Coupon> list = couponDao.getCoupon(string);

		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getContent());
			v.add(list.get(i).getUseamount());
			v.add(list.get(i).getCreditamount());
			v.add(list.get(i).getBegindate());
			v.add(list.get(i).getEnddate());

			dtm.addRow(v);
		}

	}

	// 填充折扣表
	private void fillTableDiscount(int discountid) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table_discount.getModel();
		dtm.setRowCount(0);

		DiscountDao discountDao = new DiscountDao();
		ArrayList<Discount> list = discountDao.getDiscount(discountid);

		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				Vector<Object> v = new Vector<>();
				v.add(Integer.toString(list.get(i).getId()));
				v.add(list.get(i).getContent());
				v.add(list.get(i).getGoodsnum());
				v.add(list.get(i).getDiscount());
				v.add(list.get(i).getBegindate());
				v.add(list.get(i).getEnddate());

				discountnum = list.get(i).getGoodsnum();
				discount = list.get(i).getDiscount();

				dtm.addRow(v);
			}
		}
	}

	// 查找商品（根据商品名称及类别id）
	private void findGoods() {
		// TODO Auto-generated method stub
		String name = this.name.getText();
		String freshclassid = this.freshclassid.getText();

		fillTable(freshclassid, name);
	}

	// 填充商品主表
	private void fillTable(String freshclassid, String name) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		GoodsDao goodsDao = new GoodsDao();
		ArrayList<Goods> list = goodsDao.getGoods_freshclassid_goodsid(freshclassid, name);
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getName());
			v.add(list.get(i).getPrice());
			v.add(list.get(i).getMenberprice());
			v.add(list.get(i).getNumber());
			v.add(list.get(i).getSpec());
			v.add(list.get(i).getFreshclassid());
			v.add(list.get(i).getDetails());

			dtm.addRow(v);
		}
	}

}
