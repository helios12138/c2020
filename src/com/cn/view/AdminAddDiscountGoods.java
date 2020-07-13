package com.cn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cn.dao.DiscountDao;
import com.cn.dao.DiscountGoodsDao;
import com.cn.dao.GoodsDao;
import com.cn.model.Discount;
import com.cn.model.DiscountGoods;
import com.cn.model.Goods;
import com.cn.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AdminAddDiscountGoods extends JInternalFrame {
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
					AdminAddDiscountGoods frame = new AdminAddDiscountGoods();
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
	public AdminAddDiscountGoods() {
		setIconifiable(true);
		setClosable(true);
		setTitle("新增满折商品表");
		setBounds(100, 100, 277, 293);
		
		JLabel lblid = new JLabel("满折id：");
		
		discountid = new JTextField();
		discountid.setColumns(10);
		
		JLabel lblid_1 = new JLabel("商品id：");
		
		goodsid = new JTextField();
		goodsid.setColumns(10);
		
		JLabel label = new JLabel("开始时间：");
		
		begindate = new JTextField();
		begindate.setColumns(10);
		
		JLabel label_1 = new JLabel("截止时间：");
		
		enddate = new JTextField();
		enddate.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		button.setIcon(new ImageIcon(AdminAddDiscountGoods.class.getResource("/images/submit.png")));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(AdminAddDiscountGoods.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(lblid_1)
								.addComponent(lblid))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(discountid, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(begindate, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addComponent(goodsid)
										.addComponent(enddate, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(lblid))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(discountid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid_1)
						.addComponent(goodsid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(begindate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(enddate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(238, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void submit() {
		// TODO Auto-generated method stub
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
		
		DiscountGoods discountGoods = new DiscountGoods(0, Integer.parseInt(discountid), Integer.parseInt(goodsid), begintime, endtime);
		DiscountGoodsDao discountGoodsDao = new DiscountGoodsDao();
		int num = discountGoodsDao.addDiscountGood(discountGoods);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功！");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "该商品的满折信息已存在，新增失败！");
		}
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.discountid.setText("");
		this.goodsid.setText("");
		this.begindate.setText("");
		this.enddate.setText("");
		
	}

}
