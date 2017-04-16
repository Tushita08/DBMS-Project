
public class NewReg {
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public NewReg(String name, String uname,  String post,String dep, String dob, String city) {
		super();
		this.name = name;
		this.uname = uname;
		this.dep = dep;
		this.dob = dob;
		this.city = city;
		this.post = post;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	String name ;
     @Override
	public String toString() {
		return "Supvisor [name=" + name + ", uname=" + uname + ", dep=" + dep + ", dob=" + dob + ", city=" + city
				+ ", post=" + post + "]";
	}
     String uname;
     String dep ;
     String dob ;
     String city;
     String post;
}
