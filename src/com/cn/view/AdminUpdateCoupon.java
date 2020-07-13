package com.cn.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.CouponDao;
import com.cn.dao.GoodsDao;
import com.cn.model.Coupon;
import com.cn.model.Goods;
import com.cn.util.StringUtil;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;

public class AdminUpdateCoupon extends JInternalFrame {
	private JTable table;
	private JTextField findCoupon;
	private JTextField textid;
	private JTextField textcontent;
	private JTextField textuseamount;
	private JTextField textcreditamount;
	private JTextField textbegindate;
	private JTextField textenddate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateCoupon frame = new AdminUpdateCoupon();
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
	public AdminUpdateCoupon() {
		setIconifiable(true);
		setClosable(true);
		setTitle("维护优惠券信息");
		setBounds(100, 100, 763, 476);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("优惠券内容：");
		
		findCoupon = new JTextField();
		findCoupon.setColumns(10);
		
		JButton btnNewButton = new JButton("查找");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCoupon();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AdminUpdateCoupon.class.getResource("/images/搜索.png")));
		
		JLabel lblNewLabel = new JLabel("优惠券id：");
		
		textid = new JTextField();
		textid.setEditable(false);
		textid.setColumns(10);
		
		JLabel label_1 = new JLabel("内容：");
		
		textcontent = new JTextField();
		textcontent.setColumns(10);
		
		JLabel label_2 = new JLabel("适用金额：");
		
		textuseamount = new JTextField();
		textuseamount.setColumns(10);
		
		JLabel label_3 = new JLabel("减免金额：");
		
		textcreditamount = new JTextField();
		textcreditamount.setColumns(10);
		
		JLabel label_4 = new JLabel("开始时间：");
		
		textbegindate = new JTextField();
		textbegindate.setColumns(10);
		
		JLabel label_5 = new JLabel("截止时间：");
		
		textenddate = new JTextField();
		textenddate.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCoupon();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminUpdateCoupon.class.getResource("/images/submit.png")));
		
		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delCoupon();
			}
		});
		button.setIcon(new ImageIcon(AdminUpdateCoupon.class.getResource("/images/删除(1).png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(findCoupon, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(99)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(lblNewLabel)
								.addComponent(label_2)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textcreditamount)
								.addComponent(textuseamount)
								.addComponent(textcontent)
								.addComponent(textid, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_4)
										.addComponent(label_5))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textbegindate, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(2)
											.addComponent(textenddate, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(58)
									.addComponent(btnNewButton_1)
									.addGap(18)
									.addComponent(button)))))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(findCoupon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(textbegindate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textcontent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(textenddate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(textuseamount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(textcreditamount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(button))))
					.addContainerGap(41, Short.MAX_VALUE))
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
			},
			new String[] {
				"\u4F18\u60E0\u5238id", "\u5185\u5BB9", "\u9002\u7528\u91D1\u989D", "\u51CF\u514D\u91D1\u989D", "\u5F00\u59CB\u65F6\u95F4", "\u622A\u6B62\u65F6\u95F4"
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
	
	

	private void updateCoupon() {
		// TODO Auto-generated method stub
		String id = this.textid.getText();
		String content = this.textcontent.getText();
		String useamount = this.textuseamount.getText();
		String creditamount = this.textcreditamount.getText();
		String begindate = this.textbegindate.getText();
		String enddate = this.textenddate.getText();
		
		if(StringUtil.isNull(content)){
			JOptionPane.showMessageDialog(null, "内容不能为空!");
			return;
		}
		if(StringUtil.isNull(useamount)){
			JOptionPane.showMessageDialog(null, "适用金额不能为空!");
			return;
		}else {
			if (!StringUtil.isNumeric(useamount)){
				JOptionPane.showMessageDialog(null, "适用金额必须为数字!");
				return;
			}
		}
		
		if(StringUtil.isNull(creditamount)){
			JOptionPane.showMessageDialog(null, "减免金额不能为空!");
			return;
		}else {
			if (!StringUtil.isNumeric(useamount)){
				JOptionPane.showMessageDialog(null, "减免金额必须为数字!");
				return;
			}else if(Double.parseDouble(creditamount) >= Double.parseDouble(useamount)) {
				JOptionPane.showMessageDialog(null, "减免金额必须小于适用金额!");
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
		
		Coupon coupon = new Coupon(Integer.parseInt(id), content, Double.parseDouble(useamount), Double.parseDouble(creditamount),
				begintime, endtime);
		CouponDao couponDao = new CouponDao();
		int num = couponDao.updateCoupon(coupon);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			fillTable("");
		}else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
		
	}

	private void delCoupon() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该优惠券信息？");
		if (result == 0) {
			String id = this.textid.getText();
			CouponDao couponDao = new CouponDao();
			couponDao.delCoupon(Integer.parseInt(id));
			fillTable("");
			initTable();
		}
	}

	private void initTable() {
		// TODO Auto-generated method stub
		this.textid.setText("");
		this.textcontent.setText("");
		this.textuseamount.setText("");
		this.textcreditamount.setText("");
		this.textbegindate.setText("");
		this.textenddate.setText("");
	}

	private void pickrow() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		this.textid.setText((String) table.getValueAt(row, 0));
		this.textcontent.setText(String.valueOf(table.getValueAt(row, 1)));
		this.textuseamount.setText(String.valueOf(table.getValueAt(row, 2)));
		this.textcreditamount.setText(String.valueOf(table.getValueAt(row, 3)));
		this.textbegindate.setText(String.valueOf(table.getValueAt(row, 4)));
		this.textenddate.setText(String.valueOf(table.getValueAt(row, 5)));
	}

	private void findCoupon() {
		// TODO Auto-generated method stub
		String name = this.findCoupon.getText();
		fillTable(name);
	}

	private void fillTable(String name) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		CouponDao couponDao = new CouponDao();
		ArrayList<Coupon> list = couponDao.getCoupon(name);
		
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
}
