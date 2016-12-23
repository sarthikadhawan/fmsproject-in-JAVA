/**
 * @author Sarthika Dhawan(2015170)
 * @author Shubham Kumar(2015098)
 */
package fmsprojectfinal;

import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.*;

/** @brief assign the task to the supervisor */
 class assigntasksup extends JFrame 
{
	private String newUserid; /**< the user id provided by the user will be stored here*/
	private String newtaskName; /**< the task name provided by the user will be stored here*/
	private String newDescription; /**< the task description provided by the user will be stored here*/
	private String newDeadline; /**< the task deadline provided by the user will be stored here*/
	int g=0;
	private JTextField userid = new JTextField();/**< text field displayed on gui*/
	private JTextField taskName = new JTextField(); /**< text field displayed on gui*/
	private JTextField tDescription = new JTextField(); /**< text field displayed on gui*/
	private JTextField tDeadline = new JTextField(); /**< text field displayed on gui*/
	private JLabel luserid = new JLabel("User ID: ");
	private JLabel ltaskName = new JLabel("Task Name: ");
	private JLabel lDescription = new JLabel("Task Description: ");
	private JLabel lDeadline = new JLabel("Deadline: ");
	private JButton Ok = new JButton("Ok");
	
	private JPanel myPanel;
	String [] lt;
	private int p,q,r,s;GM gm;
	
	handler handle = new handler();
	
	dept d;filetask ft;task tk=new task();Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;
	taskfile []tkf=new taskfile[100];filesupervisor fs;int mk=1;int [] mi=new int[100];int mii=1;
	/** @brief constructor*/
	public assigntasksup()
	{this.mk=1;this.mi=new int[100];this.mii=1;
		for(int i=0;i<100;i++)
		    tkf[i]=new taskfile();
	}
	
	/** @brief reject supervisor leave
	 * 
	 * @param gm
	 * @param d
	 * @param ft
	 * @param fs
	 * @param e
	 * @param h
	 * @param a
	 * @param sec
	 * @param ho
	 * @return
	 */
		public JPanel assigntask(GM gm,dept d,filetask ft,filesupervisor fs,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho)
	{
		p=q=r=s=0;this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;
		this.ft=ft;this.fs=fs;this.gm=gm;
		this.d=d;
		
		myPanel = new JPanel();
		myPanel.setLayout(null);
		
		userid.setBounds(150,50,200,30);
		luserid.setBounds(35,50,150,30);
		taskName.setBounds(150,100,200,30);
		ltaskName.setBounds(35,100,150,30);
		tDescription.setBounds(150,150,200,100);
		lDescription.setBounds(35,150,150,30);
		tDeadline.setBounds(150,300,200,30);
		lDeadline.setBounds(35,300,150,30);
		Ok.setBounds(180,375,100,37);
		
		myPanel.add(userid);
		myPanel.add(luserid);
		myPanel.add(ltaskName);
		myPanel.add(lDescription);
		myPanel.add(lDeadline);
		myPanel.add(taskName);
		myPanel.add(tDescription);
		myPanel.add(tDeadline);
		myPanel.add(Ok);
		
		userid.addActionListener(handle);
		taskName.addActionListener(handle);
		tDescription.addActionListener(handle);
		tDeadline.addActionListener(handle);
		Ok.addActionListener(handle);
		
		return myPanel;
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
		/** @brief actionlistener are made here for the events performed*/
	public class handler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{int [] arr=new int[100];int k=1,i=1;
			if(event.getSource() == userid)
			{
				p = 1;
				newUserid = event.getActionCommand();
				if(Integer.parseInt(newUserid)==e.s.Getuserid())
					d=e;
				else if(Integer.parseInt(newUserid)==h.s.Getuserid())
					d=h;
				else if(Integer.parseInt(newUserid)==ho.s.Getuserid())
					d=ho;
				else if(Integer.parseInt(newUserid)==sec.s.Getuserid())
					d=sec;
				else if(Integer.parseInt(newUserid)==a.s.Getuserid())
					d=a;
				else g=1;
					
					
				
			}
			else if(event.getSource() == taskName)
			{
				q=1;
				newtaskName = event.getActionCommand();
			
				tkf[1].name=newtaskName;
				
			}
			else if(event.getSource() == tDescription)
			{
				r=1;
				newDescription = event.getActionCommand();
				tkf[1].taskdesc=newDescription;
				
			}
			else if(event.getSource() == tDeadline)
			{
							
				String tmp = event.getActionCommand();
				comp_1(tmp);
				if(tmp.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}"))
				{
					s=1;
					newDeadline = event.getActionCommand();
					
					tkf[1].deadline=newDeadline;
				}
						
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Date Format");
				}
				
			}
			else if(event.getSource() == Ok)
			{
				if(g==1)
				{JOptionPane.showMessageDialog(null, "INVALID USERID");
				userid.setText("");
				taskName.setText("");
				tDescription.setText("");
				tDeadline.setText("");
				p=q=r=s=0;
				}
				else if(!d.s.Getstatus().trim().equals("Available"))
				{
					if(d.s.Getstatus().equals("on leave"))
						{JOptionPane.showMessageDialog(null, "User on leave");}
					else
						JOptionPane.showMessageDialog(null, "User "+d.s.Getstatus());
					userid.setText("");
					taskName.setText("");
					tDescription.setText("");
					tDeadline.setText("");
					p=q=r=s=0;

				}		
				else if(p==1 && q==1 && r==1 && s==1&&d.s.Getuserid()!=0)
				{
					JOptionPane.showMessageDialog(null, "SUCCESSFULL SUBMISSION");
					
						tkf[1].dept=d.department;tkf[1].status="Not started";
						tkf[1].comment="null";tkf[1].fromdate="null";tkf[1].todate="null";tkf[1].timetaken="Not started";
					
					tk.Setdept(d.department);
					tk.Setstatus("Not started");
					tk.Setdeadline(tkf[1].deadline);tk.Setdept(d.department);tk.Setdesc(tkf[1].taskdesc);tk.Setname(tkf[1].name);
					tk.Setid(member.useridcount++);
					tkf[1].taskid=tk.Getid();
					tkf[1].userid=d.s.Getuserid();

					gm.assigntask(d, d.s, tk);
					d.s.notifs[d.s.notif++]="Task "+tk.Getid()+" assigned";
					fs.put(1, 0);ft.add(tkf[1]);tk=new task();
					
					userid.setText("");
					taskName.setText("");
					tDescription.setText("");
					tDeadline.setText("");
					p=q=r=s=0;
					tk=new task();
					mk=1;mi=new int[100];mii=1;
					for( i=0;i<100;i++)
					    tkf[i]=new taskfile();
				}
				else if(d.s.Getuserid()==0||d==null)
					{JOptionPane.showMessageDialog(null, "INVALID USERID");
					userid.setText("");
					taskName.setText("");
					tDescription.setText("");
					tDeadline.setText("");
					p=q=r=s=0;
					}
				
				else
				JOptionPane.showMessageDialog(null, "Incomplete Form");
				
			}
		}
	}
}