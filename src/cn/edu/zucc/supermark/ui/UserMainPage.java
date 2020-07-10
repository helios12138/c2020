package cn.edu.zucc.supermark.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMainPage extends JFrame {

	private JPanel contentPane;
	private static UserMainPage frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserMainPage();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainPage frame = new UserMainPage();
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
	public UserMainPage() {
		setTitle("\u7528\u6237\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 746);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u751F\u9C9C\u91C7\u8D2D");
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("\u8BA2\u5355\u67E5\u8BE2");

		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		
		menuBar.add(menu_3);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		menu_3.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 758, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 510, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		//窗口居中
		this.setLocationRelativeTo(null);
	}

	private void exit() {
		// TODO Auto-generated method stub
		dispose();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
