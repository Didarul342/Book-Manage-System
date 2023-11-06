import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ReaderManage implements MouseListener{
	public JFrame frame;
	public JButton select;
	public JButton add;
	public JButton set;
	public JButton delete;
	public JButton exit_;
	public JTextField rno;
	public JLabel txt;
	public Connection conn;
	public Statement st;
	public ReaderManage()
	{	frame=new JFrame();
		frame.setSize(500,350);
		frame.setTitle("Login/Manage/ReaderMange");
		frame.setLayout(null);
		select=new JButton();
		add=new JButton();
		set=new JButton();
		delete=new JButton();
		exit_=new JButton();
		rno=new JTextField();
		txt=new JLabel();
		
		exit_.setSize(60,30);
		exit_.setLocation(5,275);
		exit_.setText("�˳�");
		frame.add(exit_);
		exit_.addMouseListener(this);
		
		txt.setSize(100,30);
		txt.setLocation(80,50);
		txt.setText("���߱�ţ�");
		frame.add(txt);
		rno.setSize(200,30);
		rno.setLocation(180,50);
		frame.add(rno);
		
		select.setSize(200,50);
		select.setLocation(180,80);
		select.setText("��ѯ");
		select.addMouseListener(this);
		frame.add(select);
		
		add.setSize(200,50);
		add.setLocation(180,130);
		add.setText("���");
		frame.add(add);
		add.addMouseListener(this);
		
		set.setSize(200,50);
		set.setLocation(180,180);
		set.setText("�޸�");
		set.addMouseListener(this);
		frame.add(set);
		
		delete.setSize(200,50);
		delete.setLocation(180,230);
		delete.setText("ɾ��");
		delete.addMouseListener(this);
		frame.add(delete);
		
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton source=(JButton)e.getSource();
		int RNO=Integer.parseInt(rno.getText().toString());
		if(source.getText().toString().equals("��ѯ"))
		{	try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			conn= DriverManager.getConnection(url,"system","admin");
			st=conn.createStatement();
			String sel="select * from READER WHERE RNO="+ RNO;
			ResultSet re=st.executeQuery(sel);
			if(re.next())
			{
				StringBuffer str=new StringBuffer();
				for(int i=0;i<8;i++)
				{
					str.append(re.getString(i+1));
					str.append(" ");
				}
				JOptionPane.showMessageDialog(frame,str);
			}
			else
				JOptionPane.showMessageDialog(frame,"���޴���");
			conn.close();
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(source.getText().toString().equals("���"))
		{
			ReaderManageAdd r=new ReaderManageAdd();
		}
		else if(source.getText().toString().equals("�޸�"))
		{
			ReaderManageSet r1=new ReaderManageSet(RNO);
		}
		else if(source.getText().toString().equals("ɾ��"))
		{	try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			conn= DriverManager.getConnection(url,"system","admin");
			st=conn.createStatement();
			String remove="DELETE FROM READER WHERE RNO="+RNO;
			st.execute(remove);
			JOptionPane.showMessageDialog(frame,"ɾ���ɹ�");
			conn.close();
			} 
			catch (Exception e1) {
				e1.printStackTrace();
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
