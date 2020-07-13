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

import com.cn.dao.AdminDao;
import com.cn.dao.UserDao;
import com.cn.model.Admin;
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

public class UpdateAdmin extends JInternalFrame {
	private JTable admintable;
	private JTextField findadminname;
	private JTextField textid;
	private JTextField textadminname;
	private JTextField textpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAdmin frame = new UpdateAdmin();
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
	public UpdateAdmin() {
		setTitle("管理员信息维护");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 530, 474);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("账户名称：");

		findadminname = new JTextField();
		findadminname.setColumns(10);

		JButton button = new JButton("查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findAdmin();
			}
		});
		button.setIcon(new ImageIcon(UpdateAdmin.class.getResource("/images/搜索.png")));

		JLabel lblid = new JLabel("管 理 员 id：");

		textid = new JTextField();
		textid.setEditable(false);
		textid.setColumns(10);

		JLabel label_1 = new JLabel("管理员账户：");

		JLabel label_2 = new JLabel("密      码：");

		textadminname = new JTextField();
		textadminname.setColumns(10);

		textpassword = new JTextField();
		textpassword.setColumns(10);

		JButton btnNewButton = new JButton("更新");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAdmin();
			}
		});
		btnNewButton.setIcon(new ImageIcon(UpdateAdmin.class.getResource("/images/submit.png")));

		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delAdmin();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UpdateAdmin.class.getResource("/images/删除(1).png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addGap(104).addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(findadminname, GroupLayout.PREFERRED_SIZE, 142,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(button))
								.addGroup(groupLayout
										.createParallelGroup(
												Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup()
														.addGroup(
																groupLayout
																		.createParallelGroup(Alignment.LEADING,
																				false)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGap(81)
																				.addGroup(groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addGroup(groupLayout
																								.createSequentialGroup()
																								.addComponent(label_1)
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)
																								.addComponent(
																										textadminname,
																										GroupLayout.PREFERRED_SIZE,
																										109,
																										GroupLayout.PREFERRED_SIZE))
																						.addGroup(groupLayout
																								.createSequentialGroup()
																								.addComponent(lblid)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(textid))))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGap(80).addComponent(label_2)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(textpassword)))
														.addPreferredGap(ComponentPlacement.RELATED, 66,
																Short.MAX_VALUE)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(btnNewButton)
																.addComponent(btnNewButton_1)))
										.addGroup(
												groupLayout.createSequentialGroup().addGap(72).addComponent(scrollPane,
														GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE))))
						.addGap(89)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
								.addComponent(findadminname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid)
								.addComponent(textid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(textadminname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1))
						.addGap(21)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
								.addComponent(textpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(103, Short.MAX_VALUE)));

		admintable = new JTable();
		admintable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickRow();
			}
		});
		admintable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, },
				new String[] { "\u7BA1\u7406\u5458id", "\u7BA1\u7406\u5458\u8D26\u6237", "\u5BC6\u7801" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(admintable);
		getContentPane().setLayout(groupLayout);

		this.fillTable("");
	}

	private void updateAdmin() {
		// TODO Auto-generated method stub
		String id = this.textid.getText();
		String adminname = this.textadminname.getText();
		String password = this.textpassword.getText();
		if (StringUtil.isNull(adminname)) {
			JOptionPane.showMessageDialog(null, "账号不能为空!");
			return;
		}

		if (StringUtil.isNull(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}

		Admin admin = new Admin(Integer.parseInt(id), adminname, password);
		AdminDao adminDao = new AdminDao();
		int num = adminDao.updateAdmin(admin);
		
		if (num != 0){
			JOptionPane.showMessageDialog(null, "修改成功！");
			fillTable("");
		}else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
	}

	private void delAdmin() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该管理员？");
		if (result == 0) {
			String id = this.textid.getText();
			AdminDao adminDao = new AdminDao();
			adminDao.delAdmin(Integer.parseInt(id));
			fillTable("");
			initTable();
		}
	}

	private void initTable() {
		// TODO Auto-generated method stub
		this.textid.setText("");
		this.textadminname.setText("");
		this.textpassword.setText("");
	}

	private void pickRow() {
		// TODO Auto-generated method stub
		int row = admintable.getSelectedRow();
		this.textid.setText(String.valueOf(admintable.getValueAt(row, 0)));
		this.textadminname.setText((String) admintable.getValueAt(row, 1));
		this.textpassword.setText((String) admintable.getValueAt(row, 2));
	}

	private void findAdmin() {
		// TODO Auto-generated method stub
		String adminname = this.findadminname.getText();
		fillTable(adminname);
	}

	private void fillTable(String adminname) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) admintable.getModel();
		dtm.setRowCount(0);

		AdminDao adminDao = new AdminDao();
		ArrayList<Admin> list = adminDao.getAdmin(adminname);

		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(list.get(i).getId());
			v.add(list.get(i).getAdminname());
			v.add(list.get(i).getPassword());

			dtm.addRow(v);
		}
	}
}
