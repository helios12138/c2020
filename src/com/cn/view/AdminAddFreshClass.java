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
import com.cn.model.FreshClass;
import com.cn.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAddFreshClass extends JInternalFrame {
	private JTextField name;
	private JTextField info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddFreshClass frame = new AdminAddFreshClass();
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
	public AdminAddFreshClass() {
		setTitle("添加生鲜类别");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 267, 218);
		
		JLabel label = new JLabel("类别：");
		
		name = new JTextField();
		name.setColumns(10);
		
		JLabel label_1 = new JLabel("信息：");
		
		info = new JTextField();
		info.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFreshClass();
			}
		});
		button.setIcon(new ImageIcon(AdminAddFreshClass.class.getResource("/images/submit.png")));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(AdminAddFreshClass.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(info, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(name))))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(info, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void addFreshClass() {
		// TODO Auto-generated method stub
		String name = this.name.getText();
		String info = this.info.getText();
		
		if(StringUtil.isNull(name)){
			JOptionPane.showMessageDialog(null, "类别不能为空!");
			return;
		}
		
		if(StringUtil.isNull(info)){
			JOptionPane.showMessageDialog(null, "信息不能为空!");
			return;
		}
		
		FreshClass freshClass = new FreshClass(0, name, info);
		FreshClassDao freshClassDao = new FreshClassDao();
		
		int num = freshClassDao.addFreshClass(freshClass);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功！");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "类别已存在，新增失败！");
		}	
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.name.setText("");
		this.info.setText("");
		
	}

}
