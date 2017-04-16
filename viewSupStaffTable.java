/** author @ Shreyash Arya (2015097)h
	    Tushita Rathore (2015108)
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class viewSupStaffTable{
	
	JFrame viewfr = new JFrame();
	JTable table;
	JButton close;
	int mainCount=-1;
	
	Object[][] data;
	data objct;
	logistics log;
	
	public viewSupStaffTable(int count)
	{
		mainCount = count;
		try {
			objct = new data();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log = new logistics();
		
		if(mainCount==1 || mainCount==2)
		{
			
			data = new Object[100][5];
		String[] columnNames = {"Name", "Username", "City","Dept"
				,"DOB"};
		

		table = new JTable(data,columnNames){
			 private static final long serialVersionUID = 1L;
		        public boolean isCellEditable(int row, int column) {                
		                return false;};};
		                
		                if(mainCount==2)
		     		   {
		     			   viewSupervisor();
		     		   }
		     		   else if(mainCount==1)
		     		   {
		     			   viewStaff();
		     		   }
	
		}
		
		else if(mainCount==3)
		{
			data = new Object[100][5];
			String[] columnNames = {"ID","Username", "Dept.","No. of items"
					,"Items"};
			

			table = new JTable(data,columnNames){
				 private static final long serialVersionUID = 1L;
			        public boolean isCellEditable(int row, int column) {                
			                return false;};};		                
			        viewLog();
		}
		
		else if(mainCount==4 || mainCount==5)
		{
			data = new Object[100][5];
			String[] columnNames = {"Name", "Username","Status"};
			
			//System.out.println("asdasfjaf" + data);
			table = new JTable(data,columnNames){
				 private static final long serialVersionUID = 1L;
			        public boolean isCellEditable(int row, int column) {                
			                return false;};};
			                
			                if(mainCount==4)
			     		   {
			     			   viewavaStaff();
			     		   }
			     		   else if(mainCount==5)
			     		   {
			     			   viewavaSupervisor();
			     		   }
		}
		
		else if(mainCount==6)
		{
			data = new Object[100][5];
			String[] columnNames = {"Name", "Dept","List_Items"};
			
			table = new JTable(data,columnNames){
				 private static final long serialVersionUID = 1L;
			        public boolean isCellEditable(int row, int column) {                
			                return false;};};
			                
			viewnewLog();
		}
		else if(mainCount==18)
		{
			try {
				objct = new data();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			data = new Object[100][5];
			String[] columnNames = {"Name","Dept","Current inventory","Requested Inventory"};
			
			table = new JTable(data,columnNames){
				 private static final long serialVersionUID = 1L;
			        public boolean isCellEditable(int row, int column) {                
			                return false;};};
			// viewallLog(String s);
		}
		else if(mainCount==17)
		{
			try {
				objct = new data();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			data = new Object[100][5];
			String[] columnNames = {"Name","Dept","Title","Tools required","Available-Yes/No"};
			
			table = new JTable(data,columnNames){
				 private static final long serialVersionUID = 1L;
			        public boolean isCellEditable(int row, int column) {                
			                return false;};};
			// viewallLog(String s);
		}	
		
		else
		{
			data = new Object[100][5];
			String[] columnNames = {"ID","Username", "Dept.","No. of items"
					,"Items"};
			
	
			table = new JTable(data,columnNames){
				 private static final long serialVersionUID = 1L;
			        public boolean isCellEditable(int row, int column) {                
			                return false;};};		                
			       
		}
		                
		table.setPreferredScrollableViewportSize(new Dimension(600,100));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		viewfr.add(scrollPane);
		scrollPane.setBounds(50, 50, 500, 200);
		
		close = new JButton("Close");
		close.setBounds(230, 280, 120, 20);
		
		closeEvent ce = new closeEvent();
		close.addActionListener(ce);
		
		viewfr.add(close);
		
		viewfr.setLayout(null);		
		viewfr.setSize(630,350);
		viewfr.setVisible(true);
		viewfr.setTitle("Table");
	}
	
	public class closeEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			viewfr.dispose();
		}
	}
	
	
	public void viewSupervisor(ArrayList<Supvisor> supervisors)
	{
		for(int i=0;i<supervisors.size();i++)
		{
			data[i][0] = supervisors.get(i).getName();
			data[i][1] = supervisors.get(i).getUname();
			data[i][2] = supervisors.get(i).getCity();
			data[i][3] = supervisors.get(i).getDep();
			data[i][4] = supervisors.get(i).getDob();
			
		}
	}
	
	public void viewstaff(ArrayList<Stff> staffs)
	{
		for(int i=0;i<staffs.size();i++)
		{
			data[i][0] = staffs.get(i).getName();
			data[i][1] = staffs.get(i).getUname();
			data[i][2] = staffs.get(i).getCity();
			data[i][3] = staffs.get(i).getDep();
			data[i][4] = staffs.get(i).getDob();
			
		}
	}
	
	public void viewavaSupervisor()
	{
		
		jdbc connection = new jdbc(5);
		ArrayList<Supvisor> supervisors= connection.supprint();
		
		
		/*for(int i=0;i<objct.numSuperv();i++)
		{
			data[i][0] = objct.supervisors.get(i).getId();
			data[i][1] = objct.supervisors.get(i).getName();
			data[i][2] = objct.supervisors.get(i).getUsername();
			data[i][3] = objct.supervisors.get(i).getDepartment();
			
		}*/
		
		for(int i=0;i<supervisors.size();i++)
		{
			data[i][0] = supervisors.get(i).getName();
			data[i][1] = supervisors.get(i).getUname();
			data[i][2] = supervisors.get(i).getAs();
			
		}
		
		
	}
	
	public void viewavaStaff()
	{
		jdbc connection = new jdbc(4);
		ArrayList<Stff> staffs= connection.staffprint();
			
		for(int i=0;i<staffs.size();i++)
		{
			data[i][0] = staffs.get(i).getName();
			data[i][1] = staffs.get(i).getUname();
			data[i][2] = staffs.get(i).getAs();
			
		}
		/*		
		for(int i=0;i<objct.numStaff();i++)
		{
			data[i][0] = objct.staffs.get(i).getId();
			data[i][1] = objct.staffs.get(i).getName();
			data[i][2] = objct.staffs.get(i).getUsername();
			data[i][3] = objct.staffs.get(i).getDepartment();
			
		}*/
	}
	
	
	public void viewSupervisor()
	{
		
		
		jdbc connection = new jdbc(2);
		ArrayList<Supvisor> supervisors= connection.supprint();
		
		
		/*for(int i=0;i<objct.numSuperv();i++)
		{
			data[i][0] = objct.supervisors.get(i).getId();
			data[i][1] = objct.supervisors.get(i).getName();
			data[i][2] = objct.supervisors.get(i).getUsername();
			data[i][3] = objct.supervisors.get(i).getDepartment();
			
		}*/
		
		for(int i=0;i<supervisors.size();i++)
		{
			data[i][0] = supervisors.get(i).getName();
			data[i][1] = supervisors.get(i).getUname();
			data[i][2] = supervisors.get(i).getCity();
			data[i][3] = supervisors.get(i).getDep();
			data[i][4] = supervisors.get(i).getDob();
			
		}
	}
	
	public void viewStaff()
	{
		jdbc connection = new jdbc(1);
		ArrayList<Stff> staffs= connection.staffprint();
			
		for(int i=0;i<staffs.size();i++)
		{
			data[i][0] = staffs.get(i).getName();
			data[i][1] = staffs.get(i).getUname();
			data[i][2] = staffs.get(i).getCity();
			data[i][3] = staffs.get(i).getDep();
			data[i][4] = staffs.get(i).getDob();
			
		}
		/*		
		for(int i=0;i<objct.numStaff();i++)
		{
			data[i][0] = objct.staffs.get(i).getId();
			data[i][1] = objct.staffs.get(i).getName();
			data[i][2] = objct.staffs.get(i).getUsername();
			data[i][3] = objct.staffs.get(i).getDepartment();
			
		}*/
	}
	
	public void viewLog()
	{
		for(int i=0;i<objct.numSuperv();i++)
		{
			System.out.println(i);
			data[i][0] = objct.supervisors.get(i).getId();
			data[i][1] =  objct.supervisors.get(i).getName();
			data[i][2] =  objct.supervisors.get(i).getUsername();
			data[i][3] =  objct.supervisors.get(i).getDepartment();
			data[i][4] = log.num[i];
			
			if(i==0)
			{
				for(int j=0;j<log.num[i];j++)
				{
					data[j+i][5] =objct.supervisors.get(log.num[j]).storeditems.get(j);
				}
			}
			
		}
		
	}
	
	public void viewallLog(ArrayList<alllogi> inventory)
	{
		
		//jdbc connection = new jdbc(18);
		//inventory= connection.totalinventory(String s);
		
		for(int i=0;i<inventory.size();i++)
		{
			data[i][0] = inventory.get(i).getName();
			data[i][1] = inventory.get(i).getDep();
			data[i][2] = inventory.get(i).getAs();
			data[i][3] = inventory.get(i).getreq();
			
		}		
	}
	
	public void viewnewLog()
	{
		jdbc connection = new jdbc(20);
		ArrayList<logi> inventory= connection.inventoryprint();
		
		for(int i=0;i<inventory.size();i++)
		{
			data[i][0] = inventory.get(i).getName();
			data[i][1] = inventory.get(i).getDep();
			data[i][2] = inventory.get(i).getAs();
			
		}
		
	}
	
	public void displaytools(ArrayList<Stff> arrayList) 
	{
		// TODO Auto-generated method stub
		for(int i=0;i<arrayList.size();i++)
		{
			data[i][0] = arrayList.get(i).getName();
			data[i][1] = arrayList.get(i).getUname();
			data[i][2] = arrayList.get(i).getDep();
			data[i][3] = arrayList.get(i).getDob();
			//data[i][4] = arrayList.get(i).getCity();
			
			String ras = arrayList.get(i).getDob();
			String chk = arrayList.get(i).getCity();
			String[] items = ras.split(",");
		       java.util.List<String> itemat = Arrays.asList(items);
		       
		       String[] items2 =chk.split(",");
		       java.util.List<String> itemit = Arrays.asList(items2);
		       int tf=0;
		       
		       for(int i1=0;i1<itemat.size();i1++)
		       {
		    	   for(int j=0;j<itemit.size();j++)
		    	   {
		    		   if(itemit.get(j).equals(itemat.get(i1)))
		    			{
		    			   tf=1;
		    			   break;
		    			}
		    		   else
		    			   tf=0;
		    	   }
		    	   int a[] = new int[100];
		    	   //a[i1] = tf;
		    	   //System.out.println(a[i]);
		    	   a[i1] = tf;
			   }
		       if(tf==1)
		       {
		    	   data[i][4] = "Available";
		       }
		       else
		       {
		    	   data[i][4] = "Not Available";
		       }
		       
		       
		       
		
	}
	}

}
