/** author @ Shreyash Arya (2015097)h
Tushita Rathore (2015108)
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class delSupStaffTable 
{	
	JFrame del = new JFrame();
	JTable table;
	JButton delete,cancel;
	JTextField idTF,usernameTF;
	JLabel id,username;
	Object[][] data = new Object[100][5];
	data objct;
	int mainCount=0;
	int s1=0,s2=0;
	
	public delSupStaffTable(int count)
	{
		try {		objct = new data();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		s1=objct.numSuperv();
		s2 = objct.numStaff();
		mainCount = count;	
		
		String[] columnNames = {"Name", "Username", "City","Department","DOB"};
		table = new JTable(data,columnNames){
			 private static final long serialVersionUID = 1L;
		        public boolean isCellEditable(int row, int column) {                
		                return false;};};
		table.setPreferredScrollableViewportSize(new Dimension(500,100));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		del.add(scrollPane);
		scrollPane.setBounds(50, 50, 500, 200);
		
		if(mainCount==2)
		{
			viewSupervisor();
		}
		
		else if(mainCount==1)
		{
			viewStaff();
		}	
		
//		id =new JLabel("ID:");
//		id.setBounds(80, 280, 70, 20);
		
		username =new JLabel("Username:");
		username.setBounds(80, 290, 90, 20);
		
		delete = new JButton("Delete");
		delete.setBounds(320, 290, 100, 20);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(440, 290, 100, 20);
		
//		idTF = new JTextField(250);
//		idTF.setBounds(180, 280, 120, 20);
		
		usernameTF = new JTextField(250);
		usernameTF.setBounds(180, 290, 120, 20);
		
		del.add(delete);
		del.add(cancel);
		//del.add(idTF);
		del.add(usernameTF);
		//del.add(id);
		del.add(username);
		del.setLayout(null);		
		del.setSize(620,380);
		del.setVisible(true);
		del.setTitle("Delete Members");
		del.setResizable(false);
		del.setBackground(Color.DARK_GRAY);
		
		closeEvent ce =  new closeEvent();
		cancel.addActionListener(ce);
		
		deleteEvent del = new deleteEvent();
		delete.addActionListener(del);
		
	}
	
	public class closeEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			del.dispose();
		}
	}
	
	public class deleteEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(mainCount==2)
			{
				deleteSuperv();
			}
			else if(mainCount==1)
			{	
				deleteStaff();	
			}
			
			del.dispose();
		}
	}
	
	int chk1=0,chk2=0;
	
	public void deleteSuperv()
	{
		/*int check=0;	
		String un = usernameTF.getText();
		String id = idTF.getText();
		
		if((un.equals("") || id.equals("")))
		{
			JOptionPane.showMessageDialog(del, "Empty Fields");
		}
		else
		{
			for(int i=0;i<objct.numSuperv();i++)
			{		
				if(un.equals(objct.supervisors.get(i).getUsername()) && id.equals(objct.supervisors.get(i).getId()))
				{	
					check=1;
					chk1=1;
					objct.supervisors.remove(i);
					s1--;
					try {
						updatefile2(s1,s2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}break;}}
			if(check==0){	
				JOptionPane.showMessageDialog(del, "ID and Username doesn't match!");
				}
		}*/
		
		String un = usernameTF.getText();
		
		if(un.equals(""))
		{
			JOptionPane.showMessageDialog(del, "Empty Fields");
		}
		
		else
		{
			System.out.println("delete supervisor");
			jdbc obj = new jdbc(-1);
			
			obj.delSup(un);
			
		}
	}
	
	public void deleteStaff()
	{	
		/*int check = 0;	
		String un = usernameTF.getText();
		String id = idTF.getText();
		
		if((un.equals("") || id.equals("")))
		{
			JOptionPane.showMessageDialog(del, "Empty Fields");
		}
		else
		{	
			for(int i=0;i<objct.numStaff();i++)
			{	
				if(un.equals(objct.staffs.get(i).getUsername()) && id.equals(objct.staffs.get(i).getId()))
				{	check =1;
					chk2=2;
					objct.staffs.remove(i);
					s2--;
					try {
						updatefile2(s1,s2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();}
					break;}}
			if(check==0)
			{
				JOptionPane.showMessageDialog(del, "ID and Username doesn't match!");	
			}
		}*/
		String un = usernameTF.getText();
		
		if(un.equals(""))
		{
			JOptionPane.showMessageDialog(del, "Empty Fields");
		}
		
		else
		{
			jdbc obj = new jdbc(-1);
			
			obj.delstaff(un);
			
		}
	}
	
	public void viewSupervisor()
	{
		jdbc connection = new jdbc(2);
		ArrayList<Supvisor> supervisors= connection.supprint();
			
		for(int i=0;i<supervisors.size();i++)
		{
			data[i][0] = supervisors.get(i).getName();
			data[i][1] = supervisors.get(i).getUname();
			data[i][2] = supervisors.get(i).getCity();
			data[i][3] = supervisors.get(i).getDep();
			data[i][4] = supervisors.get(i).getDob();
			
		}
		
		/*for(int i=0;i<objct.numSuperv();i++)
	
		{	data[i][0] = objct.supervisors.get(i).getId();
			data[i][1] = objct.supervisors.get(i).getName();
			data[i][2] = objct.supervisors.get(i).getUsername();
			data[i][3] = objct.supervisors.get(i).getDepartment();
		}*/
	}
	public void viewStaff()
	{
//		viewSupStaffTable print = new viewSupStaffTable(2);
		
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
		
		/*for(int i=0;i<objct.numStaff();i++)
		{
			data[i][0] = objct.staffs.get(i).getId();
			data[i][1] = objct.staffs.get(i).getName();
			data[i][2] = objct.staffs.get(i).getUsername();
			data[i][3] = objct.staffs.get(i).getDepartment();
		}*/
	}
	
	public void updatefile2(int s1,int s2) throws IOException
	{
		FileWriter file = new FileWriter("db1basics.csv",false);
	   	BufferedWriter bw = new BufferedWriter(file);
	    PrintWriter pw = new PrintWriter(bw);
	    
	    pw.print( objct.admin.get(0).getName() +",");
		pw.print( objct.admin.get(0).getPost() +",");
		pw.print( objct.admin.get(0).getUsername() +",");
		pw.print( objct.admin.get(0).getPassword() +",");
		pw.print(objct.admin.get(0).getId()+",");
		pw.print( "-,");
		pw.print( objct.admin.get(0).getDob() +",");
		pw.print( objct.admin.get(0).getAdr() + "\n");
		//pw.println("\n");
		
			for(int i=0;i< s1;i++)
			{
				pw.print( objct.supervisors.get(i).getName() +",");
				pw.print( objct.supervisors.get(i).getPost() +",");
				pw.print( objct.supervisors.get(i).getUsername() +",");
				pw.print( objct.supervisors.get(i).getPassword() +",");
				pw.print( objct.supervisors.get(i).getId() +",");
				pw.print( objct.supervisors.get(i).getDepartment() +",");
				pw.print( objct.supervisors.get(i).getDob() +",");
				pw.print( objct.supervisors.get(i).getAdr());
				if(i!= s1)
				{
					pw.print("\n");
				}	
			}
			
			for(int i=0;i< s2;i++)
			{
				pw.print( objct.staffs.get(i).getName() +",");
				pw.print( objct.staffs.get(i).getPost() +",");
				pw.print( objct.staffs.get(i).getUsername() +",");
				pw.print( objct.staffs.get(i).getPassword() +",");
				pw.print( objct.staffs.get(i).getId()+",");
				pw.print( objct.staffs.get(i).getDepartment() +",");
				pw.print( objct.staffs.get(i).getDob() +",");
				pw.print( objct.staffs.get(i).getAdr());
				if(i!= s2)
				{
					pw.print("\n");
				}	
			}	
			//s1++;
			s2++;
			pw.close();}}