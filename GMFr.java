/** author @ Shreyash Arya (2015097)h
	    Tushita Rathore (2015108)
*/
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener ;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent ;
import java.awt.* ;
import javax.swing.* ;
import java.util.*;

public class GMFr {
	
	Object[][] data;
	data objct;
	JFrame viewfr = new JFrame();

	JFrame gmFrame = new JFrame("GM");
	JLabel l1;
	JTextField unameTF = new JTextField(250);
	JLabel unamel = new JLabel("Enter Username (STAFF AVAIL):");
	
	JLabel head = new JLabel("ADMIN");
	JButton homeB = new JButton("Home");
	JButton staffB = new JButton("Staff");
	JButton logisticsB = new JButton("Logistics");
	JButton reportsB = new JButton("Tasks");
	JButton requestsB = new JButton("Requests");
	JButton logoutB = new JButton("Logout");
	
	JPanel homeP = new JPanel();
	JPanel homeP2 = new JPanel();
	
	JButton homeAssignTB = new JButton("Assign Task");
	JComboBox supbox,staffbox;
	JLabel supl = new JLabel("Choose Supervisor Dept to view:");
	JLabel staffl = new JLabel("Choose Staff Dept to view:");
	
	//JButton test = new JButton("CLick me!");
	
	JButton staffsupervisorB = new JButton("SUPERVISOR");
	JButton staffstaffB = new JButton("STAFF");
	JButton staff2viewB = new JButton("VIEW");
	JButton staff2deleteB = new JButton("DELETE");
	
	JButton logViewB = new JButton("VIEW LOGISTICS");
	JButton reportsViewB = new JButton("VIEW Availability of Tools for Task");
	String [] intype = {"--Inventory--","Electricity","Security","HVAC","Audio/Video","Housekeeping"};
	JLabel invl = new JLabel("Current + Required Inventory:");
	JComboBox inbox = new JComboBox(intype);
	
	String [] typey = {"--Task--","Electricity","Security","HVAC","Audio/Video","Housekeeping"};
	JComboBox taskbox= new JComboBox(typey);
	JLabel taskl = new JLabel("Choose Dept to view task:");
	JButton viewTaskB = new JButton("View All Tasks");
	//JButton reportsViewB = new JButton("VIEW REPORTS");
	String [] onc = {"--ONGOING--","Electricity","Security","HVAC","Audio/Video","Housekeeping"};
	JComboBox taskcountbox= new JComboBox(onc);
	JLabel taskcountl = new JLabel("Choose Dept to count ON-task:");
	
	JButton reqLeaveB = new JButton("LEAVES");
	JButton reqLogisticsB = new JButton("LOGISTICS");
	JButton reqMembersB = new JButton("MEMBERS");
	
	JDialog d;
	
	Random rand = new Random(); 
	int supCount = rand.nextInt(100/2) *2;
	int stafCount= (rand.nextInt(100/2)*2) + 1;
	JTable table;
	
