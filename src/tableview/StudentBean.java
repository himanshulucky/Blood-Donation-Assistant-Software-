package tableview;

public class StudentBean {
	
//	first define variable
	public String name;
	public String gender;
	public String address;
	public String city;
	public String bgroup;
	public String disease;
	public int age;
	public String dor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	public StudentBean(String name, String gender, String address, String city, String bgroup, String disease, int age,
			String dor) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.bgroup = bgroup;
		this.disease = disease;
		this.age = age;
		this.dor = dor;
	}
	public StudentBean() {}

}
