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

/**@brief assignTask class*/
 class assignTaskstaff extends JFrame 
{
	private String newUserid; /**< this will give the Userid entered by user*/ 
	private String newtaskName; /**< this will give the newTask name */
	private String newDescription; /**< this will give the taskDescription*/
	private String newDeadline; /**< this will give the deadline */
	int g=0;
	private JTextField userid = new JTextField();
	private JTextField taskName = new JTextField();
	private JTextField tDescription = new JTextField();
	private JTextField tDeadline = new JTextField();
	private JLabel luserid = new JLabel("User ID: ");
	private JLabel ltaskName = new JLabel("Task Name: ");
	private JLabel lDescription = new JLabel("Task Description: ");
	private JLabel lDeadline = new JLabel("Deadline: ");
	private JButton Ok = new JButton("Ok");
	
	private JPanel myPanel;
	String [] lt;
	private int p,q,r,s;
	
	handler handle = new handler();
	
	dept d;filetask ft;task tk;
	taskfile []tkf=new taskfile[100];file fl;int mk=1;int [] mi=new int[100];int mii=1;
	/** @brief make the constructor */
	public assignTaskstaff()
	{this.mk=1;this.mi=new int[100];this.mii=1;
		for(int i=0;i<100;i++)
		    tkf[i]=new taskfile();this.tk=new task();
	}
		public JPanel assigntask(dept d,filetask ft,file fl)
	{
		p=q=r=s=0;
		this.ft=ft;this.fl=fl;
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
		/** @brief actionlistener of the buns and the textfields */
	public class handler implements ActionListener
	{
		/** @brief action is performed after an event
		 * @param ActionEvent event
		 * @return void */
		public void actionPerformed(ActionEvent event)
		{int [] arr=new int[100];int k=1,i=1;
			if(event.getSource() == userid)
			{
				p = 1;
				newUserid = event.getActionCommand();
				
				lt =  newUserid.split(",");
				for(String vv:lt)
					{
					try{
					int x=Integer.parseInt(vv);
					

					arr[k++]=(int)x;
					}
					catch(Exception e){}
					}
				
				int g=0;
				
					for(int j=1;j<k;j++)
					{g=0;
					for( i=1;i<=d.nos;i++){
					if(d.arr[i].Getuserid()==arr[j])
					{
						tkf[j].userid=d.arr[i].Getuserid();
						g=1;mi[mii++]=i;
					}
					
					if(i==d.nos&&g==0)
					{
						JOptionPane.showMessageDialog(null, "Some user id is wrong");

						g=2;
						break;
					}
					}
					if(g==2)
						break;
					}
				 mk=k;
					
					
				
			}
			else if(event.getSource() == taskName)
			{
				q=1;
				newtaskName = event.getActionCommand();
			
				tk.Setname(newtaskName);
				for(int j=1;j<mk;j++)
				tkf[j].name=newtaskName;
			}
			else if(event.getSource() == tDescription)
			{
				r=1;
				newDescription = event.getActionCommand();
				tk.Setdesc(newDescription);
				for(int j=1;j<mk;j++)
				tkf[j].taskdesc=newDescription;
			}
			else if(event.getSource() == tDeadline)
			{
				
				String tmp = event.getActionCommand();
				comp_1(tmp);
				if(tmp.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}"))
				{
					s=1;
					newDeadline = event.getActionCommand();
					
					tk.Setdeadline(newDeadline);
					for(int j=1;j<mk;j++)
					tkf[j].deadline=newDeadline;
				}
						
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Date Format");
				}
			}
			else if(event.getSource() == Ok)
			{g=0;
				for(int j=1;j<mk;j++)	
				{	System.out.println(d.arr[mi[j]].Getstatus().trim());
					if(!d.arr[mi[j]].Getstatus().trim().equals("Available"))
					{
						if(d.arr[mi[j]].Getstatus().equals("on leave"))
						{JOptionPane.showMessageDialog(null, "User on leave");}
					else
						JOptionPane.showMessageDialog(null, "User "+d.arr[mi[j]].Getstatus());
					userid.setText("");
					taskName.setText("");
					tDescription.setText("");
					tDeadline.setText("");
					p=q=r=s=0;g=1;
					mk=1;mi=new int[100];mii=1;
					for( i=0;i<100;i++)
					    tkf[i]=new taskfile();
					tk=new task();break;
					}
				}
				if(g==0)
				{
				if(p==1 && q==1 && r==1 && s==1)
				{
					JOptionPane.showMessageDialog(null, "SUCCESSFULL SUBMISSION");
					for(int j=1;j<mk;j++)
					{
						
						tkf[j].dept=d.department;tkf[j].status="Not started";
						tkf[j].comment="null";tkf[j].fromdate="null";tkf[j].todate="null";tkf[j].timetaken="Not started";
					
					tk.Setstatus("Not started");
					tk.Setdeadline(tkf[j].deadline);tk.Setdept(d.department);tk.Setdesc(tkf[j].taskdesc);tk.Setname(tkf[j].name);
					//if(j==1)
					//tk.taskid=member.useridcount++;
					tk.Setid(member.useridcount++);
					tkf[j].taskid=tk.Getid();
					//tk.Setid(tkf[j].taskid);
					d.arr[mi[j]].notifs[d.arr[mi[j]].notif++]="Task "+tk.Getid()+" assigned";

					d.s.assigntask(d, d.arr[mi[j]], tk);
					fl.put(1, 0);ft.add(tkf[j]);
					
					tk=new task();
					}
					userid.setText("");
					taskName.setText("");
					tDescription.setText("");
					tDeadline.setText("");
					p=q=r=s=0;
					mk=1;mi=new int[100];mii=1;
					for( i=0;i<100;i++)
					    tkf[i]=new taskfile();
				}
			else
				JOptionPane.showMessageDialog(null, "Incomplete Form");
				}
			}
		}
	}
}