package src;

public class Student {
	private String name, country, sex, year, requested, roomie;
	private boolean bathroom;
	
	public Student(){
		name = "";
		country = "";
		year = "";
		sex = "";
		bathroom = false;
		requested = "";
		roomie = "";
	}

	public void setName(String str){
		name = str;
	}
	public void setRequested(String str){
		if(!str.equals("\n\t\t"))
			requested = str;
	}
	public void setYear(String str){
		year = str;
	}
	
	public void setCountry(String str){
		if(!str.equals("\n\t\t"))
			country = str;
	}
	
	public void setBathroom(boolean str){
		bathroom = str;
	}
	
	public void setSex(String str){
		sex = str;
	}
	
	public String getRequested(){
		return requested;
	}
	
	public Boolean hasRequested(){
		if(requested.equals("")) return false;
		else return true;
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
	
	public void setRoomy(String str) {
		if(!str.equals("\n\t\t") && (!name.contains("international") || !name.contains("america")))
			roomie = str;
	}
	
	public String getRoomy(){
		return roomie;
	}
	
	public String toString()
	{	
		String output = "";
		output += "\r\n\t<student>\r\n\t\t<fullName>" + name + "</fullName>";
		output += "\r\n\t\t<year>"+year+"</year>";
		output += "\r\n\t\t<sharedBathroom>"+bathroom+"</sharedBathroom>";
		output += "\r\n\t\t<country>"+country+"</country>";
		output += "\r\n\t\t<requested>"+requested+"</requested>";
		output += "\r\n\t\t<gender>"+sex+"</gender>";
		output += "\r\n\t\t<oldRoom>"+roomie+"</oldRoom>\r\n\t</student>";
		return output;
	}

}

