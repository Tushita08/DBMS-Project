public class logi{
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public logi(String name,String dep, String as) {
		super();
		this.name = name;
		
		this.dep = dep;
		
		this.as = as;
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
		return "Staff [name=" + name + ", dep=" + dep + ", as=" + as + "]";
	}
     
     String dep ;
     String as;
}