	public GMFr()
	{
		gmFrame.setVisible(true);
		gmFrame.setResizable(false);
		gmFrame.setSize(800, 800);
		gmFrame.setLayout(null);
		gmFrame.setContentPane(new JLabel(new ImageIcon("/home/shrebox/Pictures/wallpaper/Wall 331.jpg")));
		//gmFrame.setLocationRelativeTo(null);
		
		gmFrame.add(head);
		head.setBounds(100, 50, 150, 50);
		head.setFont(new Font("Arial", Font.BOLD, 36));
		head.setForeground(Color.WHITE);
		
		gmFrame.add(homeB);
		homeB.setBounds(100, 150, 100, 30);
		
		gmFrame.add(staffB);
		staffB.setBounds(200, 150, 100, 30);
		
		gmFrame.add(logisticsB);
		logisticsB.setBounds(300, 150, 100, 30);
		
		gmFrame.add(reportsB);
		reportsB.setBounds(400, 150, 100, 30);
		
		gmFrame.add(requestsB);
		requestsB.setBounds(500, 150, 110, 30);
		
		gmFrame.add(logoutB);
		logoutB.setBounds(610, 150, 100, 30);
		
		/**-------------------home panel-----------------------
		 * 
		 */
		
		homeP.setLayout(null);
		gmFrame.add(homeP);
		homeP.setBounds(100, 220, 600, 480);
		homeP.setBackground(Color.DARK_GRAY);
		
//		test.setBounds(180, 100, 150,100);
//		homeP.add(test);
		
		homeP.add(supl);
		supl.setBounds(100,100,250,40);
		supl.setForeground(Color.WHITE);
		
		homeP.add(staffl);
		staffl.setBounds(100,200,250,40);
		staffl.setForeground(Color.WHITE);
		
		String [] type1 = {"--Supervisor--","Electricity","Security","HVAC","Audio/Video","Housekeeping"};
		supbox = new JComboBox(type1);
		supbox.setBounds(350, 100, 150,40);
		homeP.add(supbox);
		
		String [] type2 = {"--Staff--","Electricity","Security","HVAC","Audio/Video","Housekeeping"};
		staffbox = new JComboBox(type2);
		staffbox.setBounds(350, 200, 150,40);
		homeP.add(staffbox);
		
		homeAssignTB.setBounds(180, 300, 250,80);
		homeP.add(homeAssignTB);
		
		/*homeP2.setLayout(null);
		gmFrame.add(homeP2);
		homeP2.setBounds(100, 240, 600, 500);
		homeP2.setBackground(Color.CYAN);*/
		
		/**------------home screen buttons actionlistener-----------------
		 * 
		 */
		
//		testEvent est = new testEvent();
//		test.addActionListener(est);
		
		cbsupEvent cbs = new cbsupEvent();
		supbox.addActionListener(cbs);
		
		cbstaffEvent cbst = new cbstaffEvent();
		staffbox.addActionListener(cbst);
		
		InEvent inst = new InEvent();		
		inbox.addActionListener(inst);
		
		homeAssgnTEvent at = new homeAssgnTEvent();
		homeAssignTB.addActionListener(at);
				
		/**------------staff screen buttons actionlistener-----------------
		 * 
		 */
		
		staffsupvdEvent supvd = new staffsupvdEvent();
		staffsupervisorB.addActionListener(supvd);
		
		staffstaffvdEvent staffvd = new staffstaffvdEvent();
		staffstaffB.addActionListener(staffvd);
		
		staffvEvent sve = new staffvEvent();
		staff2viewB.addActionListener(sve);
		
		staffdEvent sde = new staffdEvent();
		staff2deleteB.addActionListener(sde);
		
		/**-------------logistics screen buttons actionlistener--------------*/
		
		
		logViewEvent lve = new logViewEvent();
		logViewB.addActionListener(lve);
		
		/**-------------reports screen buttons actionlistner-----------------
		 * 
		 */
		
		taskboxEvent tbbs = new taskboxEvent();
		taskbox.addActionListener(tbbs);
		
		vtaskEvent vts = new vtaskEvent();
		viewTaskB.addActionListener(vts);
		
		reportsViewEvent ve = new reportsViewEvent();
		reportsViewB.addActionListener(ve);
		
		taskcountEvent tce = new taskcountEvent();
		taskcountbox.addActionListener(tce);
		
		/**--------------requests screen buttons actionlistener--------------
		 * -
		 */
		
		reqLeaveEvent le = new reqLeaveEvent();
		reqLeaveB.addActionListener(le);
		
		reqLogisticsEvent loe = new reqLogisticsEvent();
		reqLogisticsB.addActionListener(loe);
		
		reqMembersEvent me = new reqMembersEvent();
		reqMembersB.addActionListener(me);
		
		/**-----------------tab action listeners-----------------
		 * 
		 */
		
		
		homeEvent he = new homeEvent();
		homeB.addActionListener(he);
		
		staffEvent se = new staffEvent();
		staffB.addActionListener(se);
		
		logisticsEvent loge = new logisticsEvent();
		logisticsB.addActionListener(loge);
		
		reportsEvent re = new reportsEvent();
		reportsB.addActionListener(re);
		
		requestsEvent rre = new requestsEvent();
		requestsB.addActionListener(rre);
		
		LogoutEvent log = new LogoutEvent();
		logoutB.addActionListener(log);
		
		
		
		
	}
	
	public class homeEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			homeP.removeAll();
			homeP.revalidate();
			homeP.repaint();
			
			homeP.add(supl);
			supl.setBounds(100,100,250,40);
			supl.setForeground(Color.WHITE);
			
			homeP.add(staffl);
			staffl.setBounds(100,200,250,40);
			staffl.setForeground(Color.WHITE);
	
			supbox.setBounds(350, 100, 150,40);
			homeP.add(supbox);
			
