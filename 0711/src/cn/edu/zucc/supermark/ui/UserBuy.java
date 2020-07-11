package cn.edu.zucc.supermark.ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.supermark.a.CouponDao;
import cn.edu.zucc.supermark.a.DiscountDao;
import cn.edu.zucc.supermark.a.DiscountGoodsDao;
import cn.edu.zucc.supermark.a.GoodsDao;
import cn.edu.zucc.supermark.model.Coupon;
import cn.edu.zucc.supermark.model.Discount;
import cn.edu.zucc.supermark.model.DiscountGoods;
import cn.edu.zucc.supermark.model.Goods;
import cn.edu.zucc.supermark.model.User;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserBuy extends JInternalFrame {
	private JTextField name;
	private JTextField freshclassid;
	private JTable table;
	private JTable table_coupon;
	private JTable table_discount;
	private JTextField pickgoodsname;
	private JTextField buyprice;
	private JTextField discountprice;
	private String pickgoodsid;
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
		setBounds(100, 100, 953, 648);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("商品名称：");

		name = new JTextField();
		name.setColumns(10);

		JButton btnNewButton = new JButton("搜索");
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
										.createSequentialGroup().addGap(107).addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(name,
												GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addGap(31).addComponent(label_1).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(freshclassid, GroupLayout.PREFERRED_SIZE, 148,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36).addComponent(btnNewButton))
								.addGroup(groupLayout.createSequentialGroup().addGap(104).addComponent(label_2))
								.addGroup(groupLayout.createSequentialGroup().addGap(100).addComponent(label_3))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addGroup(groupLayout
										.createSequentialGroup().addGap(42)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_4)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(pickgoodsname, GroupLayout.PREFERRED_SIZE, 97,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_6)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																buyprice, GroupLayout.PREFERRED_SIZE, 85,
																GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_7)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																discountprice, GroupLayout.PREFERRED_SIZE, 119,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addComponent(lblid)
														.addGap(18).addComponent(pickcouponid,
																GroupLayout.PREFERRED_SIZE, 95,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(37)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_5)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(buynumber, GroupLayout.PREFERRED_SIZE, 132,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_8)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																totalprice)))
										.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(button).addComponent(btnNewButton_1))
										.addGap(19))
										.addGroup(groupLayout.createSequentialGroup().addGap(72)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 776,
																Short.MAX_VALUE)
														.addComponent(scrollPane_1)
														.addComponent(scrollPane, Alignment.TRAILING)))))
						.addContainerGap(89, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(freshclassid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(label_2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(label_3).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addGap(39)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(pickcouponid, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(button).addComponent(label_5).addComponent(buynumber,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout
												.createParallelGroup(Alignment.BASELINE).addComponent(label_4)
												.addComponent(pickgoodsname, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblid))
										.addGap(32)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(buyprice, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_6).addComponent(label_7)
												.addComponent(discountprice, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_8).addComponent(btnNewButton_1)
												.addComponent(totalprice, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(38, Short.MAX_VALUE)));

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
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "\u4F18\u60E0\u5238id", "\u5185\u5BB9", "\u9002\u7528\u91D1\u989D",
						"\u51CF\u514D\u91D1\u989D", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

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
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "\u5546\u54C1id", "\u5546\u54C1\u540D\u79F0", "\u4EF7\u683C", "\u4F1A\u5458\u4EF7\u683C",
						"\u89C4\u683C", "\u7C7B\u522Bid", "\u8BE6\u60C5" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

		this.fillTable("", "");
		if (user != null) {
			ismember = user.getIsmember();
		}
	}

	private void countPrice() {
		// TODO Auto-generated method stub
		String price;
		if ("是".equals(ismember)) {
			price = new String(memberprice);
		} else {
			price = new String(nomemberprice);
		}

		Double count = Double.parseDouble(price) * Double.parseDouble(this.buynumber.getText());

		this.buyprice.setText(String.valueOf(count));
		
		//减免金额
		Double jianmian = 0.0;
		
		if (Integer.parseInt(this.buynumber.getText()) > discountnum){
			jianmian = count * (1 - discount);
		}
		
		if (count > useamount) {
			jianmian = jianmian + creditamount;
		}
		
		this.discountprice.setText(String.valueOf(jianmian));
		
		this.totalprice.setText(String.valueOf(count - jianmian));
	}

	private void couponPickRow() {
		// TODO Auto-generated method stub
		int row = table_coupon.getSelectedRow();
		this.pickcouponid.setText((String) table_coupon.getValueAt(row, 1));
		useamount = (Double) table_coupon.getValueAt(row, 2);
		creditamount = (Double) table_coupon.getValueAt(row, 3);
	}

	private void pickrow() {
		// TODO Auto-generated method stub
		fillTableCoupon("");
		fillTableDiscount(0);
		int row = table.getSelectedRow();
		String goodsid = (String) table.getValueAt(row, 0);
		pickgoodsid = new String(goodsid);

		// 填充折扣表
		DiscountGoodsDao discountGoodsDao = new DiscountGoodsDao();
		ArrayList<DiscountGoods> discountGoods = discountGoodsDao.getDiscountGoods_goods(goodsid);
		if (discountGoods.size() != 0) {
			int discountid = discountGoods.get(0).getDiscountid();
			fillTableDiscount(discountid);
		}

		this.pickgoodsname.setText((String) table.getValueAt(row, 1));
		this.memberprice = String.valueOf(table.getValueAt(row, 3));
		this.nomemberprice = String.valueOf(table.getValueAt(row, 2));

	}

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

	private void findGoods() {
		// TODO Auto-generated method stub
		String name = this.name.getText();
		String freshclassid = this.freshclassid.getText();

		fillTable(freshclassid, name);
	}

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
