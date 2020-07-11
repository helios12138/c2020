package cn.edu.zucc.supermark.ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.supermark.a.DiscountGoodsDao;
import cn.edu.zucc.supermark.a.GoodsDao;
import cn.edu.zucc.supermark.a.ShoppingAddDao;
import cn.edu.zucc.supermark.model.DiscountGoods;
import cn.edu.zucc.supermark.model.Goods;
import cn.edu.zucc.supermark.model.ShippingAddress;
import cn.edu.zucc.supermark.util.StringUtil;

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

public class AdminUpdateGoods extends JInternalFrame {
	private JTable table;
	private JTextField findgoodsname;
	private JTextField textid;
	private JTextField textname;
	private JTextField textprice;
	private JTextField textmenberprice;
	private JTextField textspec;
	private JTextField textfreshclassid;
	private JTextField textdetails;
	private JTextField textnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateGoods frame = new AdminUpdateGoods();
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
	public AdminUpdateGoods() {
		setIconifiable(true);
		setClosable(true);
		setTitle("维护商品信息");
		setBounds(100, 100, 790, 484);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("商品名称：");

		findgoodsname = new JTextField();
		findgoodsname.setColumns(10);

		JButton button = new JButton("查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findGoods();
			}
		});
		button.setIcon(new ImageIcon(AdminUpdateGoods.class.getResource("/images/搜索.png")));

		JLabel lblid = new JLabel("商品id：");

		textid = new JTextField();
		textid.setEditable(false);
		textid.setColumns(10);

		JLabel label_1 = new JLabel("商品名称：");

		textname = new JTextField();
		textname.setColumns(10);

		JLabel label_2 = new JLabel("价格：");

		textprice = new JTextField();
		textprice.setColumns(10);

		JLabel label_3 = new JLabel("会员价：");

		textmenberprice = new JTextField();
		textmenberprice.setColumns(10);

		JLabel label_5 = new JLabel("规格：");

		textspec = new JTextField();
		textspec.setColumns(10);

		JLabel lblid_1 = new JLabel("商品类别id：");

		textfreshclassid = new JTextField();
		textfreshclassid.setEditable(false);
		textfreshclassid.setColumns(10);

		JLabel label_6 = new JLabel("详情：");

		textdetails = new JTextField();
		textdetails.setColumns(10);

		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateGoods();
			}
		});
		button_1.setIcon(new ImageIcon(AdminUpdateGoods.class.getResource("/images/update.png")));

		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delGoods();
			}
		});
		button_2.setIcon(new ImageIcon(AdminUpdateGoods.class.getResource("/images/删除(1).png")));

		JLabel label_4 = new JLabel("库存数量：");

		textnumber = new JTextField();
		textnumber.setEditable(false);
		textnumber.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(91)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(lblid))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textmenberprice)
								.addComponent(textprice)
								.addComponent(textname)
								.addComponent(textid, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_5)
								.addComponent(lblid_1)
								.addComponent(label_6)
								.addComponent(label_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textnumber)
								.addComponent(textdetails)
								.addComponent(textfreshclassid)
								.addComponent(textspec, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
							.addGap(84)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1)
								.addComponent(button_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(findgoodsname, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(button)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(findgoodsname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(textid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(textspec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblid_1)
						.addComponent(textfreshclassid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(textdetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textmenberprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(textnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);

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
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "\u5546\u54C1id", "\u5546\u54C1\u540D\u79F0", "\u4EF7\u683C", "\u4F1A\u5458\u4EF7",
						"\u5E93\u5B58\u6570\u91CF", "\u89C4\u683C", "\u5546\u54C1\u7C7B\u522Bid", "\u8BE6\u60C5" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

		this.fillTable("");
	}

	private void updateGoods() {
		// TODO Auto-generated method stub
		String id = this.textid.getText();
		String name = this.textname.getText();
		String price = this.textprice.getText();
		String menberprice = this.textmenberprice.getText();
		String spec = this.textspec.getText();
		String detail = this.textdetails.getText();

		if (StringUtil.isNull(name)) {
			JOptionPane.showMessageDialog(null, "商品名称不能为空!");
			return;
		}
		if (StringUtil.isNull(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空!");
			return;
		}
		if (StringUtil.isNull(menberprice)) {
			JOptionPane.showMessageDialog(null, "会员价不能为空!");
			return;
		}
		if (StringUtil.isNull(spec)) {
			JOptionPane.showMessageDialog(null, "规格不能为空!");
			return;
		}

		Goods goods = new Goods(Integer.parseInt(id), name, Double.parseDouble(price), Double.parseDouble(menberprice),
				0, spec, 0, detail);
		GoodsDao goodsDao = new GoodsDao();
		int num = goodsDao.updateGoods(goods);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			fillTable("");
		} else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
	}

	private void delGoods() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该商品信息？");
		if (result == 0) {
			String id = this.textid.getText();

			// 删除之前判断该商品是否存在满折商品表中
			DiscountGoodsDao dis = new DiscountGoodsDao();
			ArrayList<DiscountGoods> list = dis.getDiscountGoods_goods(id);
			if (list.size() != 0) {
				JOptionPane.showMessageDialog(null, "满折商品信息中存在商品折id信息，无法删除!");
			} else {
				GoodsDao goodsDao = new GoodsDao();
				goodsDao.delGoods(Integer.parseInt(id));
				fillTable("");
				initTable();
			}
		}
	}

	private void initTable() {
		// TODO Auto-generated method stub
		this.textid.setText("");
		this.textname.setText("");
		this.textprice.setText("");
		this.textmenberprice.setText("");
		this.textspec.setText("");
		this.textfreshclassid.setText("");
		this.textdetails.setText("");
		this.textnumber.setText("");

	}

	private void pickrow() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		this.textid.setText((String) table.getValueAt(row, 0));
		this.textname.setText((String) (table.getValueAt(row, 1)));
		this.textprice.setText(String.valueOf(table.getValueAt(row, 2)));
		this.textmenberprice.setText(String.valueOf(table.getValueAt(row, 3)));
		this.textnumber.setText(String.valueOf(table.getValueAt(row, 4)));
		this.textspec.setText((String) table.getValueAt(row, 5));
		this.textfreshclassid.setText(String.valueOf(table.getValueAt(row, 6)));
		this.textdetails.setText((String) table.getValueAt(row, 7));
	}

	private void findGoods() {
		// TODO Auto-generated method stub
		String goodsname = this.findgoodsname.getText();
		fillTable(goodsname);
	}

	private void fillTable(String username) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		GoodsDao goodsDao = new GoodsDao();
		ArrayList<Goods> list = goodsDao.getGoods(username);

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
