package cn.edu.zucc.supermark.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;


import javax.swing.*;

import cn.edu.zucc.supermark.util.DBUtil;


public class FrmZhuce extends JDialog implements ActionListener {

    private JPanel toolBar = new JPanel();
    private JPanel workPane = new JPanel();
    private Button btnOk = new Button("ע��");
    private Button btnCancel = new Button("ȡ��");
    private JLabel labelUser = new JLabel("�û���");
    private JLabel labelUname = new JLabel("name��");
    private JLabel labelPwd = new JLabel("���룺");
    private JLabel labelPwd2 = new JLabel("���룺");
    private JLabel labeltel = new JLabel("�绰��");
    private JLabel labelmail = new JLabel("���䣺");
    private JLabel labelcity = new JLabel("���ڳ��У�");
    private JRadioButton jb1= new JRadioButton("��");
    private JRadioButton jb2= new JRadioButton("Ů");
    private JTextField edtUserId = new JTextField(20);
    private JTextField edtUsername= new JTextField(20);
    private JPasswordField edtPwd = new JPasswordField(20);
    private JPasswordField edtPwd2 = new JPasswordField(20);
    private JTextField edttel = new JTextField(20);
    private JTextField edtmail = new JTextField(20);
    private JTextField edtcity =new JTextField(20);
    int edtsex=0;
    public FrmZhuce(Dialog f, String s, boolean b) {
        super(f, s, b);
        toolBar.setLayout(new GridLayout(2,1));
        ButtonGroup group=new ButtonGroup();
        group.add(jb1);
        group.add(jb2);
        toolBar.add(this.jb1);
        toolBar.add(this.jb2);
        if(jb1.isSelected()){
            edtsex=1;
        }
        if(jb2.isSelected()){
            edtsex=2;
        }
        toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        toolBar.add(this.btnOk);//ע��
        toolBar.add(btnCancel);//ȡ��
        this.getContentPane().add(toolBar, BorderLayout.SOUTH);
        workPane.add(labelUser);
        workPane.add(edtUserId);//�û�����������
        workPane.add(labelUname);
        workPane.add(edtUsername);//�û�����������
        workPane.add(labelPwd);
        workPane.add(edtPwd);//�������������
        workPane.add(labelPwd2);
        workPane.add(edtPwd2);//ȷ���������������
        workPane.add(labeltel);
        workPane.add(edttel);
        workPane.add(labelmail);
        workPane.add(edtmail);
        workPane.add(labelcity);
        workPane.add(edtcity);

        this.getContentPane().add(workPane, BorderLayout.CENTER);
        this.setSize(243, 440);
        this.btnCancel.addActionListener(this);
        this.btnOk.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.btnCancel)
            this.setVisible(false);
        else
        if(e.getSource()==this.btnOk)
        {
            //����ע����ش���
            Connection conn=null;
            String uids=this.edtUserId.getText();

            String uname=this.edtUsername.getText();
            String pwd=new String(this.edtPwd.getPassword());
            String pwd2=new String(this.edtPwd.getPassword());
            if(!pwd.equals(pwd2))
            {
                JOptionPane.showMessageDialog(null, "two passwords don't be the same!","����",JOptionPane.ERROR_MESSAGE);
                return;
            }

            try{
                conn=DBUtil.getConnection();
                String sql="select * from users where uid=?";
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.setString(1, uids);
                java.sql.ResultSet rs=pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "already users created!","����",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                rs.close();
                pst.close();
                sql="insert into users(uid,uname,mima) values(?,?,?)";
                pst=conn.prepareStatement(sql);
                pst.setString(1, uids);
                pst.setString(2, uname);
                pst.setString(3, pwd);



                pst.execute();
                pst.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            finally{
                if(conn!=null)
                    try {
                        conn.close();
                    } catch (SQLException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
            }

        }}}