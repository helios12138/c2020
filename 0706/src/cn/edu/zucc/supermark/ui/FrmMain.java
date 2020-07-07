package cn.edu.zucc.supermark.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import cn.edu.zucc.supermark.ui.FrmLogin;

import cn.edu.zucc.supermark.control.SystemUserManager;


public class FrmMain extends JFrame implements ActionListener{

	private JMenuBar menubar=new JMenuBar();
	private JMenu menu_fresh=new JMenu("���ʷ���");
	private JMenu menu_youhui=new JMenu("�Ż���Ϣ");
	private JMenu menu_user=new JMenu("�û���Ϣ");
	private JMenu menu_worker=new JMenu("����Ա");
	private JMenuItem menuItem_

    
	private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	public FrmMain(){
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("��������");
		dlgLogin=new FrmLogin(this,"��½",true);
		dlgLogin.setVisible(true);
	   
	    //״̬��
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("����!"+SystemUserManager.currentUser.getUsername());
	    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
	    this.addWindowListener(new WindowAdapter(){   
	    	public void windowClosing(WindowEvent e){ 
	    		System.exit(0);
             }
        });
	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
