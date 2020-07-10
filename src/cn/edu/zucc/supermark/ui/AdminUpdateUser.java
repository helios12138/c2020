package cn.edu.zucc.supermark.ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.cn.dao.UserDao;
import com.cn.model.User;
import com.cn.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AdminUpdateUser extends JInternalFrame {
	private JTable usertable;
	private JTextField usernametext;
	private JTextField textname;
	private JTextField textpassword;
	private JTextField textphone;
	private JTextField textemail;
	private JTextField textcity;
	private JTextField textsigntime;
	private JTextField textmembertime;

	private JRadioButton radioman;
	private JRadioButton rediowoman;
	private JRadioButton radioismember;
	private JRadioButton radionomember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateUser frame = new AdminUpdateUser();
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
	public AdminUpdateUser() {
		setIconifiable(true);
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("维护用户信息");
		setBounds(100, 100, 799, 600);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("用户姓名�?");

		usernametext = new JTextField();
		usernametext.setColumns(10);

		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindUser();
			}
		});
		

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(81).addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, 128,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(button).addContainerGap(405, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addContainerGap(43, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(panel, GroupLayout.PREFERRED_SIZE, 704,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 706,
																GroupLayout.PREFERRED_SIZE))
												.addGap(34)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(38)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE).addGap(37)));

		JLabel label = new JLabel("姓名�?");

		textname = new JTextField();
		textname.setEditable(false);
		textname.setColumns(10);

		JLabel label_1 = new JLabel("性别�?");

		radioman = new JRadioButton("�?");
		radioman.setEnabled(false);

		rediowoman = new JRadioButton("�?");
		rediowoman.setEnabled(false);

		JLabel label_2 = new JLabel("密码�?");

		textpassword = new JTextField();
		textpassword.setColumns(10);

		JLabel label_3 = new JLabel("电话�?");

		textphone = new JTextField();
		textphone.setColumns(10);

		JLabel label_4 = new JLabel("邮箱�?");

		textemail = new JTextField();
		textemail.setColumns(10);

		JLabel label_5 = new JLabel("�?    市：");

		textcity = new JTextField();
		textcity.setColumns(10);

		JLabel label_6 = new JLabel("注册时间�?");

		textsigntime = new JTextField();
		textsigntime.setEditable(false);
		textsigntime.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("是否会员�?");

		JLabel lblNewLabel_2 = new JLabel("会员时间�?");

		radioismember = new JRadioButton("�?");

		radionomember = new JRadioButton("�?");

		textmembertime = new JTextField();
		textmembertime.setColumns(10);

		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});


		JButton btnNewButton = new JButton("删除");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delUser();
			}
		});
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(39)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_4)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textemail))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label_3).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
										textphone, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_2)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textpassword))
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_1)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(radioman).addGap(18)
								.addComponent(rediowoman))
						.addGroup(gl_panel.createSequentialGroup().addComponent(label)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textname,
										GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
				.addGap(47)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label_5).addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textcity, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(label_6)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(textsigntime,
										GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(radioismember)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(radionomember))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(textmembertime)))
				.addPreferredGap(ComponentPlacement.RELATED, 55, GroupLayout.PREFERRED_SIZE).addGroup(gl_panel
						.createParallelGroup(Alignment.LEADING).addComponent(button_1).addComponent(btnNewButton))
				.addGap(70)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label)
												.addComponent(textname, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_5)
												.addComponent(textcity, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_1))
										.addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
												.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(label_1).addComponent(radioman)
														.addComponent(rediowoman))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(label_2).addComponent(
																textpassword, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_1).addComponent(radioismember)
														.addComponent(radionomember))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(label_3)
														.addComponent(textphone, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_2)
														.addComponent(textmembertime, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(label_4).addComponent(textemail,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(label_6)
														.addComponent(textsigntime, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnNewButton)))
										.addContainerGap(23, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		usertable = new JTable();
		usertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickrow(e);
			}
		});
		usertable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, "", null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "\u59D3\u540D", "\u6027\u522B", "\u5BC6\u7801", "\u7535\u8BDD", "\u90AE\u7BB1",
						"\u57CE\u5E02", "\u6CE8\u518C\u65F6\u95F4", "\u662F\u5426\u4F1A\u5458",
						"\u4F1A\u5458\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		usertable.getColumnModel().getColumn(0).setPreferredWidth(52);
		usertable.getColumnModel().getColumn(1).setPreferredWidth(53);
		usertable.getColumnModel().getColumn(2).setPreferredWidth(63);
		scrollPane.setViewportView(usertable);
		getContentPane().setLayout(groupLayout);

		this.fillTable("");

		ButtonGroup group1 = new ButtonGroup();
		group1.add(radioman);
		group1.add(rediowoman);

		ButtonGroup group2 = new ButtonGroup();
		group2.add(radioismember);
		group2.add(radionomember);
	}
	
	//更新用户
	private void updateUser() {
		// TODO Auto-generated method stub
		String username = this.textname.getText();
		String password = this.textpassword.getText();
		String phone = this.textphone.getText();
		String email = this.textemail.getText();
		String city = this.textcity.getText();
		String ismember;
		if (this.radioismember.isSelected()) {
			ismember = new String("�?");
		} else {
			ismember = new String("�?");
		}
		
		Timestamp membertime = null;
		String time = this.textmembertime.getText();
		if (time != null && !"".equals(time)){
			if (this.radionomember.isSelected()){
				JOptionPane.showMessageDialog(null, "不是会员，不可填入会员时间！");
				return;
			}
					
			if (StringUtil.isValidDate(time)) {
				membertime = new Timestamp(System.currentTimeMillis());
				membertime = Timestamp.valueOf(time);
			} else {
				JOptionPane.showMessageDialog(null, "时间格式错误，请重新输入格式�?2000-02-02 20:10:20�?");
				return;
			}
		}else {
			if (this.radioismember.isSelected()){
				JOptionPane.showMessageDialog(null, "是会员，会员时间不能为空�?");
				return;
			}
		}
		
		User user = new User(username, "", password, phone, email, city, membertime, ismember, membertime);
		UserDao ud = new UserDao();
		if (ud.updateUser(user) != 0){
			JOptionPane.showMessageDialog(null, "修改成功�?");
			fillTable("");
		}else {
			JOptionPane.showMessageDialog(null, "修改失败�?");
		}
	}
	
	//清空列表
	private void initTable() {
		this.textname.setText("");
		this.radioman.setSelected(false);
		this.rediowoman.setSelected(false);
		this.textpassword.setText("");
		this.textphone.setText("");
		this.textemail.setText("");
		this.textcity.setText("");
		this.textsigntime.setText("");
		this.radioismember.setSelected(false);
		this.radionomember.setSelected(false);
		this.textmembertime.setText("");
	}
	
	//删除用户
	private void delUser() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该用户？");
		if (result == 0) {
			String username = this.textname.getText();
			UserDao ud = new UserDao();
			ud.delUser(username);
			fillTable("");
			initTable();
		}
	}
	
	//选择�?
	private void pickrow(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = usertable.getSelectedRow();
		this.textname.setText((String) usertable.getValueAt(row, 0));

		if ("�?".equals(usertable.getValueAt(row, 1))) {
			this.radioman.setSelected(true);
		} else {
			this.rediowoman.setSelected(true);
		}

		this.textpassword.setText((String) usertable.getValueAt(row, 2));
		this.textphone.setText((String) usertable.getValueAt(row, 3));
		this.textemail.setText((String) usertable.getValueAt(row, 4));
		this.textcity.setText((String) usertable.getValueAt(row, 5));
		this.textsigntime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(usertable.getValueAt(row, 6)));

		if ("�?".equals(usertable.getValueAt(row, 7))) {
			this.radioismember.setSelected(true);
		} else {
			this.radionomember.setSelected(true);
		}

		if (usertable.getValueAt(row, 8) != null && usertable.getValueAt(row, 8) != "") {
			this.textmembertime
					.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(usertable.getValueAt(row, 8)));
		} else {
			this.textmembertime.setText("");
		}
	}
	
	//查找用户
	private void FindUser() {
		// TODO Auto-generated method stub
		String username = this.usernametext.getText();
		fillTable(username);
	}

	private void fillTable(String username) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) usertable.getModel();
		dtm.setRowCount(0);

		UserDao ud = new UserDao();
		ArrayList<User> list = ud.getUser(username);
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(list.get(i).getUsername());
			v.add(list.get(i).getSex());
			v.add(list.get(i).getPassword());
			v.add(list.get(i).getPhone());
			v.add(list.get(i).getEmail());
			v.add(list.get(i).getCity());
			v.add(list.get(i).getSigntime());
			v.add(list.get(i).getIsmember());
			v.add(list.get(i).getMembertime());
			dtm.addRow(v);
		}
	}
}
