package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import src.RoomOrder;

public class RoomOrderTest {
	private RoomOrder rmOr;
	@Before
	public void setUp() throws IOException{
		rmOr = new RoomOrder();
		rmOr.openDatabase("Student Names.xml");
	}
	
	@Test
	public void testReadNames(){
		assertEquals("Sari Sabouh* Christopher Serrano Woong Kwon Taylor Quarles Alejandro Kirienko Justin Farmer Lucas Glinschert Sebastian Mendez* Cameran Powers Mason Battles International1 Sergio Grimaldo International2 Mouad Mentak Martin Pazmino William Britton International3 Khoi Phan Clement Dikoko International4 Maria Ortiz International5 Bethany Kennedy Joan Alzoubi Marisa Gray Kimberlyn Mendoza Laranda Wstbrook* International6 Rebekah Britton Noella Mupungila American1 American2 American3 Ida Sunnaborg Valeria Pazmino International7 Brianna Bell Natalia Esparragoza American4 Marignima Souane* ", rmOr.getNames());
	}
	
	
	@Test
	public void testReadAllData(){
		assertEquals("3", rmOr.getYear("Sari Sabouh*"));
		assertEquals("Palestine", rmOr.getCountry("Sari Sabouh*"));
		assertEquals(true, rmOr.getBathroom("Sari Sabouh*"));
		assertEquals("3", rmOr.getYear("Valeria Pazmino"));
		assertEquals("Ecuador", rmOr.getCountry("Valeria Pazmino"));
		assertEquals(true, rmOr.getBathroom("Valeria Pazmino"));
		assertEquals("F", rmOr.getSex("Valeria Pazmino"));
	}
	
	//@Test
	public void testRoomPlacements(){
		rmOr.placeStudents();
		assertEquals("Sari Sabouh*, Justin Farmer", rmOr.getRoommates("107M"));
	}
	
	@Test
	public void testRequestStudent(){
		rmOr.requestStudent("Sari Sabouh*", "Justin Farmer");
		rmOr.placeStudents();
		assertEquals("Sari Sabouh*, Justin Farmer", rmOr.getRoommates("107M"));
		for(int i = 0; i<rmOr.rooms.size(); i++) System.out.println(rmOr.rooms.get(i).getRoomNum() + ": " + rmOr.rooms.get(i).getStudents());
	}
	
	
	

}