			staffbox.setBounds(350, 200, 150,40);
			homeP.add(staffbox);
			
			homeAssignTB.setBounds(180, 300, 250,80);
			homeP.add(homeAssignTB);
			
		}
	}
	
	public class staffEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			homeP.removeAll();
			homeP.revalidate();
			homeP.repaint();
			
			staffsupervisorB.setBounds(235, 130, 130, 40);
			homeP.add(staffsupervisorB);
			
			staffstaffB.setBounds(235, 240, 130, 40);
			homeP.add(staffstaffB);
			
			unamel.setBounds(100, 320, 300, 20);
			unamel.setForeground(Color.WHITE);
			homeP.add(unamel);
			
			unameTF.setBounds(330, 320, 120, 20);
			homeP.add(unameTF);
			
			staff2viewB.setBounds(170, 370, 100, 40);
			staff2viewB.setEnabled(false);
			homeP.add(staff2viewB);
			
			staff2deleteB.setBounds(320, 370, 100, 40);
			staff2deleteB.setEnabled(false);
			homeP.add(staff2deleteB);
		}
	}
	
	public class logisticsEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			homeP.removeAll();
			homeP.revalidate();
			homeP.repaint();
			
			reportsViewB.setBounds(160, 130, 300, 100);
			homeP.add(reportsViewB);
			
			logViewB.setBounds(160, 280, 300, 100);
			homeP.add(logViewB);
		}
	}
	
	//for inventoryyy-----------------------------
	public class InEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			//inventory stuff-----------------------------------------------------------
			String s = (String) inbox.getSelectedItem();//get the selected item
			
			jdbc ob = new jdbc(-1);
			
			viewSupStaffTable vst = new viewSupStaffTable(18);
			
			vst.viewallLog(ob.totalinventory(s));
			
		}
	}

	
	public class reportsEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			homeP.removeAll();
			homeP.revalidate();
			homeP.repaint();
			
			homeP.add(taskl);
			taskl.setBounds(100,100,250,40);
			taskl.setForeground(Color.WHITE);
			
			taskbox.setBounds(350, 100, 150,40);
			homeP.add(taskbox);
			
			viewTaskB.setBounds(210, 310, 200, 80);
			homeP.add(viewTaskB);
			
			/*reportsViewB.setBounds(210, 310, 200, 80);
			homeP.add(reportsViewB);*/
			
			taskcountl.setBounds(100,200,250,40);
			taskcountl.setForeground(Color.WHITE);
			homeP.add(taskcountl);
			
			taskcountbox.setBounds(350,200,150,40);
			homeP.add(taskcountbox);
		}
	}
	
	public class requestsEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			homeP.removeAll();
			homeP.revalidate();
			homeP.repaint();
			
			invl.setBounds(100,110,220,40);
			invl.setForeground(Color.WHITE);
			homeP.add(invl);
			
			inbox.setBounds(350,110,130,40);
			homeP.add(inbox);
			
