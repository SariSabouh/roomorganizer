package src;

public class Student {
	private String name, country, sex, year;
	boolean bathroom;
	
	public Student(String str){
		name = str;
		country = "";
		year = "";
		sex = "";
		bathroom = false;
	}
		
	public void setYear(String str){
		year = str;
	}
	
	public void setCountry(String str){
		country = str;
	}
	
	public void setBathroom(boolean str){
		bathroom = str;
	}
	
	public void setSex(String str){
		sex = str;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCountry(){
		return country;
	}
	
	public boolean getBathroom(){
		return bathroom;
	}
	
	public String getYear(){
		return year;
	}
	
	public String getSex(){
		return sex;
	}
}

