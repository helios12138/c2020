package com.cn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cn.dao.FreshClassDao;
import com.cn.dao.GoodsDao;
import com.cn.model.FreshClass;
import com.cn.model.Goods;
import com.cn.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AdminAddGoods extends JInternalFrame {
	private JTextField name;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblid;
	private JLabel lblNewLabel_1;
	private JButton button;
	private JButton button_1;
	private JTextField price;
	private JTextField menberprice;
	private JTextField number;
	private JTextField spec;
	private JTextField freshclassid;
	private JTextField details;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddGoods frame = new AdminAddGoods();
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
	public AdminAddGoods() {
		setTitle("新增商品");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 276, 410);
		
		JLabel label = new JLabel("名称：");
		
		name = new JTextField();
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("价格：");
		
		label_1 = new JLabel("会员价：");
		
		label_2 = new JLabel("数量：");
		
		label_3 = new JLabel("规格：");
		
		lblid = new JLabel("类别id：");
		
		lblNewLabel_1 = new JLabel("详情：");
		
		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGoods();
			}
		});
		button.setIcon(new ImageIcon(AdminAddGoods.class.getResource("/images/submit.png")));
		
		button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(AdminAddGoods.class.getResource("/images/reset.png")));
		
		price = new JTextField();
		price.setColumns(10);
		
		menberprice = new JTextField();
		menberprice.setColumns(10);
		
		number = new JTextField();
		number.setColumns(10);
		
		spec = new JTextField();
		spec.setColumns(10);
		
		freshclassid = new JTextField();
		freshclassid.setColumns(10);
		
		details = new JTextField();
		details.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(details, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(number, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(menberprice, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(price, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spec, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblid)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(freshclassid, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
					.addGap(54))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(menberprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(number, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(spec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(freshclassid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(details, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void addGoods() {
		// TODO Auto-generated method stub
		String name = this.name.getText();
		String price = this.price.getText();
		String memberprice = this.menberprice.getText();
		String number = this.number.getText();
		String spec = this.spec.getText();
		String freshclassid = this.freshclassid.getText();
		String details = this.details.getText();
		
		if(StringUtil.isNull(name)){
			JOptionPane.showMessageDialog(null, "名称不能为空!");
			return;
		}
		if(StringUtil.isNull(price)){
			JOptionPane.showMessageDialog(null, "价格不能为空!");
			return;
		}else {
			if (!StringUtil.isNumeric(price)){
				JOptionPane.showMessageDialog(null, "价格必须为数字!");
				return;
			}
		}
		
		if(StringUtil.isNull(memberprice)){
			JOptionPane.showMessageDialog(null, "会员价不能为空!");
			return;
		}else {
			if (!StringUtil.isNumeric(memberprice)){
				JOptionPane.showMessageDialog(null, "会员价必须为数字!");
				return;
			}
		}
		if(StringUtil.isNull(number)){
			JOptionPane.showMessageDialog(null, "数量不能为空!");
			return;
		}else {
			if (!StringUtil.isNumeric(number)){
				JOptionPane.showMessageDialog(null, "数量必须为数字!");
				return;
			}
		}
		if(StringUtil.isNull(spec)){
			JOptionPane.showMessageDialog(null, "规格不能为空!");
			return;
		}
		if(StringUtil.isNull(freshclassid)){
			JOptionPane.showMessageDialog(null, "类别id不能为空!");
			return;
		}else {
			FreshClassDao flFreshClassDao = new FreshClassDao();
			ArrayList<FreshClass> list = flFreshClassDao.getFreshClass(freshclassid);
			if (list.size() != 0) {
				JOptionPane.showMessageDialog(null, "类别不存在!");
				return;
			}
		}
		
		Goods goods = new Goods(0, name, Double.parseDouble(price), Double.parseDouble(memberprice), Integer.parseInt(number), spec, Integer.parseInt(freshclassid), details);
		GoodsDao goodsDao = new GoodsDao();
		int num = goodsDao.addGoods(goods);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功！");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "该品名已存在，新增失败！");
		}
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.name.setText("");
		this.price.setText("");
		this.menberprice.setText("");
		this.number.setText("");
		this.spec.setText("");
		this.freshclassid.setText("");
		this.details.setText("");
	}
}
