/**
 * @author Sarthika Dhawan(2015170)
 * @author Shubham Kumar(2015098)
 */
package fmsprojectfinal;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
/**@brief leave requests of staff to be accepted/rejected by respective supervisor GUI interface*/
 class leaveReqstaff extends JFrame  // jus put leave_method() = panel to get leave page
{
	private JPanel panel;
	private JTextField days;
	private JTextField reason;
	private JTextField start;
	private JTextField end;
	private JButton b;
	private JLabel ldays;
	private JLabel lreason;
	private JLabel lstart;
	private JLabel lend;
	private JLabel t;
	private int p,q,r,s;
	leave l=new leave();
	
	private int noOfDays; /**< no of days as entered by user will be stored here*/
	private String from; /**< the date will stored as entered by the user*/
	private String to; /**< the date will stored as entered by the user*/
	private String Reason; /**< the reason as stated by the user will be stored */
	
	handler handle = new handler();
	private JTextField nof;fileHVACstaff fh;file fl;fileAVstaff fa;filesecstaff fsec;filehousekeepingstaff fho;int att=0;
	dept d=new dept();fileelecstaff fe;
	
	/** @brief constructor*/
	public leaveReqstaff(dept d,file fl,int att)
	{
		this.att=att;this.fl=fl;
		this.d=d;
		panel = new JPanel();
		days = new JTextField();
		reason = new JTextField();
		start = new JTextField();
		end = new JTextField();
		b = new JButton("Submit");
		ldays = new JLabel("Number of Days: ");
		lreason = new JLabel("Reason: ");
		lstart = new JLabel("From: ");
		lend = new JLabel("To: ");
		t = new JLabel("Apply for Leave");
	}
	
	/** @brief it wiil return JPanel with all the buns and textfields as req 
	 
	 * @return JPanel
	 */
	public JPanel leave_method()
	{	
		p = 0;
		q= 0; r= 0; s= 0;
		t.setFont (t.getFont ().deriveFont (25.0f));
		ldays.setFont (ldays.getFont ().deriveFont (15.0f));
		days.setFont (days.getFont ().deriveFont (15.0f));
		start.setFont (start.getFont ().deriveFont (15.0f));
		lstart.setFont (lstart.getFont ().deriveFont (15.0f));
		lend.setFont (lend.getFont ().deriveFont (15.0f));
		end.setFont (end.getFont ().deriveFont (15.0f));
		reason.setFont (reason.getFont ().deriveFont (15.0f));
		lreason.setFont (lreason.getFont ().deriveFont (15.0f));
		b.setFont (b.getFont ().deriveFont (16.0f));
		
		t.setBounds(150,30,250,35);
		ldays.setBounds(75, 110, 200, 25);
		days.setBounds(220,110,100,25);
		lstart.setBounds(75, 160, 200, 25);
		start.setBounds(220,160,100,25);
		end.setBounds(475,160,100,25);
		lend.setBounds(400, 160, 100, 25);
		reason.setBounds(220,220,250,100);
		lreason.setBounds(75, 220, 200, 25);
		b.setBounds(175,370,100,25);
		b.setBackground(Color.orange);
		
		panel.setLayout(null);
		panel.add(t);
		panel.add(ldays);
		panel.add(days);
		panel.add(lstart);
		panel.add(start);
		panel.add(end);
		panel.add(lend);
		panel.add(reason);
		panel.add(lreason);
		panel.add(b);
		
		b.addActionListener(handle);
		start.addActionListener(handle);
		end.addActionListener(handle);
		reason.addActionListener(handle);
		days.addActionListener(handle);
		
		return panel;
	}
	
