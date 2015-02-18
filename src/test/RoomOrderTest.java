package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import src.RoomOrder;

public class RoomOrderTest {
	private RoomOrder rmOr = new RoomOrder();
	
	@Test
	public void testReadNames() throws IOException {
		rmOr.openDatabase("Student Names.txt");
		assertEquals("Sari Sabouh Valeria Pazmino Justin Farmer Maria Trabanino ", rmOr.getNames());
	}
	
	
	@Test
	public void testReadAllData() throws IOException{
		rmOr.openDatabase("Student Names.txt");
		assertEquals("3", rmOr.getYear("Sari Sabouh"));
		assertEquals("Palestine", rmOr.getCountry("Sari Sabouh"));
		assertEquals(true, rmOr.getBathroom("Sari Sabouh"));
		assertEquals("3", rmOr.getYear("Valeria Pazmino"));
		assertEquals("Ecuador", rmOr.getCountry("Valeria Pazmino"));
		assertEquals(true, rmOr.getBathroom("Valeria Pazmino"));
		assertEquals("F", rmOr.getSex("Valeria Pazmino"));
	}
	
	@Test
	public void testRoomPlacements() throws IOException{
		rmOr.openDatabase("Student Names.txt");
		rmOr.createEmptyRooms();
		rmOr.placeStudents();
		assertEquals("Sari Sabouh, Justin Farmer", rmOr.getRoommates("207M"));
	}
	
	
	

}
