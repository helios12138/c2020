package com.cn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cn.dao.CouponDao;
import com.cn.model.Coupon;
import com.cn.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class AdminAddCoupon extends JInternalFrame {
	private JTextField content;
	private JTextField useamount;
	private JTextField creditamount;
	private JTextField begindate;
	private JTextField enddate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddCoupon frame = new AdminAddCoupon();
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
	public AdminAddCoupon() {
		setIconifiable(true);
		setClosable(true);
		setTitle("新增优惠券");
		setBounds(100, 100, 270, 337);
		
		JLabel label = new JLabel("内容：");
		
		content = new JTextField();
		content.setColumns(10);
		
		JLabel label_1 = new JLabel("适用金额：");
		
		useamount = new JTextField();
		useamount.setColumns(10);
		
		JLabel label_2 = new JLabel("减免金额：");
		
		creditamount = new JTextField();
		creditamount.setColumns(10);
		
		JLabel label_3 = new JLabel("开始时间：");
		
		begindate = new JTextField();
		begindate.setColumns(10);
		
		JLabel label_4 = new JLabel("截至时间：");
		
		enddate = new JTextField();
		enddate.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
				
			}
		});
		button.setIcon(new ImageIcon(AdminAddCoupon.class.getResource("/images/submit.png")));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(AdminAddCoupon.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_4)
								.addComponent(label_3)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(enddate)
								.addComponent(begindate)
								.addComponent(creditamount)
								.addComponent(useamount)
								.addComponent(content, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(button)
							.addGap(30)
							.addComponent(button_1)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(content, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(useamount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(creditamount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(begindate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(enddate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void submit() {
		// TODO Auto-generated method stub
		String content = this.content.getText();
		String useamount = this.useamount.getText();
		String creditamount = this.creditamount.getText();
		String begindate = this.begindate.getText();
		String enddate = this.enddate.getText();
		
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
		
		if (endtime.before(begintime)) {
			JOptionPane.showMessageDialog(null, "截至时间不得早于开始时间！");
			return;
        }
		
		Coupon coupon = new Coupon(0, content, Double.parseDouble(useamount), Double.parseDouble(creditamount),
				begintime, endtime);
		CouponDao couponDao = new CouponDao();
		int num =  couponDao.addCoupon(coupon);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功！");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "优惠券已存在，新增失败！");
		}
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.content.setText("");
		this.useamount.setText("");
		this.creditamount.setText("");
		this.begindate.setText("");
		this.enddate.setText("");
	}
}
