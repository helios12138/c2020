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

import com.cn.dao.FreshClassDao;
import com.cn.dao.GoodsDao;
import com.cn.dao.ShoppingAddDao;
import com.cn.model.FreshClass;
import com.cn.model.Goods;
import com.cn.model.ShippingAddress;
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

public class AdminUpdateFreshClass extends JInternalFrame {
	private JTable table;
	private JTextField findfreshname;
	private JTextField textid;
	private JTextField textname;
	private JTextField textinfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateFreshClass frame = new AdminUpdateFreshClass();
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
	public AdminUpdateFreshClass() {
		setTitle("维护生鲜类别");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 660, 407);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("类别名称：");

		findfreshname = new JTextField();
		findfreshname.setColumns(10);

		JButton button = new JButton("查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findFreshClass();
			}
		});
		button.setIcon(new ImageIcon(AdminUpdateFreshClass.class.getResource("/images/搜索.png")));

		JLabel lblid = new JLabel("类别id：");

		textid = new JTextField();
		textid.setEditable(false);
		textid.setColumns(10);

		JLabel label_1 = new JLabel("类别名称：");

		textname = new JTextField();
		textname.setColumns(10);

		JLabel label_2 = new JLabel("类别信息：");

		textinfo = new JTextField();
		textinfo.setColumns(10);

		JButton btnNewButton = new JButton("更新");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFreshClass();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AdminUpdateFreshClass.class.getResource("/images/submit.png")));

		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delFreshClass();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminUpdateFreshClass.class.getResource("/images/删除(1).png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout
						.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(33).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(71).addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(findfreshname, GroupLayout.PREFERRED_SIZE, 149,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(button)))
						.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(73)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textname))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblid)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textid,
												GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(label_2)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textinfo,
												GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, Alignment.TRAILING)
								.addComponent(btnNewButton_1, Alignment.TRAILING))
						.addGap(115)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addGap(33).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
								.addComponent(findfreshname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup().addGap(37)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid)
										.addComponent(textid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
										.addComponent(textname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(label_2))
										.addGroup(groupLayout.createSequentialGroup().addGap(17).addComponent(textinfo,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(btnNewButton)
										.addGap(25).addComponent(btnNewButton_1)))
						.addContainerGap(40, Short.MAX_VALUE)));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickrow();
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, },
				new String[] { "\u7C7B\u522Bid", "\u7C7B\u522B\u540D\u79F0", "\u7C7B\u522B\u4FE1\u606F" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

		this.fillTable("");
	}

	protected void updateFreshClass() {
		// TODO Auto-generated method stub
		String id = this.textid.getText();
		String name = this.textname.getText();
		String info = this.textinfo.getText();

		if (StringUtil.isNull(id)) {
			JOptionPane.showMessageDialog(null, "id不能为空!");
			return;
		}

		if (StringUtil.isNull(name)) {
			JOptionPane.showMessageDialog(null, "类别名称不能为空!");
			return;
		}

		if (StringUtil.isNull(info)) {
			JOptionPane.showMessageDialog(null, "信息不能为空!");
			return;
		}

		FreshClass freshClass = new FreshClass(Integer.parseInt(id), name, info);
		FreshClassDao freshClassDao = new FreshClassDao();
		if (freshClassDao.updateFreshClass(freshClass) != 0) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			fillTable("");
		} else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
	}

	protected void delFreshClass() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该生鲜类别？");
		if (result == 0) {
			String id = this.textid.getText();

			// 删除之前判断是否有商品属于该类别
			GoodsDao goodsDao = new GoodsDao();
			ArrayList<Goods> list = goodsDao.getGoods_freshclassid(Integer.parseInt(id));
			if (list.size() != 0) {
				JOptionPane.showMessageDialog(null, "商品信息中存在该类别，无法删除!");
			} else {
				FreshClassDao freshClassDao = new FreshClassDao();
				freshClassDao.delFreshClass(Integer.parseInt(id));
				fillTable("");
				initTable();
			}
		}

	}

	private void initTable() {
		// TODO Auto-generated method stub
		this.textid.setText("");
		this.textname.setText("");
		this.textinfo.setText("");
	}

	protected void pickrow() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		this.textid.setText((String) table.getValueAt(row, 0));
		this.textname.setText((String) table.getValueAt(row, 1));
		this.textinfo.setText((String) table.getValueAt(row, 2));
	}

	protected void findFreshClass() {
		// TODO Auto-generated method stub
		String name = this.findfreshname.getText();
		fillTable(name);
	}

	private void fillTable(String name) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		FreshClassDao freshClassDao = new FreshClassDao();
		ArrayList<FreshClass> list = freshClassDao.getFreshClass(name);

		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getName());
			v.add(list.get(i).getInfo());

			dtm.addRow(v);
		}
	}
}
