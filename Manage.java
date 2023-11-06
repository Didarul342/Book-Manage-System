import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Manage implements MouseListener{
	public JFrame frame;
	public JButton borrow;
	public JButton booking;
	public JButton renew;
	public JButton reader_manage;
	public JButton admin_manag;
	public JButton rule_manage;
	public JButton exit_;

	public Manage()
	{	//���ó�ʼ����
		frame=new JFrame();
		exit_=new JButton();
		borrow=new JButton();
		booking=new JButton();
		renew=new JButton();
		reader_manage=new JButton();
		admin_manag=new JButton();
		rule_manage=new JButton();
		frame.setSize(620,380);
		frame.setTitle("Login/Manage");
		frame.setLayout(null);
		
		exit_.setSize(60,30);
		exit_.setLocation(535,305);;
		exit_.setText("�˳�");
		frame.add(exit_);
		exit_.addMouseListener(this);
		
		borrow.setSize(100,50);
		borrow.setLocation(100,50);;
		borrow.setText("����");
		frame.add(borrow);
		borrow.addMouseListener(this);
		
		booking.setSize(100,50);
		booking.setLocation(100,150);;
		booking.setText("ԤԼ");
		frame.add(booking);
		booking.addMouseListener(this);
		
		renew.setSize(100,50);
		renew.setLocation(100,250);;
		renew.setText("����/����");
		frame.add(renew);
		renew.addMouseListener(this);
		
		reader_manage.setSize(100,50);
		reader_manage.setLocation(350,50);;
		reader_manage.setText("���߹���");
		frame.add(reader_manage);
		reader_manage.addMouseListener(this);
		
		admin_manag.setSize(100,50);
		admin_manag.setLocation(350,150);;
		admin_manag.setText("ϵͳ����");
		frame.add(admin_manag);
		admin_manag.addMouseListener(this);
		
		rule_manage.setSize(100,50);
		rule_manage.setLocation(350,250);;
		rule_manage.setText("�������");
		frame.add(rule_manage);
		rule_manage.addMouseListener(this);
		
		
		
		
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton source=(JButton)e.getSource();
		String str=source.getText().toString();
		if(str.equals("����"))
		{	
			Borrow borrow=new Borrow();	
		}
		else if(str.equals("ԤԼ"))
		{	
			Booking booking=new Booking();
		}
		else if(str.equals("����"))
		{	
			Renew renew=new Renew();	
		}
		else if(str.equals("���߹���"))
		{	
			ReaderManage r=new ReaderManage();
		}
		else if(str.equals("ϵͳ����"))
		{	
			SystemManage s=new SystemManage();
		}
		else if(str.equals("�������"))
		{	
			RuleManage ru=new RuleManage();
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
