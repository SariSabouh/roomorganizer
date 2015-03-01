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
	
	public int hasSpace(){
		if(student1.equals("") && student2.equals("")) return 2;
		else if ((student1.equals("") && !student2.equals("")) || (!student1.equals("") && student2.equals(""))) return 1;
		else return 0;
	}
	
	public String getRoomNum(){
		return roomNum;
	}
	
	public Boolean getBathroom(){
		return bathroom;
	}
	public String toString(){
		String output = "";
		output += "\r\n\t<room>\r\n\t\t<roomNumber>" + roomNum + "</roomNumber>";
		output += "\r\n\t\t<shared>"+bathroom+"</shared>\r\n\t</room>";
		return output;
	}
}
