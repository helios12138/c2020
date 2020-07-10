package cn.edu.zucc.supermark.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cn.dao.UserDao;
import com.cn.model.User;
import com.cn.util.StringUtil;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.awt.event.ActionEvent;

public class UserRegist extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField phone;
	private JTextField email;
	private JTextField city;
	private JTable table;
	private JRadioButton man;
	private JRadioButton woman;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegist frame = new UserRegist();
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
	public UserRegist() {
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("�?    名：");
		
		JLabel lblNewLabel_1 = new JLabel("�?    别：");
		
		JLabel lblNewLabel_2 = new JLabel("�?    码：");
		
		JLabel lblNewLabel_3 = new JLabel("�?    话：");
		
		JLabel lblNewLabel_4 = new JLabel("�?    箱：");
		
		JLabel lblNewLabel_2_1 = new JLabel("�?    市：");
		
		username = new JTextField();
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		
		phone = new JTextField();
		phone.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		
		city = new JTextField();
		city.setColumns(10);
		
		table = new JTable();
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registUser();
			}
		});
	
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		
		man = new JRadioButton("�?");
		
		woman = new JRadioButton("�?");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(username, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
										.addComponent(password)
										.addComponent(phone)
										.addComponent(email)
										.addComponent(city)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(18)
									.addComponent(btnNewButton_1)))
							.addGap(18)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(man)
							.addGap(18)
							.addComponent(woman)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(man)
						.addComponent(woman))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton))))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		ButtonGroup group=new ButtonGroup();
		group.add(man);
		group.add(woman);
		
		//窗口居中
		this.setLocationRelativeTo(null);
	}
	
	//注册用户
	private void registUser() {
		// TODO Auto-generated method stub
		String username = this.username.getText();
		String sex;
		if (this.man.isSelected()){
			sex = new String("�?");
		}else if (this.woman.isSelected()) {
			sex = new String("�?");
		}else {
			JOptionPane.showMessageDialog(null, "请�?�择性别!");
			return;
		}
		
		String password = this.password.getText();
		String phone = this.phone.getText();
		String email = this.email.getText();
		String city = this.city.getText();
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
	
	//重置
	private void resetButton() {
		// TODO Auto-generated method stub
		this.username.setText("");
		this.password.setText("");
		this.phone.setText("");
		this.email.setText("");
		this.city.setText("");		
	}
}
