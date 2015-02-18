package src;

public class Room {
	private String student1, student2, roomNum;
	Boolean bathroom;
	
	public Room(String n, Boolean t){
		roomNum = n;
		bathroom = t;
		student1 = "";
		student2 = "";
	}
	
	public void setStudent(String name){
		if(student1.equals(""))		student1 = name;
		else if(student2.equals("")) student2 = name;
		else System.out.println("no can do");
	}
	
	public String getStudents(){
		String residents = student1 + ", " + student2;
		return residents;
	}
	
	public Boolean hasSpace(){
		if(student1.equals("") || student2.equals("")) return true;
		else return false;
	}
	
	public String getRoomNum(){
		return roomNum;
	}
}