	public void comp_1(String date)
	 {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
			Date date2=new Date();
			String Porsche=sdf.format(date2);
			//System.out.println(Porsche);
			StringBuilder sb = new StringBuilder();
			sb.append(Porsche.charAt(0));
			sb.append(Porsche.charAt(1));
			sb.append(Porsche.charAt(2));
			sb.append(Porsche.charAt(3));
			String str = sb.toString();
			
			StringBuilder sb2 = new StringBuilder();
			//if(Porsche.charAt(4)!='0')
			sb2.append(Porsche.charAt(4));
			sb2.append(Porsche.charAt(5));
					String str2 = sb2.toString();
					
					 sb = new StringBuilder();
			//if(Porsche.charAt(6)!='0')
			sb.append(Porsche.charAt(6));
			
			sb.append(Porsche.charAt(7));
					String str3 = sb.toString();
					
					
					sb = new StringBuilder();
					String ss= date;
					sb.append(ss.charAt(0));sb.append(ss.charAt(1));
					
					String str6 = sb.toString();//todate date
					
					sb = new StringBuilder();
					sb.append(ss.charAt(3));sb.append(ss.charAt(4));
					String str5 = sb.toString();//todate month
					
					sb = new StringBuilder();
					sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
					String str4 = sb.toString();//todate year
			
					
					if(str.compareTo(str4) == 0) //year equal
					{
						if(str2.compareTo(str5) == 0)
						{
							if(str3.compareTo(str6) == 0)
							{
								return;
							}
							else if(str6.compareTo(str3) > 0)
							{
								return;
							}
							else
								JOptionPane.showMessageDialog(null, "INVALID DATE");
						}
						else if(str5.compareTo(str2) > 0)
						{
							return;
						}
						else
							JOptionPane.showMessageDialog(null, "INVALID DATE");
					}
					else if(str4.compareTo(str) > 0)
					{
						return;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "INVALID DATE");
					}
	 }
	
	/** @brief action listener of the events are here*/
	public class handler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == b)
			{	
				if(p==1 && q==1 && r==1 && s==1)
					{
					d.arr[att].l=l;
					fl.put(0, 0);
					fl.create(1);
					
						JOptionPane.showMessageDialog(null, "SUCCESSFULL SUBMISSION");
						reason.setText("");
						start.setText("");
						end.setText("");
						days.setText("");
						p=q=r=s=0;
					}
				else
					JOptionPane.showMessageDialog(null, "Incomplete Form");
			}
			else if(e.getSource() == days)
			{
				p = 1;
				noOfDays = Integer.parseInt(e.getActionCommand());
			}
			else if(e.getSource() == reason)
			{
				q = 1;
				Reason = e.getActionCommand();
				l.Setreason(Reason);
				
			}
			else if(e.getSource() == end)
			{
				String tmp = e.getActionCommand();
				comp_1(tmp);
				if(tmp.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}"))
				{
					r = 1;
					to = e.getActionCommand();
					 
					l.Settodate(to);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Date Format");
				}
				
				
			}
			else if(e.getSource() == start)
			{
				
				
				String tmp = e.getActionCommand();
				comp_1(tmp);
				if(tmp.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}"))
				{
					s = 1;
					from = e.getActionCommand();
					
		    		 
					l.Setfromdate(from);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Date Format");
				}
				
				
			}
		}
		
	}
}
 /**@brief leave requests of supervisor to be accepted/rejected by GM GUI interface*/
 class leaveReqsup
 {
	 private JPanel panel;
		private JTextField days;
		private JTextField reason;
		private JTextField start;
		private JTextField end;
		private JButton b;
		private JLabel ldays;
		private JLabel lreason;
		private JLabel lstart;
		private JLabel lend;
		private JLabel t;
		private int p,q,r,s;
		leave l=new leave();
		
		private int noOfDays; // here the data will be stored
		private String from;
		private String to;
		private String Reason;
		
		handler handle = new handler();
		private JTextField nof;fileHVACstaff fh;file fl;fileAVstaff fa;filesecstaff fsec;filehousekeepingstaff fho;int att=0;
		dept d=new dept();filesupervisor fs;
		
		/** @brief leave request of the supervisor
		 * 
		 * @param d
		 * @param fs
		 */
		public leaveReqsup(dept d,filesupervisor fs)
		{
			this.fs=fs;
			this.d=d;
			panel = new JPanel();
			days = new JTextField();
			reason = new JTextField();
			start = new JTextField();
			end = new JTextField();
			b = new JButton("Submit");
			ldays = new JLabel("Number of Days: ");
			lreason = new JLabel("Reason: ");
			lstart = new JLabel("From: ");
			lend = new JLabel("To: ");
			t = new JLabel("Apply for Leave");
		}
		
		/** @brief JPanel will be returned with all the buns and textfields
		 * 
		 * @return JPanel
		 */
		public JPanel leave_method()
		{	
			p = 0;
			q= 0; r= 0; s= 0;
			t.setFont (t.getFont ().deriveFont (25.0f));
			ldays.setFont (ldays.getFont ().deriveFont (15.0f));
			days.setFont (days.getFont ().deriveFont (15.0f));
			start.setFont (start.getFont ().deriveFont (15.0f));
			lstart.setFont (lstart.getFont ().deriveFont (15.0f));
			lend.setFont (lend.getFont ().deriveFont (15.0f));
			end.setFont (end.getFont ().deriveFont (15.0f));
			reason.setFont (reason.getFont ().deriveFont (15.0f));
			lreason.setFont (lreason.getFont ().deriveFont (15.0f));
			b.setFont (b.getFont ().deriveFont (16.0f));
			
			t.setBounds(150,30,250,35);
			ldays.setBounds(75, 110, 200, 25);
			days.setBounds(220,110,100,25);
			lstart.setBounds(75, 160, 200, 25);
			start.setBounds(220,160,100,25);
			end.setBounds(475,160,100,25);
			lend.setBounds(400, 160, 100, 25);
			reason.setBounds(220,220,250,100);
			lreason.setBounds(75, 220, 200, 25);
			b.setBounds(175,370,100,25);
			b.setBackground(Color.orange);
			
			panel.setLayout(null);
			panel.add(t);
			panel.add(ldays);
			panel.add(days);
			panel.add(lstart);
			panel.add(start);
			panel.add(end);
			panel.add(lend);
			panel.add(reason);
			panel.add(lreason);
			panel.add(b);
			
			b.addActionListener(handle);
			start.addActionListener(handle);
			end.addActionListener(handle);
			reason.addActionListener(handle);
			days.addActionListener(handle);
			
			return panel;
		}
		public void comp_1(String date)
		 {
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
				Date date2=new Date();
				String Porsche=sdf.format(date2);
				//System.out.println(Porsche);
				StringBuilder sb = new StringBuilder();
				sb.append(Porsche.charAt(0));
				sb.append(Porsche.charAt(1));
				sb.append(Porsche.charAt(2));
				sb.append(Porsche.charAt(3));
				String str = sb.toString();
				
				StringBuilder sb2 = new StringBuilder();
				//if(Porsche.charAt(4)!='0')
				sb2.append(Porsche.charAt(4));
				sb2.append(Porsche.charAt(5));
						String str2 = sb2.toString();
						
						 sb = new StringBuilder();
				//if(Porsche.charAt(6)!='0')
				sb.append(Porsche.charAt(6));
				
				sb.append(Porsche.charAt(7));
						String str3 = sb.toString();
						
						
						sb = new StringBuilder();
						String ss= date;
						sb.append(ss.charAt(0));sb.append(ss.charAt(1));
						
						String str6 = sb.toString();//todate date
						
						sb = new StringBuilder();
						sb.append(ss.charAt(3));sb.append(ss.charAt(4));
						String str5 = sb.toString();//todate month
						
						sb = new StringBuilder();
						sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
						String str4 = sb.toString();//todate year
				
						
						if(str.compareTo(str4) == 0) //year equal
						{
							if(str2.compareTo(str5) == 0)
							{
								if(str3.compareTo(str6) == 0)
								{
									return;
								}
								else if(str6.compareTo(str3) > 0)
								{
									return;
								}
								else
									JOptionPane.showMessageDialog(null, "INVALID DATE");
							}
							else if(str5.compareTo(str2) > 0)
							{
								return;
							}
							else
								JOptionPane.showMessageDialog(null, "INVALID DATE");
						}
						else if(str4.compareTo(str) > 0)
						{
							return;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "INVALID DATE");
						}
		 }
		/** @brief all the action listener are here*/
		public class handler implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == b)
				{	
					if(p==1 && q==1 && r==1 && s==1)
						{
						d.s.l=l;
						fs.put(0, 0);
						fs.create(1);
						
							JOptionPane.showMessageDialog(null, "SUCCESSFULL SUBMISSION");
							reason.setText("");
							start.setText("");
							end.setText("");
							days.setText("");
							p=q=r=s=0;
						}
					else
						JOptionPane.showMessageDialog(null, "Incomplete Form");
				}
				else if(e.getSource() == days)
				{
					p = 1;
					noOfDays = Integer.parseInt(e.getActionCommand());
				}
				else if(e.getSource() == reason)
				{
					q = 1;
					Reason = e.getActionCommand();
					l.Setreason(Reason);
					
				}
				else if(e.getSource() == end)
				{
					String tmp = e.getActionCommand();
					comp_1(tmp);
					if(tmp.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}"))
					{
						r = 1;
						to = e.getActionCommand();
						 
			    		 
						l.Settodate(to);
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect Date Format");
					}
				}
				else if(e.getSource() == start)
				{
					
					
					String tmp = e.getActionCommand();
					comp_1(tmp);
					if(tmp.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}"))
					{
						s = 1;
						from = e.getActionCommand();
						
						l.Setfromdate(from);
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect Date Format");
					}
				}
			}
			
		}
 }