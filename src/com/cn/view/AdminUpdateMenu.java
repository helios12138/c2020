package com.cn.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.MenuDao;
import com.cn.dao.MenuGoodsDao;
import com.cn.model.Goods;
import com.cn.model.Menu;
import com.cn.model.MenuGoods;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminUpdateMenu extends JInternalFrame {
	private JTextField name;
	private JTable table;
	private JTable table_menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateMenu frame = new AdminUpdateMenu();
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
	public AdminUpdateMenu() {
		setIconifiable(true);
		setClosable(true);
		setTitle("菜谱信息");
		setBounds(100, 100, 757, 404);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("菜谱名称：");
		
		name = new JTextField();
		name.setColumns(10);
		
		JButton button = new JButton("查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findMenu();
			}
		});
		button.setIcon(new ImageIcon(AdminUpdateMenu.class.getResource("/images/搜索.png")));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel label_1 = new JLabel("商品菜谱推荐表：");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(81)
							.addComponent(label)
							.addGap(2)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 609, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addComponent(label))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(38)
									.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(14)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1)
					.addGap(5)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(131))
		);
		
		table_menu = new JTable();
		table_menu.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u7F16\u53F7", "\u5546\u54C1ID", "\u83DC\u8C31ID", "\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_menu);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickRow();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u83DC\u8C31\u7F16\u53F7", "\u83DC\u8C31\u540D\u79F0", "\u83DC\u8C31\u7528\u6599", "\u6B65\u9AA4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable("");
	}

	private void pickRow() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		String menuid = (String) table.getValueAt(row, 0);
		fillTableMenu(menuid);
	}

	private void fillTableMenu(String menuid) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table_menu.getModel();
		dtm.setRowCount(0);
		
		MenuGoodsDao menuGoodsDao = new MenuGoodsDao();
		ArrayList<MenuGoods> list = menuGoodsDao.getMenuGoods(menuid);
		
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getGoodsid());
			v.add(list.get(i).getMenuid());
			v.add(list.get(i).getDes());

			dtm.addRow(v);
		}	
	}

	private void findMenu() {
		// TODO Auto-generated method stub
		String name = this.name.getText();
		fillTable(name);
	}

	private void fillTable(String name) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		MenuDao menuDao = new MenuDao();
		ArrayList<Menu> list = menuDao.getMenu(name);

		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(Integer.toString(list.get(i).getId()));
			v.add(list.get(i).getName());
			v.add(list.get(i).getMaterials());
			v.add(list.get(i).getStep());

			dtm.addRow(v);
		}
	}
}
