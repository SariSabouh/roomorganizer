package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class RoomOrder {

	public ArrayList<Student> students = new ArrayList<Student>();
	public ArrayList<Room> rooms = new ArrayList<Room>();
	public ArrayList<String> names = new ArrayList<String>();
	
	public void openDatabase(String file) throws IOException {
		XMLParser xml = new XMLParser("Students Names.xml");
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
			if(n.equals(rooms.get(i).getRoomNum())) loc = i;
		}
		return rooms.get(loc).getStudents();
	}
	
	public Boolean checkRequested(int i){
		if(students.get(i).hasRequested()) return true;
		else return false;
	}
	
	public void placeRA(){
		for(int i = 0; i<students.size();i++){
			if(!names.contains(students.get(i).getName())){
				if(students.get(i).getName().contains("*") && checkRequested(i)){
					if(students.get(i).getSex().equals("M")){
						if(rooms.get(13).hasSpace() == 2){
							rooms.get(13).setStudent(students.get(i).getName());
							rooms.get(13).setStudent(students.get(i).getRequested());
						}
						else if (rooms.get(18).hasSpace() == 2){
							rooms.get(18).setStudent(students.get(i).getName());
							rooms.get(18).setStudent(students.get(i).getRequested());
						}
					}
					else{
						if(rooms.get(3).hasSpace() == 2){
							rooms.get(3).setStudent(students.get(i).getName()); rooms.get(3).setStudent(students.get(i).getRequested());
						}
						else if (rooms.get(8).hasSpace() == 2)
							rooms.get(8).setStudent(students.get(i).getName()); rooms.get(8).setStudent(students.get(i).getRequested());
					}
					names.add(students.get(i).getName()); names.add(students.get(i).getRequested());
				}
				else if(students.get(i).getName().contains("*")){
					if(students.get(i).getSex().equals("M")){
						if(rooms.get(13).hasSpace() == 2) rooms.get(13).setStudent(students.get(i).getName());
						else if (rooms.get(18).hasSpace() == 2) rooms.get(18).setStudent(students.get(i).getName());
					}
					else{
						if(rooms.get(3).hasSpace() == 2) rooms.get(3).setStudent(students.get(i).getName());
						else if (rooms.get(8).hasSpace() == 2) rooms.get(8).setStudent(students.get(i).getName());
					}
					names.add(students.get(i).getName());
				}
			}
		}
	}
	
	public void placeBathrooms(){
		int room1 = 0;
		int room2 = 0;
		int room3 = 0;
		int room4 = 0;
		int room5 = 0;
		int room6 = 0;
		int room7 = 0;
		int room8 = 0;
		for(int i = 0; i<rooms.size(); i++){
			if(rooms.get(i).getRoomNum().equals("104F")) room1=i;
			else if(rooms.get(i).getRoomNum().equals("102F")) room2=i;
			else if(rooms.get(i).getRoomNum().equals("204F")) room3=i;
			else if(rooms.get(i).getRoomNum().equals("202F")) room4=i;
			else if(rooms.get(i).getRoomNum().equals("103M")) room5=i;
			else if(rooms.get(i).getRoomNum().equals("105M")) room6=i;
			else if(rooms.get(i).getRoomNum().equals("203M")) room7=i;
			else if(rooms.get(i).getRoomNum().equals("205M")) room8=i;
			
		}
		for(int i = 0; i<students.size(); i++){
			if(!students.get(i).getBathroom()){
				if(!names.contains(students.get(i).getName())){
					if(checkRequested(i)){
						if(students.get(i).getSex().equals("F")){
							if(rooms.get(room1).hasSpace() == 2){
								rooms.get(room1).setStudent(students.get(i).getName());
								rooms.get(room1).setStudent(students.get(i).getRequested());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room2).hasSpace() == 2){
								rooms.get(room2).setStudent(students.get(i).getName());
								rooms.get(room2).setStudent(students.get(i).getRequested());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room3).hasSpace() == 2){
								rooms.get(room3).setStudent(students.get(i).getName());
								rooms.get(room3).setStudent(students.get(i).getRequested());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room4).hasSpace() == 2){
								rooms.get(room4).setStudent(students.get(i).getName());
								rooms.get(room4).setStudent(students.get(i).getRequested());
								names.add(students.get(i).getName());
							}
						}
						else{
							if(rooms.get(room5).hasSpace() == 2){
								rooms.get(room5).setStudent(students.get(i).getName());
								rooms.get(room5).setStudent(students.get(i).getRequested());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room6).hasSpace() == 2){
								rooms.get(room6).setStudent(students.get(i).getName());
								rooms.get(room6).setStudent(students.get(i).getRequested());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room7).hasSpace() == 2){
								rooms.get(room7).setStudent(students.get(i).getName());
								rooms.get(room7).setStudent(students.get(i).getRequested());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room8).hasSpace() == 2){
								rooms.get(room8).setStudent(students.get(i).getName());
								rooms.get(room8).setStudent(students.get(i).getRequested());
								names.add(students.get(i).getName());
							}
						}
					}
					else{
						if(students.get(i).getSex().equals("F")){
							if(rooms.get(room1).hasSpace() != 0){
								rooms.get(room1).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room2).hasSpace() != 0){
								rooms.get(room2).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room3).hasSpace() != 0){
								rooms.get(room3).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room4).hasSpace() != 0){
								rooms.get(room4).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
						}
						else{
							if(rooms.get(room5).hasSpace() != 0){
								rooms.get(room5).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room6).hasSpace() != 0){
								rooms.get(room6).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room7).hasSpace() != 0){
								rooms.get(room7).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(room8).hasSpace() != 0){
								rooms.get(room8).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
						}
					}
				}
			}
		}
	}
	
	public void placeUS(){
		for(int j = 0; j<rooms.size(); j++){
			for(int i = 0; i<students.size(); i++){
				if(students.get(i).getCountry().equals("US")){
					if(!names.contains(students.get(i).getName())){
						if((students.get(i).getBathroom() && !rooms.get(j).getBathroom()) || (!students.get(i).getBathroom() && rooms.get(j).getBathroom())){
							if(rooms.get(j).hasSpace() == 2 && rooms.get(j).getRoomNum().contains(students.get(i).getSex())){
								rooms.get(j).setStudent(students.get(i).getName());
								if(students.get(i).hasRequested()){
									rooms.get(j).setStudent(students.get(i).getRequested());
									names.add(students.get(i).getRequested());
								}
								names.add(students.get(i).getName());
							}
						}
					}
				}
			}
		}
	}

	public void placeStudents() throws FileNotFoundException{
		Collections.shuffle(students);
		placeRA();
		placeUS();
		placeBathrooms();
		for(int j = 0; j < rooms.size(); j++){
			for(int i = 0; i<students.size(); i++){
				if(!names.contains(students.get(i).getName())){
					if(checkRequested(i)){
						if(rooms.get(j).hasSpace() == 2 && rooms.get(j).getRoomNum().contains(students.get(i).getSex())){
							rooms.get(j).setStudent(students.get(i).getName());
							rooms.get(j).setStudent(students.get(i).getRequested());
							names.add(students.get(i).getName());
							names.add(students.get(i).getRequested());
						}
					}
					else{
						if(rooms.get(j).getRoomNum().contains(students.get(i).getSex())){
							if(rooms.get(j).hasSpace() == 1 && (!rooms.get(j).getStudents().contains(students.get(i).getRoomy()))){
								rooms.get(j).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
							else if(rooms.get(j).hasSpace() != 0){
								rooms.get(j).setStudent(students.get(i).getName());
								names.add(students.get(i).getName());
							}
						}
					}
				}
			}
		}
		String output = "";
		for(int i = 0; i<rooms.size(); i++) output += (rooms.get(i).getRoomNum() + ": " + rooms.get(i).getStudents() + "\r\n");
		PrintWriter file = new PrintWriter("There You Go!.txt");
		file.write(output);
		file.close();
	}

	public void saveXML() throws FileNotFoundException{
        String output = "<?xml version=\"1.0\" encoding=\""+ "UTF-8" + "\"?>"+"\r\n<students>";
        for (int i = 0; i<students.size(); i++)
        {
            output += students.get(i).toString();
        }
        for(int i = 0; i<rooms.size(); i++){
        	output += rooms.get(i).toString();
        }
        output += "\r\n</students>";
        PrintWriter file = new PrintWriter("Students Names.xml");
        file.write(output);
        file.close();
	}
	
	public void requestStudent(String student, String request) throws FileNotFoundException {
		int loc = 0;
		int loc2 = 0;
		if(!student.equals("") || !request.equals("")){
			for(int i = 0; i < students.size(); i++){
				if(students.get(i).getName().equals(student)) loc = i;
				else if(students.get(i).getName().equals(request)) loc2 = i;
			}
			if(students.get(loc).getSex().equals(students.get(loc2).getSex()) && !student.equals(request))
				students.get(loc).setRequested(request);
		}
		saveXML();
	}
}
