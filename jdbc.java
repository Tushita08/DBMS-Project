//STEP 1. Import required packages
import java.sql.Connection;
import java.util.Arrays;
import java.awt.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class jdbc{
 // JDBC driver name and database URL
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 static final String DB_URL = "jdbc:mysql://localhost/fms";

 //  Database credentials
 static final String USER = "root";
 static final String PASS = "prakhar123";
 
 public jdbc(int funcval)
 {
	 if(funcval==2)
	 {
		 supprint();
	 }
	 
	 else if(funcval==1)
	 {
		 staffprint();
	 }
	 
	 else if(funcval==4)
	 {
		 avastaff();
	 }
	 
	 else if(funcval==5)
	 {
		 avasup();
	 }
	 
	 else if(funcval==6)
	 {
		 newregprint();
	 }
	 
	 else if(funcval==7)
	 {
		 viewTask();
	 }
	 
	 else if(funcval==20)
	 {
		 inventoryprint();
	 }
	 else if(funcval==19)
	 {
		 totalreqinventory();
	 }
	 else if(funcval==17)
	 {
		 int a[] = new int[100];
		 availtools();
	 }
	 else if(funcval==15)
	 {
		 
	 }
	 else if(funcval==14)
	 {
		 
	 }
	 else if(funcval==13)
	 {
		 //Approve("l");
	 }
	 else if(funcval==12)
	 {
		 //Disprove("l");
	 }
		 //register();
	 
 }
 
 public String checkAvail(String uname)
 {
	 String result = "";
	 int count = 0;
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "Select Name,Username,Avail_Status from StaffInfo where Username='"+uname+"'";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    System.out.println("here in task count print");
	    
	    
	    while(rs.next()){
	       //Retrieve by column name
	       count++;
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	    //createTable obj = new createTable(2,send);
	    
	    //System.out.println("test 2");
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try
	 
	 if(count>0)
	 {
		 result = "YES";
	 }
	 
	 else
	 {
		 result = "NO";
	 }
	 return result;
 }
 
 public void delSup(String uname)
 {
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    
	    String sql2 = "delete from SupervisorInfo where Username=?";
	    PreparedStatement preparedStmt2 = (PreparedStatement) conn.prepareStatement(sql2);
	    preparedStmt2.setString(1, uname);
	    preparedStmt2.executeUpdate();
	
	    
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try
 }
 
 public int countTask(String dept)
 {
	 int result = -1;
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "select count(*) from StaffInfo natural join testdoes2 natural join Task where Status = 'ongoing' and Dept='"+dept+"'";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    System.out.println("here in task count print");
	    
	    //int count = 1;
	    
	    while(rs.next()){
	       //Retrieve by column name
	    		
	       result = rs.getInt("count(*)");
	       
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	    //createTable obj = new createTable(2,send);
	    
	    //System.out.println("test 2");
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try
	 
	 return result;
 }
 
 public void delstaff(String uname)
 {
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "delete from Task where TID in (select TID from StaffInfo natural join testdoes2 where Username = ? and Status='Completed')"; 
	    PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
	    preparedStmt.setString(1, uname);
	    preparedStmt.executeUpdate();
	    
	    String sql2 = "delete from StaffInfo where StaffInfo.Username=? and ( not exists ( select Username from testdoes2 where Username=?) or exists( select Username,Status from testdoes2,Task where Task.TID=testdoes2.TID and Username = ? and Status='Completed') )";
	    PreparedStatement preparedStmt2 = (PreparedStatement) conn.prepareStatement(sql2);
	    preparedStmt2.setString(1, uname);
	    preparedStmt2.setString(2, uname);
	    preparedStmt2.setString(3, uname);
	    preparedStmt2.executeUpdate();
	
	    
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try
 }
 
 public void taskdept(String deptt)
 {
	 ArrayList<String> send = new ArrayList();
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "Select StaffInfo.Username,StaffInfo.Dept,Title,Location,Status,Deadline" + 
	    		"    From Task natural join testdoes2 natural join StaffInfo" + 
	    		"    Where StaffInfo.Username=testdoes2.Username and StaffInfo.Dept=testdoes2.Dept and StaffInfo.Dept='"+ deptt + "'";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    System.out.println("here in dept task print");
	    
	    int count = 1;
	    
	    while(rs.next()){
	       //Retrieve by column name
	    		
	       String uname = rs.getString("Username");
	       String dept = rs.getString("Dept");
	       String title = rs.getString("Title");
	       String location = rs.getString("Location");
	       String status = rs.getString("Status");
	       String deadline = rs.getString("Deadline");
	       
	       System.out.println(uname + " "+dept + " "+title+ " "+location + " "+status + " "+deadline);
	       
	       send.add(uname);
	       send.add(dept);
	       send.add(title);
	       send.add(location);
	       send.add(status);
	       send.add(deadline);
	       
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	    createTable obj = new createTable(2,send);
	    
	    System.out.println("test 2");
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try
 }
 
 public void viewTask()
 {
	 ArrayList<String> send = new ArrayList();
	 //Object [][] data;
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = " Select testdoes2.Username,Dept,Title,Location,Status From Task,testdoes2 Where Task.TID=testdoes2.TID";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    System.out.println("here in new reg show print");
	    
	    int count = 1;
	    
	    while(rs.next()){
	       //Retrieve by column name
	    		
	       String uname = rs.getString("Username");
	       String dep = rs.getString("Dept");
	       String title = rs.getString("Title");
	       String location = rs.getString("Location");
	       String status = rs.getString("Status");
	       
	       send.add(uname);
	       send.add(dep);
	       send.add(title);
	       send.add(location);
	       send.add(status);
	       
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	    createTable obj = new createTable(1,send);
	    
	    System.out.println("test 2");
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try
 }
 
 public ArrayList<NewReg> newregprint()
 {
	 ArrayList<NewReg> registers = new ArrayList();
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT Name,Username,Post,Dept FROM NewReg";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    System.out.println("here in new reg show print");
	    
	    while(rs.next()){
	       //Retrieve by column name
	    	
	       String name  = rs.getString("Name");	
	       String uname = rs.getString("Username");
	       String post = rs.getString("Post");
	       String dep = rs.getString("Dept");
	       NewReg register = new NewReg(name, uname, post, dep, null, null);
	       registers.add(register);
	       System.out.println("test 1");
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	    
	    System.out.println("test 2");
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try 
	 
	return registers;
	 
 }
 
 public ArrayList<Stff> staffDeptPrint(String dept)
 {
	 ArrayList<Stff> staffs = new ArrayList();
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT * FROM StaffInfo WHERE Dept='"+dept+"'" ;
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    System.out.println("here in supervisor filter print");
	    
	    while(rs.next()){
	       //Retrieve by column name
	    	
	       String name  = rs.getString("Name");
	       String uname = rs.getString("Username");
	       String dep = rs.getString("Dept");
	       String dob = rs.getString("DOB");
	       String city = rs.getString("City");
	       String as = rs.getString("Avail_Status");
	       Stff staff = new Stff(name, uname, dep, dob, city, as);
	       staffs.add(staff);
	       System.out.println("test 1");
	       //Display values
	       System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	    
	    System.out.println("test 2");
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try 
	return staffs;
 }
 
 public ArrayList<Supvisor> supDeptPrint(String dept)
 {
	 ArrayList<Supvisor> supervisors = new ArrayList();
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT * FROM SupervisorInfo WHERE Dept='"+dept+"'" ;
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    System.out.println("here in supervisor filter print");
	    
	    while(rs.next()){
	       //Retrieve by column name
	    	
	       String name  = rs.getString("Name");
	       String uname = rs.getString("Username");
	       String dep = rs.getString("Dept");
	       String dob = rs.getString("DOB");
	       String city = rs.getString("City");
	       String as = rs.getString("Avail_Status");
	       Supvisor supvisor = new Supvisor(name, uname, dep, dob, city, as);
	       supervisors.add(supvisor);
	       System.out.println("test 1");
	       //Display values
	       System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	    
	    System.out.println("test 2");
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try 
	return supervisors;
 }
 
 
 public ArrayList<Supvisor> avasup()
 {
	 ArrayList<Supvisor> supervisors = new ArrayList();
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT Name,Username,Avail_Status FROM SupervisorInfo order by Avail_Status";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    //System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
	    
	    while(rs.next()){
	       //Retrieve by column name
	    	
	       String name  = rs.getString("Name");
	       String uname = rs.getString("Username");
	       String as = rs.getString("Avail_Status");
	       Supvisor supvisor = new Supvisor(name, uname, null, null, null, as);
	       supervisors.add(supvisor);
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try 
	return supervisors;
 }
 
 public ArrayList<Stff> avastaff()
 {
	 ArrayList<Stff> staffs = new ArrayList();
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT Name,Username,Avail_Status FROM StaffInfo order by Avail_Status";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
	    
	    //viewSupStaffTable table = new viewSupStaffTable(1);
	    
	    while(rs.next()){
	       //Retrieve by column name
	       String name  = rs.getString("Name");
	       String uname = rs.getString("Username");	
	       String as = rs.getString("Avail_Status");
	       Stff staff = new Stff(name, uname, null, null, null, as);
	       staffs.add(staff);
	       
	       System.out.println(as);
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try 
	return staffs;
 }
 
 public ArrayList<Supvisor> supprint()
 {
	 ArrayList<Supvisor> supervisors = new ArrayList();
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT * FROM SupervisorInfo";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	    System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
	    
	    while(rs.next()){
	       //Retrieve by column name
	    	
	       String name  = rs.getString("Name");
	       String uname = rs.getString("Username");
	       String dep = rs.getString("Dept");
	       String dob = rs.getString("DOB");
	       String city = rs.getString("City");
	       String as = rs.getString("Avail_Status");
	       Supvisor supvisor = new Supvisor(name, uname, dep, dob, city, as);
	       supervisors.add(supvisor);
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try 
	return supervisors;
 }
 
 public ArrayList<Stff> staffprint()
 {
	 ArrayList<Stff> staffs = new ArrayList();
	 Connection conn = null;
	 Statement stmt = null;
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	    
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT * FROM StaffInfo";
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from rresult set
	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
	    
	    //viewSupStaffTable table = new viewSupStaffTable(1);
	    
	    while(rs.next()){
	       //Retrieve by column name
	       String name  = rs.getString("Name");
	       String uname = rs.getString("Username");
	       String dep = rs.getString("Dept");
	       String dob = rs.getString("DOB");
	       String city = rs.getString("City");
	       String as = rs.getString("Avail_Status");
	       Stff staff = new Stff(name, uname, dep, dob, city, as);
	       staffs.add(staff);
	       //Display values
	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
	    }
	    rs.close();
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try 
	return staffs;
 }
 
 public ArrayList<logi> inventoryprint()
 {
 	 ArrayList<logi> invent = new ArrayList();
 	 Connection conn = null;
 	 Statement stmt = null;
 	 try{
 	    //STEP 2: Register JDBC driver
 	    Class.forName("com.mysql.jdbc.Driver");

 	    //STEP 3: Open a connection
 	    System.out.println("Connecting to a selected database...");
 	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	    System.out.println("Connected database successfully...");
 	    
 	    //STEP 4: Execute a query
 	    System.out.println("Creating statement...");
 	    stmt = conn.createStatement();

 	    String sql = "SELECT SupervisorInfo.Name,SupervisorInfo.Dept, List_items FROM SupervisorInfo,Inventory WHERE SupervisorInfo.Dept = Inventory.Dept";
 	    ResultSet rs = stmt.executeQuery(sql);
 	    //STEP 5: Extract data from rresult set
 	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
 	    
 	    while(rs.next()){
 	       //Retrieve by column name
 	    	
 	       String name  = rs.getString("Name");
 	       String dep  = rs.getString("Dept");
 	       String as = rs.getString("List_items");
 	       logi logistics = new logi(name,dep,as);
 	       invent.add(logistics);
 	       
 	       //Supvisor supvisor = new Supvisor(name,dep, as);
 	       //supervisors.add(supvisor);
 	       //Display values
 	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
 	    }
 	    rs.close();
 	 }catch(SQLException se){
 	    //Handle errors for JDBC
 	    se.printStackTrace();
 	 }catch(Exception e){
 	    //Handle errors for Class.forName
 	    e.printStackTrace();
 	 }finally{
 	    //finally block used to close resources
 	    try{
 	       if(stmt!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	    }// do nothing
 	    try{
 	       if(conn!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	       se.printStackTrace();
 	    }//end finally try
 	 }//end try 
 	return invent; 
 }

 public ArrayList<logi> totalreqinventory()
 {
 	 ArrayList<logi> invent = new ArrayList();
 	 Connection conn = null;
 	 Statement stmt = null;
 	 try{
 	    //STEP 2: Register JDBC driver
 	    Class.forName("com.mysql.jdbc.Driver");

 	    //STEP 3: Open a connection
 	    System.out.println("Connecting to a selected database...");
 	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	    System.out.println("Connected database successfully...");
 	    
 	    //STEP 4: Execute a query
 	    System.out.println("Creating statement...");
 	    stmt = conn.createStatement();

 	    String sql = "SELECT SupervisorInfo.Name,SupervisorInfo.Dept,Req_Items FROM SupervisorInfo natural join InventoryReq";
 	    ResultSet rs = stmt.executeQuery(sql);
 	    //STEP 5: Extract data from rresult set
 	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
 	    
 	    while(rs.next()){
 	       //Retrieve by column name
 	    	
 	       String name  = rs.getString("Name");
 	       String dep  = rs.getString("Dept");
 	       String as = rs.getString("Req_items");
 	       
 	       logi logistics = new logi(name,dep,as);
 	       invent.add(logistics);
 	       
 	       //Supvisor supvisor = new Supvisor(name,dep, as);
 	       //supervisors.add(supvisor);
 	       //Display values
 	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
 	    }
 	    rs.close();
 	 }catch(SQLException se){
 	    //Handle errors for JDBC
 	    se.printStackTrace();
 	 }catch(Exception e){
 	    //Handle errors for Class.forName
 	    e.printStackTrace();
 	 }finally{
 	    //finally block used to close resources
 	    try{
 	       if(stmt!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	    }// do nothing
 	    try{
 	       if(conn!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	       se.printStackTrace();
 	    }//end finally try
 	 }//end try 
 	return invent; 
 }

 public ArrayList<alllogi> totalinventory(String s)
 {
 	 ArrayList<alllogi> invent = new ArrayList();
 	 Connection conn = null;
 	 Statement stmt = null;
 	 try{
 	    //STEP 2: Register JDBC driver
 	    Class.forName("com.mysql.jdbc.Driver");

 	    //STEP 3: Open a connection
 	    System.out.println("Connecting to a selected database...");
 	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	    System.out.println("Connected database successfully...");
 	    
 	    //STEP 4: Execute a query
 	    System.out.println("Creating statement...");
 	    stmt = conn.createStatement();

 	    String sql = "Select SupervisorInfo.Name,SupervisorInfo.Dept,List_items,Req_Items From SupervisorInfo natural join Inventory natural join InventoryReq where SupervisorInfo.Dept='"+s+"'";
 	    ResultSet rs = stmt.executeQuery(sql);
 	    //STEP 5: Extract data from rresult set
 	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
 	    
 	    while(rs.next()){
 	       //Retrieve by column name
 	    	
 	       String name  = rs.getString("Name");
 	       String dep  = rs.getString("Dept");
 	       String as = rs.getString("List_Items");
 	       String ras = rs.getString("Req_items");
 	       
 	       alllogi logistics = new alllogi(name,dep,as,ras);
 	       invent.add(logistics);
 	       
 	       //Supvisor supvisor = new Supvisor(name,dep, as);
 	       //supervisors.add(supvisor);
 	       //Display values
 	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
 	    }
 	    rs.close();
 	 }catch(SQLException se){
 	    //Handle errors for JDBC
 	    se.printStackTrace();
 	 }catch(Exception e){
 	    //Handle errors for Class.forName
 	    e.printStackTrace();
 	 }finally{
 	    //finally block used to close resources
 	    try{
 	       if(stmt!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	    }// do nothing
 	    try{
 	       if(conn!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	       se.printStackTrace();
 	    }//end finally try
 	 }//end try
 	return invent; 
 }

 public ArrayList<Stff> availtools()
 {
 	 ArrayList<Stff> invent = new ArrayList();
 	 Connection conn = null;
 	 Statement stmt = null;
 	 try{
 	    //STEP 2: Register JDBC driver
 	    Class.forName("com.mysql.jdbc.Driver");

 	    //STEP 3: Open a connection
 	    System.out.println("Connecting to a selected database...");
 	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	    System.out.println("Connected database successfully...");
 	    
 	    //STEP 4: Execute a query
 	    System.out.println("Creating statement...");
 	    stmt = conn.createStatement();

 	    String sql = "Select StaffInfo.Username,StaffInfo.Dept,Task.Title,Task.Tools,Inventory.List_items From Task natural join StaffInfo natural join testdoes2 natural join Inventory";
 	    ResultSet rs = stmt.executeQuery(sql);
 	    //STEP 5: Extract data from rresult set
 	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
 	    
 	    while(rs.next()){
 	       //Retrieve by column name
 	    	
 	       String name  = rs.getString("Username");
 	       String dep  = rs.getString("Dept");
 	       String as = rs.getString("Title");
 	       String ras = rs.getString("Tools");
 	       String chk = rs.getString("List_items");
 	       
 	       Stff logistics = new Stff(name,dep,as,ras,chk,null);
 	       invent.add(logistics);
 	       
 	       
 	    	   
 	       }
 	       
 	      // System.out.println(tf);
 	       
 	    rs.close();
 	 }catch(SQLException se){
 	    //Handle errors for JDBC
 	    se.printStackTrace();
 	 }catch(Exception e){
 	    //Handle errors for Class.forName
 	    e.printStackTrace();
 	 }finally{
 	    //finally block used to close resources
 	    try{
 	       if(stmt!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	    }// do nothing
 	    try{
 	       if(conn!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	       se.printStackTrace();
 	    }//end finally try
 	 }//end try 
 	return invent; 
 }

 public ArrayList<Stff> register(ArrayList<String> array)
 {
 	 ArrayList<Stff> staffs = new ArrayList();
 	 Connection conn = null;
 	 Statement stmt = null;
 	 try{
 	    //STEP 2: Register JDBC driver
 	    Class.forName("com.mysql.jdbc.Driver");

 	    //STEP 3: Open a connection
 	    System.out.println("Connecting to a selected database...");
 	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	    System.out.println("Connected database successfully...");
 	    
 	    //STEP 4: Execute a query
 	    System.out.println("Creating statement...");
 	    
 	    
 	    stmt = conn.createStatement();
 	    String name = array.get(0);
 	    String Uname = array.get(1);
 	    String post = array.get(2);
 	    String dep = array.get(3);
 	    String dob = array.get(4);
 	    String city = array.get(5);
 	    //String sql = "Insert into NewReg(Name,Username,Post,Dept,DOB,City) values (name,Uname,post,dep,dob,city)";
 	    //int rs = stmt.executeUpdate(sql);
 	    //STEP 5: Extract data from rresult set
 	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
 	    
 	    String query = " Insert into NewReg(Name,Username,Post,Dept,DOB,City) values "
 	            + "(?, ?, ?, ?, ?,?)";

 	          // create the mysql insert preparedstatement
 	          java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
 	          preparedStmt.setString(1, name);
 	          preparedStmt.setString(2, Uname);
 	          preparedStmt.setString(3, post);
 	          preparedStmt.setString(4, dep);
 	          preparedStmt.setString(5,dob);
 	          preparedStmt.setString(6,city);
 	       
 	      // System.out.println(tf);
 	          preparedStmt.execute();
 	          
 	          conn.close();
 	    
 	 }catch(SQLException se){
 	    //Handle errors for JDBC
 	    se.printStackTrace();
 	 }catch(Exception e){
 	    //Handle errors for Class.forName
 	    e.printStackTrace();
 	 }finally{
 	    //finally block used to close resources
 	    try{
 	       if(stmt!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	    }// do nothing
 	    try{
 	       if(conn!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	       se.printStackTrace();
 	    }//end finally try
 	 }//end try 
 	return staffs; 
 }


 public ArrayList<Stff> Disprove(String Uname)
 {
 	 ArrayList<Stff> staffs = new ArrayList();
 	 Connection conn = null;
 	 Statement stmt = null;
 	 try{
 	    //STEP 2: Register JDBC driver
 	    Class.forName("com.mysql.jdbc.Driver");

 	    //STEP 3: Open a connection
 	    System.out.println("Connecting to a selected database...");
 	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	    System.out.println("Connected database successfully...");
 	    
 	    //STEP 4: Execute a query
 	    System.out.println("Creating statement...");
 	    stmt = conn.createStatement();
 	    
 	    
 	    String query = "delete from NewReg where Username = ?";
 	      java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
 	      preparedStmt.setString(1, Uname);

 	      // execute the preparedstatement
 	      preparedStmt.executeUpdate();
 	      
 	      conn.close();

 	    
 	 }catch(SQLException se){
 	    //Handle errors for JDBC
 	    se.printStackTrace();
 	 }catch(Exception e){
 	    //Handle errors for Class.forName
 	    e.printStackTrace();
 	 }finally{
 	    //finally block used to close resources
 	    try{
 	       if(stmt!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	    }// do nothing
 	    try{
 	       if(conn!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	       se.printStackTrace();
 	    }//end finally try
 	 }//end try 
 	return staffs; 
 }
 public ArrayList<Stff> Approve(String Uname)
 {
 	 ArrayList<Stff> staffs = new ArrayList();
 	 Connection conn = null;
 	 Statement stmt = null;
 	 try{
 	    //STEP 2: Register JDBC driver
 	    Class.forName("com.mysql.jdbc.Driver");

 	    //STEP 3: Open a connection
 	    System.out.println("Connecting to a selected database...");
 	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	    System.out.println("Connected database successfully...");
 	    String name="",Dep="",DOB="",City="";
 	    //STEP 4: Execute a query
 	    System.out.println("Creating statement...");
 	    stmt = conn.createStatement();
 	    
 	    String sql1 = "select* from NewReg where  Username='"+Uname+"'";
 	   // java.sql.PreparedStatement preparedStmt1 = conn.prepareStatement(sql1);
 	     // preparedStmt1.setString(1, Uname);
 	    ResultSet rs = stmt.executeQuery(sql1);
 	    //STEP 5: Extract data from rresult set
 	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
 	    String name1="",uname="",p="",dep="",dob="",city="";
 	    while(rs.next()){
 	       //Retrieve by column name
 	    	
 	       name1  = rs.getString("Name");
 	       uname  = rs.getString("Username");
 	        p = rs.getString("Post");
 	       dep  = rs.getString("Dept");
 	       dob = rs.getString("Dob");
 	       city = rs.getString("City");
 	      
 	       
 	       Stff logistics = new Stff(name1,uname,dep,dob,City,null);
 	       staffs.add(logistics);
 	       
 	       
 	    	   
 	       }
 	       
 	      // System.out.println(tf);
 	       
 	    rs.close();
 	    
 	    
 	    String sql = "Insert into StaffInfo(Name,Username,Dept,DOB,City) values "+ "(?,?,?,?,?)";
 	    java.sql.PreparedStatement preparedStmt = conn.prepareStatement(sql);
 	      preparedStmt.setString(1, name1);
 	      preparedStmt.setString(2, uname);
 	      preparedStmt.setString(3, dep);
 	      preparedStmt.setString(4, dob);
 	      preparedStmt.setString(5, city);
 	      preparedStmt.executeUpdate();
 	    String query = "delete from NewReg where Username = ?";
 	      java.sql.PreparedStatement preparedStmt2 = conn.prepareStatement(query);
 	      preparedStmt2.setString(1, Uname);
 	      

 	      // execute the preparedstatement
 	      preparedStmt2.executeUpdate();
 	      
 	      conn.close();

 	    
 	 }catch(SQLException se){
 	    //Handle errors for JDBC
 	    se.printStackTrace();
 	 }catch(Exception e){
 	    //Handle errors for Class.forName
 	    e.printStackTrace();
 	 }finally{
 	    //finally block used to close resources
 	    try{
 	       if(stmt!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	    }// do nothing
 	    try{
 	       if(conn!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	       se.printStackTrace();
 	    }//end finally try
 	 }//end try 
 	return staffs; 
 }

 public ArrayList<Stff> ViewMem()
 {
 	 ArrayList<Stff> staffs = new ArrayList();
 	 Connection conn = null;
 	 Statement stmt = null;
 	 try{
 	    //STEP 2: Register JDBC driver
 	    Class.forName("com.mysql.jdbc.Driver");

 	    //STEP 3: Open a connection
 	    System.out.println("Connecting to a selected database...");
 	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	    System.out.println("Connected database successfully...");
 	    
 	    //STEP 4: Execute a query
 	    System.out.println("Creating statement...");
 	    stmt = conn.createStatement();
 	    
 	    String query = "select* from NewReg";
 	    
 	    ResultSet rs = stmt.executeQuery(query);
 	    //STEP 5: Extract data from rresult set
 	   // System.out.println("Name    Username   Dept   DOB   City  Avail_Status");
 	    
 	    //viewSupStaffTable table = new viewSupStaffTable(1);
 	    String uname="";
 	    while(rs.next()){
 	       //Retrieve by column name
 	       String name  = rs.getString("Name");
 	       uname = rs.getString("Username");
 	       String as = rs.getString("Post");
 	       String dep = rs.getString("Dept");
 	       String dob = rs.getString("DOB");
 	       String city = rs.getString("City");
 	      
 	       Stff staff = new Stff(name, uname, dep, dob, city,as);
 	       staffs.add(staff);
 	       //Display values
 	       //System.out.println(name+ " "+ uname + " "+ dep + " " + dob + " "+ city +" "+ as );
 	    }
 	    rs.close();
 	    
 	   
 	   // String Uname = array.get(1);000

 	    
 	 }catch(SQLException se){
 	    //Handle errors for JDBC
 	    se.printStackTrace();
 	 }catch(Exception e){
 	    //Handle errors for Class.forName
 	    e.printStackTrace();
 	 }finally{
 	    //finally block used to close resources
 	    try{
 	       if(stmt!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	    }// do nothing
 	    try{
 	       if(conn!=null)
 	          conn.close();
 	    }catch(SQLException se){
 	       se.printStackTrace();
 	    }//end finally try
 	 }//end try 
 	return staffs; 
 }

 
}
 
// public static void main(String[] args) {
// Connection conn = null;
// Statement stmt = null;
// try{
//    //STEP 2: Register JDBC driver
//    Class.forName("com.mysql.jdbc.Driver");
//
//    //STEP 3: Open a connection
//    System.out.println("Connecting to a selected database...");
//    conn = DriverManager.getConnection(DB_URL, USER, PASS);
//    System.out.println("Connected database successfully...");
//    
//    //STEP 4: Execute a query
//    System.out.println("Creating statement...");
//    stmt = conn.createStatement();
//
//    String sql = "SELECT * FROM cars";
//    ResultSet rs = stmt.executeQuery(sql);
//    //STEP 5: Extract data from rresult set
//    while(rs.next()){
//       //Retrieve by column name
//       int cid  = rs.getInt("cid");
//       String cname = rs.getString("cname");
//       String color = rs.getString("color");
//
//       //Display values
//       System.out.println("ID: " + cid);
//       System.out.print(", cname: " + cname);
//       System.out.println(", color: " + color);
//    }
//    rs.close();
// }catch(SQLException se){
//    //Handle errors for JDBC
//    se.printStackTrace();
// }catch(Exception e){
//    //Handle errors for Class.forName
//    e.printStackTrace();
// }finally{
//    //finally block used to close resources
//    try{
//       if(stmt!=null)
//          conn.close();
//    }catch(SQLException se){
//    }// do nothing
//    try{
//       if(conn!=null)
//          conn.close();
//    }catch(SQLException se){
//       se.printStackTrace();
//    }//end finally try
// }//end try
// System.out.println("Goodbye!");
//}//end main
//}//end JDBCExample