//			reqLeaveB.setBounds(235,110 , 130, 40);
//			homeP.add(reqLeaveB);
			
			reqLogisticsB.setBounds(235, 210, 130, 40);
			homeP.add(reqLogisticsB);
			
			reqMembersB.setBounds(235, 310, 130, 40);
			homeP.add(reqMembersB);
		}
	}
	
	public class LogoutEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			try {
				login l = new login();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			gmFrame.dispose();
		}
	}
	
	//---------------------------------------------------------------------------------------------------------
	
	public class cbsupEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			String s = (String) supbox.getSelectedItem();//get the selected item
			
			jdbc ob = new jdbc(-1);
			
			viewSupStaffTable vst = new viewSupStaffTable(-1);
			
			vst.viewSupervisor(ob.supDeptPrint(s));
			
            /*switch (s) {//check for a match
                case "Electricity":
               
                    System.out.println("elecl");
                    break;
                case "Security":
             
                    System.out.println("sec");
                    break;
                case "HVAC":
                    System.out.println("hvac");
                    break;
                case "Audio/Video":
                	
                	System.out.println("av");
                	break;
                case "Housekeeping":
                	
                	System.out.println("housekeeping");
                	break;
                default:
                    
                    System.out.println("No match selected");
                    break;
             }*/
		}
	}
	
	public class cbstaffEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			String s = (String) staffbox.getSelectedItem();//get the selected item
			
			jdbc ob = new jdbc(-1);
			
			viewSupStaffTable vst = new viewSupStaffTable(-1);
			
			vst.viewstaff(ob.staffDeptPrint(s));
			
           /* switch (s) {//check for a match
                case "Electricity":
               
                    System.out.println("elecl");
                    break;
                case "Security":
             
                    System.out.println("sec");
                    break;
                case "HVAC":
                    
                    System.out.println("hvac");
                    break;
                case "Audio/Video":
                	
                	System.out.println("av");
                	break;
                case "Housekeeping":
                	
                	System.out.println("housekeeping");
                	break;
                	
                default:
                    
                    System.out.println("No match selected");
                    break;
            }*/
		}
	}
	
	public class homeAssgnTEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			taskgenform form = new taskgenform();

		}
	}
	
	public class staffvEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			if(unameTF.getText().isEmpty())
			{
			
				if(stafCount==1)
				{
					//------fill the table with staff data-----------------
					
					viewSupStaffTable table = new viewSupStaffTable(4);
					
					//jdbc staffview = new jdbc(1);
				}
				
				else
				{
					//-------fill the table with supervisor data-----------
					
					viewSupStaffTable table = new viewSupStaffTable(5);
					
					//jdbc supview  = new jdbc(2);
				}
			}
			
			else
			{
				jdbc ob = new jdbc(-1); 
				 
				JOptionPane.showMessageDialog(gmFrame, "Availability: " + ob.checkAvail(unameTF.getText()));
			}
		}
	}
	
	public class staffdEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			if(stafCount==1)
			{
				//------fill the table with staff data-----------------
				
				delSupStaffTable table = new delSupStaffTable(1);
			}
			
			else
			{
				//-------fill the table with supervisor data-----------
				
				delSupStaffTable table = new delSupStaffTable(2);
			}
		}
	}
	
	public class staffstaffvdEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			//stafCount= (rand.nextInt(100/2)*2) + 1;
			stafCount=1;
			supCount=0;
			staffsupervisorB.setEnabled(true);
			staffstaffB.setEnabled(false);
			staff2viewB.setEnabled(true);
			staff2deleteB.setEnabled(true);
			
			System.out.println("stafCount: " + stafCount + "supCount" + supCount);
		}
	}
	
	public class logViewEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			viewSupStaffTable lgv = new viewSupStaffTable(6);
		}
	}
	
	public class staffsupvdEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			//supCount = rand.nextInt(100/2) *2;
			stafCount=0;
			supCount=1;
			staffsupervisorB.setEnabled(false);
			staffstaffB.setEnabled(true);
			staff2viewB.setEnabled(true);
			staff2deleteB.setEnabled(false);
			
			System.out.println("stafCount: " + stafCount + "supCount" + supCount);
			
			
		}

	}
	
	public class taskboxEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			String s = (String) taskbox.getSelectedItem();//get the selected item
			
			jdbc ob = new jdbc(-1);
			
			ob.taskdept(s);
			
//			viewSupStaffTable vst = new viewSupStaffTable(-1);
//			
//			vst.viewstaff(ob.staffDeptPrint(s));
		}
	}
	
	public class vtaskEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			jdbc vts = new jdbc(7);
		}
	}
	
	public class taskcountEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			/*try{
				Desktop.getDesktop().open(new File("/home/shrebox/reports"));
			}
			catch(Exception ex){}*/
			
			String s = (String) taskcountbox.getSelectedItem();//get the selected item
			
			jdbc ob = new jdbc(-1); 
			 
			JOptionPane.showMessageDialog(gmFrame, "No. of ongoing tasks: " + ob.countTask(s));
			
			
		}
	}
	
	public class reportsViewEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			/*try{
				Desktop.getDesktop().open(new File("/home/shrebox/reports"));
			}
			catch(Exception ex){}*/
			
			jdbc ob = new jdbc(-1);
			
			viewSupStaffTable vst = new viewSupStaffTable(17);
			int a[] = new int[100];
			
			vst.displaytools(ob.availtools());
			
			
		}
	}
	
	public class reqLeaveEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			viewSupStaffTable vw = new viewSupStaffTable(18);
		}
	}
	
	public class reqLogisticsEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			reqtable rt = new reqtable(1);
		}
	}

	public class reqMembersEvent implements ActionListener{
	
	public void actionPerformed(ActionEvent e)
	{
		
		reqtable rt = new reqtable(2);
	}
}
	
	
}
