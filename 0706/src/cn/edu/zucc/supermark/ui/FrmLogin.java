package cn.edu.zucc.supermark.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import cn.edu.zucc.supermark.control.SystemUserManager;
import cn.edu.zucc.supermark.model.BeanSystemUser;
//import cn.edu.zucc.supermark.model.BeanSystemUser;
import cn.edu.zucc.supermark.util.BaseException;


public class FrmLogin extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnzhuce = new Button("注册");
	private Button btnLogin = new Button("登陆");
	private Button btnCancel = new Button("退出");
	private JLabel labelUser = new JLabel("用户：");
	private JLabel labelPwd = new JLabel("密码：");
	private JRadioButton jb1= new JRadioButton("管理员");
	private JRadioButton jb2= new JRadioButton("顾客");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);
	int edtwork=0;

	
	public FrmLogin(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new GridLayout(2,1));
		ButtonGroup group=new ButtonGroup();
		group.add(jb1);
		group.add(jb2);
		toolBar.add(this.jb1);
		toolBar.add(this.jb2);
		//f.add(toolBar);
		//this.setVisible(true);
		if(jb1.isSelected()){
			edtwork=1;
		}
		if(jb2.isSelected()){
			edtwork=2;
		}


		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnzhuce);
		toolBar.add(btnLogin);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(edtUserId);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(280, 140);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();


		btnzhuce.addActionListener(this);
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin) {
			SystemUserManager sum=new SystemUserManager();
			String userid=this.edtUserId.getText();
			int work=edtwork;
			String pwd=new String(this.edtPwd.getPassword());
			try {
				BeanSystemUser user=sum.loadUser(userid);
				if(pwd.equals(user.getPwd())){
					SystemUserManager.currentUser=user;
					setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null,  "密码错误","错误提示",JOptionPane.ERROR_MESSAGE);
				}
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误提示",JOptionPane.ERROR_MESSAGE);
			}
			
			
		} else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		}
		else if(e.getSource()==this.btnzhuce){
			FrmZhuce dlg=new FrmZhuce(this,"注册",true);
			dlg.setVisible(true);
		}
	}
}
