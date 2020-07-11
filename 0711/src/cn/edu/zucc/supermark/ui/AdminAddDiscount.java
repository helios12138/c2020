package cn.edu.zucc.supermark.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import cn.edu.zucc.supermark.a.DiscountDao;
import cn.edu.zucc.supermark.model.Discount;
import cn.edu.zucc.supermark.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class AdminAddDiscount extends JInternalFrame {
	private JTextField content;
	private JTextField discount;
	private JTextField begindate;
	private JTextField enddate;
	private JTextField goodsnum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddDiscount frame = new AdminAddDiscount();
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
	public AdminAddDiscount() {
		setIconifiable(true);
		setClosable(true);
		setTitle("新增满折信息");
		setBounds(100, 100, 275, 338);
		
		JLabel label = new JLabel("内容：");
		
		content = new JTextField();
		content.setColumns(10);
		
		JLabel label_1 = new JLabel("适用数量：");
		
		goodsnum = new JTextField();
		goodsnum.setColumns(10);
		
		JLabel label_2 = new JLabel("折扣：");
		
		discount = new JTextField();
		discount.setColumns(10);
		
		JLabel label_3 = new JLabel("开始时间：");
		
		begindate = new JTextField();
		begindate.setColumns(10);
		
		JLabel label_4 = new JLabel("截止时间：");
		
		enddate = new JTextField();
		enddate.setColumns(10);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submin();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AdminAddDiscount.class.getResource("/images/submit.png")));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminAddDiscount.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(discount)
										.addComponent(goodsnum)
										.addComponent(content, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(begindate, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(label_4)
							.addGap(1)
							.addComponent(enddate, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(btnNewButton)
							.addGap(24)
							.addComponent(btnNewButton_1)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(content, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(goodsnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(discount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(begindate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(label_4))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(enddate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(btnNewButton_1)))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	

	private void submin() {
		// TODO Auto-generated method stub
		String content = this.content.getText();
		String goodsunm = this.goodsnum.getText();
		String discount = this.discount.getText();
		String begindate = this.begindate.getText();
		String enddate = this.enddate.getText();
		
		if(StringUtil.isNull(content)){
			JOptionPane.showMessageDialog(null, "内容不能为空!");
			return;
		}
		if(StringUtil.isNull(goodsunm)){
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
		
		Discount discount1 = new Discount(0, content, Integer.parseInt(goodsunm), Double.parseDouble(discount), begintime, endtime);
		DiscountDao discountDao = new DiscountDao();
		int num = discountDao.addDiscount(discount1);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功！");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "满折内容已存在，新增失败！");
		}
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.content.setText("");
		this.goodsnum.setText("");
		this.discount.setText("");
		this.begindate.setText("");
		this.enddate.setText("");
	}

}
