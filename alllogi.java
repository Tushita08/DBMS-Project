public class alllogi{
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getreq() {
		return ras;
	}
	public void setreq(String ras) {
		this.ras = ras;
	}
	
	
	public alllogi(String name,String dep, String as,String ras) {
		super();
		this.name = name;
		
		this.dep = dep;
		
		this.as = as;
		
		this.ras = ras;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
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
		return "Staff [name=" + name + ", dep=" + dep + ", as=" + as + "ras=" + ras+"]";
	}
     
     String dep ;
     String as;
     String ras;
}