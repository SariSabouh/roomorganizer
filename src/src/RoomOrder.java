package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomOrder {

	public ArrayList<Student> students = new ArrayList<Student>();
	public ArrayList<Room> rooms = new ArrayList<Room>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void openDatabase(String file) throws IOException {
		/*try {
			FileReader reader = new FileReader(file);
			Scanner scan = new Scanner(reader);
			String name = "";
			String line = "";
			while(scan.hasNext())
			{
				line = scan.nextLine();
				name = line;
				Student s = new Student(name);
				s.setYear(scan.nextLine());
				s.setBathroom(Boolean.parseBoolean(scan.nextLine()));
				s.setCountry(scan.nextLine());
				s.setSex(scan.nextLine());
				students.add(s);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
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

	public void placeStudents() {
		for(int i = 0; i<students.size();i++){
			if (students.get(i).getSex().equals("M")){
				for(int j = 0; j<rooms.size();j++){
					if(rooms.get(j).hasSpace()){
						rooms.get(j).setStudent(students.get(i).getName());
					}
				}
			}
		}
	}

	public void createEmptyRooms() {
		rooms.add(new Room("207M", false));
	}

}
