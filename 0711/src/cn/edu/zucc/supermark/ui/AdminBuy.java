package cn.edu.zucc.supermark.ui;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.supermark.a.AppraiseDao;
import cn.edu.zucc.supermark.a.DiscountDao;
import cn.edu.zucc.supermark.a.DiscountGoodsDao;
import cn.edu.zucc.supermark.a.GoodsDao;
import cn.edu.zucc.supermark.model.Appraise;
import cn.edu.zucc.supermark.model.Discount;
import cn.edu.zucc.supermark.model.DiscountGoods;
import cn.edu.zucc.supermark.model.Goods;
import cn.edu.zucc.supermark.util.StringUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminBuy extends JInternalFrame {
	private JTable table;
	private JTable table_appraise;
	private JTextField name;
	private JTextField freshclassid;
	private JTable table_discount;
	private JTextField stock;
	private JTextField buynumber;
	private String pickgoodsid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminBuy frame = new AdminBuy();
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
	public AdminBuy() {
		setClosable(true);
		setIconifiable(true);
		setTitle("商品采购");
		setBounds(100, 100, 663, 601);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label_1 = new JLabel("选择以上表格选择采购商品");

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel label_2 = new JLabel("商品评价明细：");

		JLabel label_3 = new JLabel("商品名称：");

		name = new JTextField();
		name.setColumns(10);

		JButton button = new JButton("搜索");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findGoods();
			}
		});
		button.setIcon(new ImageIcon(AdminBuy.class.getResource("/images/搜索.png")));

		JLabel lblid = new JLabel("类别id：");

		freshclassid = new JTextField();
		freshclassid.setColumns(10);

		JLabel label = new JLabel("商品满折信息：");

		JScrollPane scrollPane_2 = new JScrollPane();

		JLabel label_4 = new JLabel("商品库存：");

		stock = new JTextField();
		stock.setEditable(false);
		stock.setColumns(10);

		JLabel label_5 = new JLabel("本次采购数量：");

		buynumber = new JTextField();
		buynumber.setColumns(10);

		JButton button_1 = new JButton("采购");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy();
			}
		});
		button_1.setIcon(new ImageIcon(AdminBuy.class.getResource("/images/购物.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(78).addComponent(lblid)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(freshclassid, GroupLayout.PREFERRED_SIZE, 108,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(label_3)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(name, GroupLayout.PREFERRED_SIZE, 98,
														GroupLayout.PREFERRED_SIZE)
												.addGap(27).addComponent(button))
										.addGroup(groupLayout.createSequentialGroup().addGap(72).addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 498,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(label_1).addComponent(label_2)
												.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 501,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(label)
												.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 500,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_4)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(stock, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(label_5)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(buynumber, GroupLayout.PREFERRED_SIZE, 97,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(button_1)))))
								.addContainerGap(72, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid)
								.addComponent(freshclassid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addGap(8).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_1).addGap(18)
						.addComponent(label_2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(label).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_4)
								.addComponent(stock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5).addComponent(buynumber, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1))
						.addGap(153)));

		table_discount = new JTable();
		table_discount.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "id", "\u5185\u5BB9", "\u9002\u7528\u6570\u91CF", "\u6298\u6263",
						"\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2.setViewportView(table_discount);

		table_appraise = new JTable();
		table_appraise.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "\u7F16\u53F7", "\u5546\u54C1id", "\u7528\u6237id", "\u8BC4\u4EF7\u5185\u5BB9",
						"\u8BC4\u4EF7\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_appraise);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickrow();
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
				"\u5546\u54C1id", "\u540D\u79F0", "\u4EF7\u683C", "\u4F1A\u5458\u4EF7", "\u5E93\u5B58", "\u89C4\u683C", "\u7C7B\u522Bid", "\u8BE6\u60C5"
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

		this.fillTable("", "");
	}

	private void buy() {
		// TODO Auto-generated method stub
		String stock = this.stock.getText();
		String buynumber = this.buynumber.getText();
		if(StringUtil.isNull(buynumber)){
			JOptionPane.showMessageDialog(null, "采购数量不能为空!");
			return;
		}else {
			if (!StringUtil.isNumeric(buynumber)){
				JOptionPane.showMessageDialog(null, "采购数量必须为数字!");
				return;
			}
		}
		int number = Integer.parseInt(stock) + Integer.parseInt(buynumber);
		int goodsid = Integer.parseInt(pickgoodsid);
		GoodsDao goodsDao = new GoodsDao();
		int result = goodsDao.updateGoods(number, goodsid);
		if (result != 0) {
			JOptionPane.showMessageDialog(null, "采购成功！");
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "采购失败！");
		}
	}

	private void pickrow() {
		// TODO Auto-generated method stub
		fillTableAppraise("0");
		fillTableDiscount(0);
		int row = table.getSelectedRow();
		String goodsid = (String) table.getValueAt(row, 0);
		pickgoodsid = new String(goodsid);
		
		//填充评价表
		fillTableAppraise(goodsid);
		
		//填充折扣表
		DiscountGoodsDao discountGoodsDao = new DiscountGoodsDao();
		ArrayList<DiscountGoods> discountGoods = discountGoodsDao.getDiscountGoods_goods(goodsid);
		if (discountGoods.size() != 0 ){
			int discountid = discountGoods.get(0).getDiscountid();
			fillTableDiscount(discountid);
		}
		
		int num = (int) table.getValueAt(row, 4);
		this.stock.setText(String.valueOf(num));
	}

	private void fillTableDiscount(int discountid) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table_discount.getModel();
		dtm.setRowCount(0);

		DiscountDao discountDao = new DiscountDao();
		ArrayList<Discount> list = discountDao.getDiscount(discountid);
		
		if (list.size() != 0){
			for (int i = 0; i < list.size(); i++) {
				Vector<Object> v = new Vector<>();
				v.add(Integer.toString(list.get(i).getId()));
				v.add(list.get(i).getContent());
				v.add(list.get(i).getGoodsnum());
				v.add(list.get(i).getDiscount());
				v.add(list.get(i).getBegindate());
				v.add(list.get(i).getEnddate());

				dtm.addRow(v);
			}
		}
	}

	private void fillTableAppraise(String goodsid) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table_appraise.getModel();
		dtm.setRowCount(0);

		AppraiseDao appraiseDao = new AppraiseDao();
		ArrayList<Appraise> list = appraiseDao.getGoods(Integer.parseInt(goodsid));
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getGoodsid());
			v.add(list.get(i).getUserid());
			v.add(list.get(i).getContent());
			v.add(list.get(i).getContentdata());

			dtm.addRow(v);
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
