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

public class createTable{
	
	JFrame viewfr = new JFrame();
	JTable table;
	JButton close;
	int mainCount=-1;
	
	Object[][] data;
	data objct;
	logistics log;
	
	public createTable(int count,ArrayList<String> send)
	{
		mainCount = count;
		try {
			objct = new data();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log = new logistics();
		
		if(mainCount==1)
		{
			
			data = new Object[100][5];
		String[] columnNames = {"Username","Dept","Title","Location","Status"};
		

		table = new JTable(data,columnNames){
			 private static final long serialVersionUID = 1L;
		        public boolean isCellEditable(int row, int column) {                
		                return false;};};
		                
		              viewTask(send);
	
		}
		
		else if(mainCount==2)
		{
			data = new Object[100][6];
			String[] columnNames = {"Username","Dept", "Title","Location","Status","Deadline"};
			

			table = new JTable(data,columnNames){
				 private static final long serialVersionUID = 1L;
			        public boolean isCellEditable(int row, int column) {                
			                return false;};};
			                
			              viewdeptTask(send);
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
	
	public void viewdeptTask(ArrayList<String> send)
	{
		int row=0;
		
		for(int i=0;i<send.size();i+=6)
		{
			data[row][0] = send.get(i);
			data[row][1] = send.get(i+1);
			data[row][2] = send.get(i+2);
			data[row][3] = send.get(i+3);
			data[row][4] = send.get(i+4);
			data[row][5] = send.get(i+5);
			
			row+=1;
		}
	}
	
	public void viewTask(ArrayList<String> send)
	{
		int row =0;
		
		for(int i=0;i<send.size();i+=5)
		{
			data[row][0] = send.get(i);
			data[row][1] = send.get(i+1);
			data[row][2] = send.get(i+2);
			data[row][3] = send.get(i+3);
			data[row][4] = send.get(i+4);
			
			
			
			row+=1;
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
	
	
	public void viewStaff()
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
	
	public void viewSupervisor()
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

}
