import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Borrow implements MouseListener{
	public JFrame frame;
	public JButton yesbt;
	public JButton nobt;
	public JLabel rno;
	public JLabel bno;
	public TextField trno;
	public TextField tbno;
	
	public Connection conn;
	public Statement st;
	
	public Borrow()
	{	//���ó�ʼ����
		frame=new JFrame();
		frame.setSize(500, 350);
		frame.setTitle("Login/Manage/Borrow");
		frame.setLayout(null);
		
		rno=new JLabel();
		bno=new JLabel();
		rno.setText("���߱�ţ�");
		bno.setText("ͼ���ţ�");
		rno.setSize(80,30);
		bno.setSize(80,30);
		rno.setLocation(110, 60);
		bno.setLocation(110, 130);
		frame.add(rno);
		frame.add(bno);
		
		trno=new TextField();
		tbno=new TextField();
		trno.setSize(150, 30);
		tbno.setSize(150, 30);
		trno.setLocation(250, 60);
		tbno.setLocation(250, 130);
		frame.add(trno);
		frame.add(tbno);
		
		yesbt=new JButton();
		nobt=new JButton();
		yesbt.setText("����");
		nobt.setText("ȡ��");
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
	public void mouseClicked(MouseEvent e) {
		JButton source=(JButton)e.getSource();
		String str=source.getText().toString();
		if(str.equals("����"))
		{	String RNO=trno.getText().toString();
			String BNO=tbno.getText().toString();
			String can_borrow="select POWER from READER where RNO="+RNO;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				String url="jdbc:oracle:thin:@localhost:1521:orcl";
				conn= DriverManager.getConnection(url,"system","admin");
				st=conn.createStatement();
				ResultSet re1 = st.executeQuery(can_borrow);
				if(re1.next() && Integer.parseInt(re1.getString(1))==1)
				{
					//�����ж�
					String is_in="select CTYPENO from BOOK WHERE BNO="+BNO;
					ResultSet re2 = st.executeQuery(is_in);
					if(re2.next() && Integer.parseInt(re2.getString(1))==1)//ctypeno=1��������ͼ���
					{	String NUMBER="Select NUMBERS from RULE where RTYPENO="
							+ "(Select RTYPENO from READER where RNO="
							+ RNO+") and CTYPENO=(Select CTYPENO from BOOK where BNO="
							+ BNO+")";
						ResultSet re3 = st.executeQuery(NUMBER);
						if(re3.next() && Integer.parseInt(re3.getString(1))>0)
						{	//���Գ���
							String term="select TERM from RULE";
							ResultSet re4 = st.executeQuery(term);
							int days=Integer.parseInt(re4.getString(1));
							String borrow="update table BOOK set CTYPENO=2 where BNO="
									+ BNO;//2������ͼ���
							String to_borrow="insert into BORROW VALUES("
									+ BNO+","+ RNO+",sysdate,sysdate+"+days+")";
							String to_borrow2="UPDATE BOOK SET CTYPENO=2";
							st.execute(borrow);
							st.execute(to_borrow);
							st.execute(to_borrow2);
							JOptionPane.showMessageDialog(frame,"���ĳɹ�");
						}
						else
						{
							JOptionPane.showMessageDialog(frame,"�Ѵ��������");
						}		
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"�����Ѿ�����");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"�޽���Ȩ��");
				}
			conn.close();
			} catch (Exception e1) {
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
