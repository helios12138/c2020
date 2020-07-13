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

import com.cn.dao.CouponDao;
import com.cn.dao.DiscountDao;
import com.cn.dao.DiscountGoodsDao;
import com.cn.dao.GoodsDao;
import com.cn.model.Discount;
import com.cn.model.DiscountGoods;
import com.cn.model.Goods;
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
import java.sql.Timestamp;

public class AdminUpdateDiscountGoods extends JInternalFrame {
	private JTable table;
	private JTextField findgoodsid;
	private JTextField id;
	private JTextField discountid;
	private JTextField goodsid;
	private JTextField begindate;
	private JTextField enddate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateDiscountGoods frame = new AdminUpdateDiscountGoods();
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
	public AdminUpdateDiscountGoods() {
		setIconifiable(true);
		setClosable(true);
		setTitle("维护满折商品表");
		setBounds(100, 100, 753, 429);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblid = new JLabel("商品id：");

		findgoodsid = new JTextField();
		findgoodsid.setColumns(10);

		JButton button = new JButton("查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finggoodid();
			}
		});
		button.setIcon(new ImageIcon(AdminUpdateDiscountGoods.class.getResource("/images/搜索.png")));

		JLabel lblid_1 = new JLabel("满折商品id：");

		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);

		JLabel lblid_2 = new JLabel("满折id：");

		discountid = new JTextField();
		discountid.setColumns(10);

		JLabel lblid_3 = new JLabel("商品id：");

		goodsid = new JTextField();
		goodsid.setColumns(10);

		JLabel label = new JLabel("开始时间：");

		begindate = new JTextField();
		begindate.setColumns(10);

		JLabel label_1 = new JLabel("截止时间：");

		enddate = new JTextField();
		enddate.setColumns(10);

		JButton button_1 = new JButton("更新");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDiscountGoods();
			}
		});
		button_1.setIcon(new ImageIcon(AdminUpdateDiscountGoods.class.getResource("/images/submit.png")));

		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delDiscountGoods();
			}
		});
		button_2.setIcon(new ImageIcon(AdminUpdateDiscountGoods.class.getResource("/images/删除(1).png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(63).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(117).addComponent(lblid)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(findgoodsid, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(button))
								.addGroup(groupLayout.createSequentialGroup().addGap(112)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblid_2).addComponent(lblid_1))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(id, GroupLayout.PREFERRED_SIZE, 106,
																GroupLayout.PREFERRED_SIZE)
														.addGap(49).addComponent(label))
												.addGroup(groupLayout.createSequentialGroup().addGap(4)
														.addComponent(discountid, GroupLayout.PREFERRED_SIZE, 106,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(label_1)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																begindate, GroupLayout.PREFERRED_SIZE, 127,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(
														enddate, GroupLayout.PREFERRED_SIZE, 128,
														GroupLayout.PREFERRED_SIZE))))
								.addGroup(
										groupLayout.createSequentialGroup().addGap(133).addComponent(lblid_3).addGap(6)
												.addComponent(goodsid, GroupLayout.PREFERRED_SIZE, 107,
														GroupLayout.PREFERRED_SIZE)
												.addGap(45).addComponent(button_1).addGap(26).addComponent(button_2)))
						.addContainerGap(74, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(42).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblid)
								.addComponent(findgoodsid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(
										button))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup().addGap(44)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid_1)
										.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(lblid_2))
										.addGroup(groupLayout.createSequentialGroup().addGap(16)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(discountid, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_1)))))
								.addGroup(
										groupLayout.createSequentialGroup().addGap(45)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(label).addComponent(begindate,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addGap(17).addComponent(enddate, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(15).addComponent(goodsid,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(17).addComponent(lblid_3))
								.addGroup(groupLayout.createSequentialGroup().addGap(31).addComponent(button_1))
								.addGroup(groupLayout.createSequentialGroup().addGap(31).addComponent(button_2)))
						.addContainerGap(210, Short.MAX_VALUE)));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickrow();
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "\u6EE1\u6298\u5546\u54C1\u5173\u8054id", "\u6EE1\u6298id", "\u5546\u54C1id",
						"\u5F00\u59CB\u65F6\u95F4", "\u622A\u6B62\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

		this.fillTable("");
	}

	private void updateDiscountGoods() {
		// TODO Auto-generated method stub
		String id = this.id.getText();
		String discountid = this.discountid.getText();
		String goodsid = this.goodsid.getText();
		String begindate = this.begindate.getText();
		String enddate = this.enddate.getText();
		
		if(StringUtil.isNull(discountid)){
			JOptionPane.showMessageDialog(null, "满折id不能为空!");
			return;
		}else {
			if (!StringUtil.isNumeric(discountid)){
				JOptionPane.showMessageDialog(null, "满折id必须为数字!");
				return;
			}
		}
		
		if(StringUtil.isNull(goodsid)){
			JOptionPane.showMessageDialog(null, "商品id不能为空!");
			return;
		}else {
			if (!StringUtil.isNumeric(goodsid)){
				JOptionPane.showMessageDialog(null, "商品id必须为数字!");
				return;
			}
		}
		
		Timestamp begintime = null;
		if(StringUtil.isNull(begindate)){
			JOptionPane.showMessageDialog(null, "开始时间不能为空!");
			return;
		}else{
			if (StringUtil.isValidDate(begindate)) {
				begintime = new Timestamp(System.currentTimeMillis());
				begintime = Timestamp.valueOf(begindate);
			} else {
				JOptionPane.showMessageDialog(null, "时间格式错误，请重新输入格式：2000-02-02 20:10:20！");
				return;
			}
		}
		
		Timestamp endtime = null;
		if(StringUtil.isNull(enddate)){
			JOptionPane.showMessageDialog(null, "截至时间不能为空!");
			return;
		}else{
			if (StringUtil.isValidDate(enddate)) {
				endtime = new Timestamp(System.currentTimeMillis());
				endtime = Timestamp.valueOf(enddate);
			} else {
				JOptionPane.showMessageDialog(null, "时间格式错误，请重新输入格式：2000-02-02 20:10:20！");
				return;
			}
		}
		
		if (endtime.before(begintime)) {
			JOptionPane.showMessageDialog(null, "截至时间不得早于开始时间！");
			return;
        }
		
		
		//根据满折id，获取满折起止时间
		DiscountDao discountDao = new DiscountDao();
		ArrayList<Discount> discounts = discountDao.getDiscount(Integer.parseInt(discountid));
		if (discounts.size() == 0){
			JOptionPane.showMessageDialog(null, "该满折id的信息不存在！");
			return;
		}
		Timestamp discountsBegindate = discounts.get(0).getBegindate();
		Timestamp discountsEnddate = discounts.get(0).getEnddate();
		
		if (begintime.before(discountsBegindate)) {
			JOptionPane.showMessageDialog(null, "开始时间不能早于满折开始时间！");
			return;
		}
		
		if (discountsEnddate.before(endtime)) {
			JOptionPane.showMessageDialog(null, "截止时间不能晚于满折截止时间！");
			return;
		}
		
		//根据商品id，查询商品是否存在
		GoodsDao goodsDao = new GoodsDao();
		ArrayList<Goods> goods = goodsDao.getGoods(Integer.parseInt(goodsid));
		if (goods.size() == 0){
			JOptionPane.showMessageDialog(null, "该商品id的信息不存在！");
			return;
		}
		
		DiscountGoods discountGoods = new DiscountGoods(Integer.parseInt(id), Integer.parseInt(discountid), Integer.parseInt(goodsid), begintime, endtime);
		DiscountGoodsDao discountGoodsDao = new DiscountGoodsDao();
		int num = discountGoodsDao.updateDiscountGoods(discountGoods);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "更新成功！");
			fillTable("");;
		}else {
			JOptionPane.showMessageDialog(null, "该商品的满折信息已存在，更新失败！");
		}
	}

	private void delDiscountGoods() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该满折商品信息？");
		if (result == 0) {
			String id = this.id.getText();
			DiscountGoodsDao discountGoodsDao = new DiscountGoodsDao();
			discountGoodsDao.delDiscountGoods(Integer.parseInt(id));
			fillTable("");
			initTable();
		}
	}

	private void initTable() {
		// TODO Auto-generated method stub
		this.id.setText("");
		this.discountid.setText("");
		this.goodsid.setText("");
		this.begindate.setText("");
		this.enddate.setText("");
	}

	private void pickrow() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		this.id.setText((String) table.getValueAt(row, 0));
		this.discountid.setText(String.valueOf(table.getValueAt(row, 1)));
		this.goodsid.setText(String.valueOf(table.getValueAt(row, 2)));
		this.begindate.setText(String.valueOf(table.getValueAt(row, 3)));
		this.enddate.setText(String.valueOf(table.getValueAt(row, 4)));
	}

	private void finggoodid() {
		// TODO Auto-generated method stub
		String goodsid = this.findgoodsid.getText();
		fillTable(goodsid);
	}

	private void fillTable(String goodsid) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		DiscountGoodsDao discountGoodsDao = new DiscountGoodsDao();
		ArrayList<DiscountGoods> list = discountGoodsDao.getDiscountGoods(goodsid);

		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getDiscountid());
			v.add(list.get(i).getGoodsid());
			v.add(list.get(i).getBegindate());
			v.add(list.get(i).getEnddate());

			dtm.addRow(v);
		}
	}

}
