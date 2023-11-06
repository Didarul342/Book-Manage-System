import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements MouseListener
{
	
	public JFrame frame;
	public JButton yesbt;
	public JButton nobt;
	public JLabel userlb;
	public JLabel pswlb;
	public TextField usertxt;
	public JPasswordField pswtxt;
	
	public Connection conn;
	public Statement st;
	
	public Login()
	{	//���ó�ʼ����
		frame=new JFrame();
		frame.setSize(500, 350);
		frame.setTitle("Login");
		frame.setLayout(null);
		
		userlb=new JLabel();
		pswlb=new JLabel();
		userlb.setText("�û�����");
		pswlb.setText("��    �룺");
		userlb.setSize(80,30);
		pswlb.setSize(80,30);
		userlb.setLocation(110, 60);
		pswlb.setLocation(110, 130);
		frame.add(userlb);
		frame.add(pswlb);
		
		usertxt=new TextField();
		pswtxt=new JPasswordField();
		usertxt.setSize(150, 30);
		pswtxt.setSize(150, 30);
		usertxt.setLocation(250, 60);
		pswtxt.setLocation(250, 130);
		frame.add(usertxt);
		frame.add(pswtxt);
		
		yesbt=new JButton();
		nobt=new JButton();
		yesbt.setText("��¼");
		nobt.setText("�˳�");
		yesbt.setSize(80,35);
		nobt.setSize(80,35);
		yesbt.setLocation(100, 235);
		nobt.setLocation(300, 235);
		frame.add(yesbt);
		frame.add(nobt);
		
		nobt.addMouseListener(this);
		yesbt.addMouseListener(this);
		
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{	JButton source=(JButton)e.getSource();
		if(source.getText().toString().equals("��¼"))
		{	
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			//ע�Ტ��������
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			//���������ַ���
			conn= DriverManager.getConnection(url,"system","admin");
			//�������ݿ����Ӷ���
			st=conn.createStatement();
			//���ݿ�ִ�ж���
			String username=usertxt.getText().toString();
			String psw=pswtxt.getText().toString();
			String login="SELECT KEY FROM ADMIN WHERE ACCOUNT='skd'";
			ResultSet rs=st.executeQuery(login);
			
			if(rs.next() && rs.getString(1).equals(psw))
			{
				frame.setVisible(false);
				//���빦��ѡ��ҳ��
				Manage manage=new Manage();
			}
			else
				System.out.println("�û������������");
			conn.close();
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(frame,ex);
			}
			catch (Exception ex){
				JOptionPane.showMessageDialog(frame,ex);
			} 
		}
		else
		{	
			System.exit(0);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}