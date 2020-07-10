package cn.edu.zucc.supermark.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cn.dao.UserDao;
import com.cn.model.User;
import com.cn.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AdminAddUser extends JInternalFrame {
	private JTextField username;
	private JTextField userpassword;
	private JTextField userphone;
	private JTextField useremail;
	private JTextField usercity;
	
	private JRadioButton manButton;
	private JRadioButton womanButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddUser frame = new AdminAddUser();
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
	public AdminAddUser() {
		setIconifiable(true);
		setClosable(true);
		setTitle("添加用户");
		setBounds(100, 100, 248, 353);
		
		JLabel label = new JLabel("�?  名：");
		
		username = new JTextField();
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("�?  别：");
		
		manButton = new JRadioButton("�?");
		
		womanButton = new JRadioButton("�?");
		
		JLabel label_1 = new JLabel("�?  码：");
		
		userpassword = new JTextField();
		userpassword.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("�?  话：");
		
		userphone = new JTextField();
		userphone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("�?  箱：");
		
		useremail = new JTextField();
		useremail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("�?  市：");
		
		usercity = new JTextField();
		usercity.setColumns(10);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(4)
									.addComponent(username, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(4)
									.addComponent(manButton)
									.addGap(18)
									.addComponent(womanButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(4)
									.addComponent(userpassword, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(usercity))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(useremail))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addGap(4)
										.addComponent(userphone, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel))
						.addComponent(manButton)
						.addComponent(womanButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(userpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_1))
						.addComponent(userphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(useremail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(usercity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		ButtonGroup group=new ButtonGroup();
		group.add(manButton);
		group.add(womanButton);
	}

	protected void addUser() {
		// TODO Auto-generated method stub
		String username = this.username.getText();
		String sex;
		if (this.manButton.isSelected()){
			sex = new String("�?");
		}else if (this.womanButton.isSelected()) {
			sex = new String("�?");
		}else {
			JOptionPane.showMessageDialog(null, "请�?�择性别!");
			return;
		}
		
		String password = this.userpassword.getText();
		String phone = this.userphone.getText();
		String email = this.useremail.getText();
		String city = this.usercity.getText();
		Timestamp signtime = new Timestamp(new Date().getTime());
		
		if(StringUtil.isNull(username)){
			JOptionPane.showMessageDialog(null, "姓名不能为空!");
			return;
		}
		
		if(StringUtil.isNull(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}
		
		if(StringUtil.isNull(phone)){
			JOptionPane.showMessageDialog(null, "电话不能为空!");
			return;
		}
		
		if(StringUtil.isNull(email)){
			JOptionPane.showMessageDialog(null, "邮箱不能为空!");
			return;
		}
		
		if(StringUtil.isNull(city)){
			JOptionPane.showMessageDialog(null, "城市不能为空!");
			return;
		}
		
		String ismember = "�?";		
		User user = new User(username, sex, password, phone, email, city, signtime, ismember);
		
		UserDao ud = new UserDao();
		int num = ud.addUser(user);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功�?");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "用户已存在，新增失败�?");
		}
	}

	protected void reset() {
		// TODO Auto-generated method stub
		this.username.setText("");
		this.userpassword.setText("");
		this.useremail.setText("");
		this.userphone.setText("");
		this.usercity.setText("");
	}
}
