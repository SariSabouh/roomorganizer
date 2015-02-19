package src;

import java.io.IOException;
import java.util.ArrayList;

public class RoomOrder {

	public ArrayList<Student> students = new ArrayList<Student>();
	public ArrayList<Room> rooms = new ArrayList<Room>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void openDatabase(String file) throws IOException {
		XMLParser xml = new XMLParser("Student Names.xml");
		students = xml.students;
		rooms = xml.rooms;
	}
	
	public String getNames()
	{
		String names = "";
		for (int i = 0; i < students.size(); i++){
			names += students.get(i).getName() + " ";
		}
		return names;
	}

	public String getYear(String name) {
		int loc = 0;
		for (int i = 0; i<students.size(); i++){
			if(name.equals(students.get(i).getName())){
				loc = i;
			}
		}
		return students.get(loc).getYear();
	}

	public Boolean getBathroom(String name) {
		int loc = 9999;
		for (int i = 0; i<students.size(); i++){
			if(name.equals(students.get(i).getName())){
				loc = i;
			}
		}
		return students.get(loc).getBathroom();
	}

	public String getCountry(String name) {
		int loc = 0;
		for (int i = 0; i<students.size(); i++){
			if(name.equals(students.get(i).getName())){
				loc = i;
			}
		}
		return students.get(loc).getCountry();
	}
	
	public String getSex(String name) {
		int loc = 0;
		for (int i = 0; i<students.size(); i++){
			if(name.equals(students.get(i).getName())){
				loc = i;
			}
		}
		return students.get(loc).getSex();
	}

	public String getRoommates(String n) {
		int loc = 0;
		for(int i = 0; i<rooms.size(); i++){
			if(n.equals(rooms.get(i).getStudents().contains(n))) loc = i;
		}
		return rooms.get(loc).getStudents();
	}
	
	public Boolean checkRequested(int i){
		if(students.get(i).hasRequested()) return true;
		else return false;
	}
	
	public void placeRA(){
		for(int i = 0; i<students.size();i++){
			if(students.get(i).getName().contains("*") && checkRequested(i)){
				if(students.get(i).getSex().equals("M")){
					if(rooms.get(14).hasSpace()){
						rooms.get(14).setStudent(students.get(i).getName()); rooms.get(14).setStudent(students.get(students.indexOf(students.get(i))).getRequested());
					}
					else rooms.get(19).setStudent(students.get(i).getName()); rooms.get(19).setStudent(students.get(students.indexOf(students.get(i))).getRequested());
				}
				else{
					if(rooms.get(4).hasSpace()){
						rooms.get(4).setStudent(students.get(i).getName()); rooms.get(4).setStudent(students.get(students.indexOf(students.get(i))).getRequested());
					}
					else rooms.get(9).setStudent(students.get(i).getName()); rooms.get(9).setStudent(students.get(students.indexOf(students.get(i))).getRequested());
				}
			}
			else if(students.get(i).getName().contains("*")){
				if(students.get(i).getSex().equals("M")){
					if(rooms.get(14).hasSpace()) rooms.get(14).setStudent(students.get(i).getName());
					else rooms.get(19).setStudent(students.get(i).getName());
				}
				else{
					if(rooms.get(4).hasSpace()) rooms.get(4).setStudent(students.get(i).getName());
					else rooms.get(9).setStudent(students.get(i).getName());
				}
			}
		}
	}

	public void placeStudents() {
		placeRA();
		for(int i = 0; i<students.size();i++){
			if(checkRequested(i)){
				String gender = students.get(i).getSex();
				for(int j = 0; j<rooms.size();j++){
					if(rooms.get(j).hasSpace() || rooms.get(j).getRoomNum().equals(gender)){
						rooms.get(j).setStudent(students.get(i).getName());
						rooms.get(j).setStudent(students.get(students.indexOf(students.get(i))).getRequested());
					}
				}
			}
			else{
				for(int j = 0; j<rooms.size();j++){
					if(rooms.get(j).hasSpace()){
					//	rooms.get(j).setStudent(students.get(i).getName());
					}
				}
			}
			if (students.get(i).getSex().equals("M")){
				
			}
			else if(students.get(i).getSex().equals("F")){
				
			}
		}
	}

	public void createEmptyRooms() {
		rooms.add(new Room("207M", false));
	}

	public void requestStudent(String student, String request) {
		int loc = 0;
		int loc2 = 0;
		for(int i = 0; i < students.size(); i++){
			if(students.get(i).getName().equals(student)) loc = i;
			else if(students.get(i).getName().equals(request)) loc2 = i;
		}
		if(students.get(loc).getSex().equals(students.get(loc2).getSex()))
			students.get(loc).setRequested(request);
	}

}
