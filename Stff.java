
public class Stff{
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
	public Stff(String name, String uname, String dep, String dob, String city, String as) {
		super();
		this.name = name;
		this.uname = uname;
		this.dep = dep;
		this.dob = dob;
		this.city = city;
		this.as = as;
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
	public String getAs() {
		return as;
	}
	public void setAs(String as) {
		this.as = as;
	}
	
	String name ;
     @Override
	public String toString() {
		return "Staff [name=" + name + ", uname=" + uname + ", dep=" + dep + ", dob=" + dob + ", city=" + city
				+ ", as=" + as + "]";
	}
     String uname;
     String dep ;
     String dob ;
     String city;
     String as;
}
