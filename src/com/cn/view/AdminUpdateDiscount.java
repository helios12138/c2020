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
import com.cn.model.Coupon;
import com.cn.model.Discount;
import com.cn.model.DiscountGoods;
import com.cn.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;

public class AdminUpdateDiscount extends JInternalFrame {
	private JTable table;
	private JTextField finddiscoutcontent;
	private JTextField id;
	private JTextField content;
	private JTextField goodsnum;
	private JTextField begindate;
	private JTextField enddate;
	private JTextField discount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateDiscount frame = new AdminUpdateDiscount();
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
	public AdminUpdateDiscount() {
		setIconifiable(true);
		setClosable(true);
		setTitle("维护满折信息");
		setBounds(100, 100, 765, 473);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("内容：");
		
		finddiscoutcontent = new JTextField();
		finddiscoutcontent.setColumns(10);
		
		JButton button = new JButton("查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fingDiscountContent();
			}
		});
		button.setIcon(new ImageIcon(AdminUpdateDiscount.class.getResource("/images/搜索.png")));
		
		JLabel lblid = new JLabel("满折id：");
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		
		JLabel label_1 = new JLabel("内容：");
		
		content = new JTextField();
		content.setColumns(10);
		
		JLabel label_2 = new JLabel("适用数量：");
		
		goodsnum = new JTextField();
		goodsnum.setColumns(10);
		
		JLabel label_3 = new JLabel("折扣：");
		
		JLabel label_4 = new JLabel("开始时间：");
		
		begindate = new JTextField();
		begindate.setColumns(10);
		
		JLabel label_5 = new JLabel("截止时间：");
		
		enddate = new JTextField();
		enddate.setColumns(10);
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDiscount();
			}
		});
		button_1.setIcon(new ImageIcon(AdminUpdateDiscount.class.getResource("/images/submit.png")));
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delDiscount();
			}
		});
		button_2.setIcon(new ImageIcon(AdminUpdateDiscount.class.getResource("/images/删除(1).png")));
		
		discount = new JTextField();
		discount.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addComponent(label)
							.addGap(5)
							.addComponent(finddiscoutcontent, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(lblid))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(content)
								.addComponent(id, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_5)
									.addGap(5)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(enddate, Alignment.LEADING)
								.addComponent(begindate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(discount)
								.addComponent(goodsnum, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
							.addGap(69)
							.addComponent(button_1)
							.addGap(28)
							.addComponent(button_2)))
					.addGap(70))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(51)
									.addComponent(label))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(47)
									.addComponent(finddiscoutcontent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(17)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblid)
								.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(label_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(17)
									.addComponent(content, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(goodsnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(discount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addComponent(label_4)
									.addGap(23)
									.addComponent(label_5))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(41)
									.addComponent(begindate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(16)
									.addComponent(enddate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1)
								.addComponent(button_2))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickrow();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u6EE1\u6298id", "\u5185\u5BB9", "\u9002\u7528\u6570\u91CF", "\u6298\u6263", "\u5F00\u59CB\u65F6\u95F4", "\u622A\u6B62\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable("");
	}
	
	

	private void delDiscount() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该满折信息？");
		if (result == 0) {
			String id = this.id.getText();
			
			//删除前判断是否存在满折商品表中
			DiscountGoodsDao dis = new DiscountGoodsDao();
			ArrayList<DiscountGoods> list = dis.getDiscountGoods_discount(id);
			if (list.size() != 0){
				JOptionPane.showMessageDialog(null, "满折商品信息中存在该满折id信息，无法删除!");
			}else {
				DiscountDao discountDao = new DiscountDao();
				discountDao.delDiscount(Integer.parseInt(id));
				fillTable("");
				initTable();
			}		
		}
	}

	private void initTable() {
		// TODO Auto-generated method stub
		this.id.setText("");
		this.content.setText("");
		this.goodsnum.setText("");
		this.discount.setText("");
		this.begindate.setText("");
		this.enddate.setText("");
	}

	private void updateDiscount() {
		// TODO Auto-generated method stub
		String id = this.id.getText();
		String content = this.content.getText();
		String goodsnum = this.goodsnum.getText();
		String discount = this.discount.getText();
		String begindate = this.begindate.getText();
		String enddate = this.enddate.getText();
		
		if(StringUtil.isNull(content)){
			JOptionPane.showMessageDialog(null, "内容不能为空!");
			return;
		}
		if(StringUtil.isNull(goodsnum)){
			JOptionPane.showMessageDialog(null, "商品数量不能为空!");
			return;
		}
		if(StringUtil.isNull(discount)){
			JOptionPane.showMessageDialog(null, "折扣不能为空!");
			return;
		}else if(Double.parseDouble(discount) >= 1) {
			JOptionPane.showMessageDialog(null, "折扣必须小于1!");
			return;
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
		
		Discount discount1 = new Discount(Integer.parseInt(id), content, Integer.parseInt(goodsnum), Double.parseDouble(discount), begintime, endtime);
		DiscountDao discountDao = new DiscountDao();
		int num = discountDao.updateDiscount(discount1);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "更新成功！");
			fillTable("");
		}else {
			JOptionPane.showMessageDialog(null, "更新失败！");
		}
	}

	private void pickrow() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		this.id.setText((String) table.getValueAt(row, 0));
		this.content.setText((String) table.getValueAt(row, 1));
		this.goodsnum.setText(String.valueOf(table.getValueAt(row, 2)));
		this.discount.setText(String.valueOf(table.getValueAt(row, 3)));
		this.begindate.setText(String.valueOf(table.getValueAt(row, 4)));
		this.enddate.setText(String.valueOf(table.getValueAt(row, 5)));
		
	}

	private void fingDiscountContent() {
		// TODO Auto-generated method stub
		String content = this.finddiscoutcontent.getText();
		fillTable(content);
	}

	private void fillTable(String content) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		DiscountDao discountDao = new DiscountDao();
		ArrayList<Discount> list = discountDao.getDiscount(content);
		
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
