package cn.edu.zucc.supermark.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import cn.edu.zucc.supermark.a.AdminDao;
import cn.edu.zucc.supermark.model.Admin;
import cn.edu.zucc.supermark.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAdmin extends JInternalFrame {
	private JTextField adminname;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdmin frame = new AddAdmin();
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
	public AddAdmin() {
		setTitle("添加管理员");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 276, 269);
		
		JLabel label = new JLabel("账号：");
		
		adminname = new JTextField();
		adminname.setColumns(10);
		
		JLabel label_1 = new JLabel("密码：");
		
		password = new JTextField();
		password.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAdmin();
			}
		});
		button.setIcon(new ImageIcon(AddAdmin.class.getResource("/images/submit.png")));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(AddAdmin.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(password))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(adminname, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(adminname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void addAdmin() {
		// TODO Auto-generated method stub
		String adminname = this.adminname.getText();
		String password = this.password.getText();
		
		if(StringUtil.isNull(adminname)){
			JOptionPane.showMessageDialog(null, "账号不能为空!");
			return;
		}
		
		if(StringUtil.isNull(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}
		
		Admin admin = new Admin(adminname, password);
		AdminDao ad = new AdminDao();
		int num = ad.addAdmin(admin);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功！");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "管理员已存在，新增失败！");
		}
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.adminname.setText("");
		this.password.setText("");
	}

}
