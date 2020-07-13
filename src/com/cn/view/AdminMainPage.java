package com.cn.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class AdminMainPage extends JFrame {

	private JPanel contentPane;
	private static AdminMainPage adminMainPage;
	private JDesktopPane table = null;

	static {

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMainPage = new AdminMainPage();
					adminMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// static{
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// adminMainPage = new AdminMainPage();
	// adminMainPage.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public AdminMainPage() {
		setTitle("管理员主页");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 846);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("用户信息管理");
		menu.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/\u7528\u6237.png")));
		menuBar.add(menu);

		JMenu menu_2 = new JMenu("用户信息维护");
		menu.add(menu_2);

		JMenuItem menuItem_1 = new JMenuItem("新增用户信息");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddUser aau = new AdminAddUser();
				aau.setVisible(true);
				table.add(aau);
			}
		});
		menu_2.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("维护用户信息");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdateUser adminUpdateUser = new AdminUpdateUser();
				adminUpdateUser.setVisible(true);
				table.add(adminUpdateUser);
			}
		});
		menu_2.add(menuItem_2);

		JMenu menu_3 = new JMenu("配送地址维护");
		menu.add(menu_3);

		JMenuItem menuItem_3 = new JMenuItem("新增配送地址");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddShopAddress aasa = new AdminAddShopAddress();
				aasa.setVisible(true);
				table.add(aasa);

			}
		});
		menu_3.add(menuItem_3);

		JMenuItem menuItem_4 = new JMenuItem("维护配送地址");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdateShopAddress ausa = new AdminUpdateShopAddress();
				ausa.setVisible(true);
				table.add(ausa);
			}
		});
		menu_3.add(menuItem_4);

		JMenu mnNewMenu_1 = new JMenu("优惠信息管理");
		mnNewMenu_1.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/\u4F18\u60E0\u5238.png")));
		menuBar.add(mnNewMenu_1);

		JMenu menu_4 = new JMenu("优惠券信息维护");
		mnNewMenu_1.add(menu_4);

		JMenuItem menuItem_5 = new JMenuItem("新增优惠券");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddCoupon adminAddCoupon = new AdminAddCoupon();
				adminAddCoupon.setVisible(true);
				table.add(adminAddCoupon);
			}
		});
		menu_4.add(menuItem_5);

		JMenuItem menuItem_6 = new JMenuItem("维护优惠券信息");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdateCoupon adminUpdateCoupon = new AdminUpdateCoupon();
				adminUpdateCoupon.setVisible(true);
				table.add(adminUpdateCoupon);
			}
		});
		menu_4.add(menuItem_6);

		JMenu menu_8 = new JMenu("满折信息维护");
		mnNewMenu_1.add(menu_8);

		JMenuItem mntmXin = new JMenuItem("新增满折信息");
		mntmXin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddDiscount addDiscount = new AdminAddDiscount();
				addDiscount.setVisible(true);
				table.add(addDiscount);
			}
		});
		menu_8.add(mntmXin);

		JMenuItem menuItem_12 = new JMenuItem("维护满折信息");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdateDiscount adminUpdateDiscount = new AdminUpdateDiscount();
				adminUpdateDiscount.setVisible(true);
				table.add(adminUpdateDiscount);
			}
		});
		menu_8.add(menuItem_12);
		
		JMenu menu_11 = new JMenu("满折商品信息维护");
		mnNewMenu_1.add(menu_11);
		
		JMenuItem menuItem_17 = new JMenuItem("新增满折商品表");
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddDiscountGoods adminAddDiscountGoods = new AdminAddDiscountGoods();
				adminAddDiscountGoods.setVisible(true);
				table.add(adminAddDiscountGoods);
			}
		});
		menu_11.add(menuItem_17);
		
		JMenuItem menuItem_18 = new JMenuItem("维护满折商品表");
		menuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdateDiscountGoods adminUpdateDiscountGoods = new AdminUpdateDiscountGoods();
				adminUpdateDiscountGoods.setVisible(true);
				table.add(adminUpdateDiscountGoods);
			}
		});
		menu_11.add(menuItem_18);

		JMenu mnNewMenu = new JMenu("生鲜信息管理");
		mnNewMenu.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/\u9C7C.png")));
		menuBar.add(mnNewMenu);

		JMenu menu_5 = new JMenu("生鲜类别维护");
		mnNewMenu.add(menu_5);

		JMenuItem menuItem_7 = new JMenuItem("新增生鲜类别");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddFreshClass adminAddFreshClass = new AdminAddFreshClass();
				adminAddFreshClass.setVisible(true);
				table.add(adminAddFreshClass);
			}
		});
		menu_5.add(menuItem_7);

		JMenuItem menuItem_8 = new JMenuItem("维护生鲜类别");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdateFreshClass adminUpdateFreshClass = new AdminUpdateFreshClass();
				adminUpdateFreshClass.setVisible(true);
				table.add(adminUpdateFreshClass);
			}
		});
		menu_5.add(menuItem_8);

		JMenu menu_6 = new JMenu("商品信息维护");
		mnNewMenu.add(menu_6);

		JMenuItem menuItem_9 = new JMenuItem("新增商品");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddGoods adminAddGoods = new AdminAddGoods();
				adminAddGoods.setVisible(true);
				table.add(adminAddGoods);
			}
		});
		menu_6.add(menuItem_9);

		JMenuItem menuItem_10 = new JMenuItem("维护商品信息");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdateGoods adminUpdateGoods = new AdminUpdateGoods();
				adminUpdateGoods.setVisible(true);
				table.add(adminUpdateGoods);
			}
		});
		menu_6.add(menuItem_10);

		JMenu mnNewMenu_2 = new JMenu("管理员信息管理");
		mnNewMenu_2.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/\u7BA1\u7406\u5458.png")));
		menuBar.add(mnNewMenu_2);

		JMenu menu_7 = new JMenu("管理员信息维护");
		mnNewMenu_2.add(menu_7);

		JMenuItem mntmX = new JMenuItem("新增管理员");
		mntmX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAdmin ad = new AddAdmin();
				ad.setVisible(true);
				table.add(ad);
			}
		});
		menu_7.add(mntmX);

		JMenuItem menuItem_11 = new JMenuItem("管理员信息维护");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAdmin updateAdmin = new UpdateAdmin();
				updateAdmin.setVisible(true);
				table.add(updateAdmin);
			}
		});
		menu_7.add(menuItem_11);
		
		JMenu menu_12 = new JMenu("商品采购");
		menu_12.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/购物.png")));
		menuBar.add(menu_12);
		
		JMenuItem menuItem_19 = new JMenuItem("采购");
		menuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminBuy adminBuy = new AdminBuy();
				adminBuy.setVisible(true);
				table.add(adminBuy);
			}
		});
		menu_12.add(menuItem_19);
		
		JMenu menu_9 = new JMenu("菜谱信息");
		menu_9.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/菜谱.png")));
		menuBar.add(menu_9);
		
		JMenuItem menuItem_13 = new JMenuItem("菜谱");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdateMenu adminUpdateMenu = new AdminUpdateMenu();
				adminUpdateMenu.setVisible(true);
				table.add(adminUpdateMenu);
			}
		});
		menu_9.add(menuItem_13);

		JMenu menu_1 = new JMenu("退出系统");
		menu_1.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/exit.png")));
		menuBar.add(menu_1);

		JMenuItem menuItem = new JMenuItem("安全退出");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		menuItem.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/exit.png")));
		menu_1.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JDesktopPane();
		table.setBackground(new Color(244, 156, 190));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(table,
				GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(table,
				GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);

		// 窗口居中
		this.setLocationRelativeTo(null);
		// 窗口最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void exit() {
		// TODO Auto-generated method stub
		dispose();
		// adminMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
