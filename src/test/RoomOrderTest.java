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
		rmOr.createEmptyRooms();
	}
	
	@Test
	public void testReadNames(){
		assertEquals("Sari Sabouh* Christopher Serrano Woong Kwon Taylor Quarles Alejandro Kirienko Justin Farmer Lucas Glinschert Sebastian Mendez* Cameran Powers Mason Battles Salem Mohd Sergio Grimaldo Collins Maroa Mouad Mentak Martin Pazmino William Britton Sebastian Pena Khoi Phan Clement Dikoko Kuvvat Jorayev Maria Ortiz Moyinoluwa Iduma Bethany Kennedy Joan Alzoubi Marisa Gray Kimberlyn Mendoza Laranda Wstbrook* Andrea Ortiz Rebekah Britton Noella Mupungila Tiffany Jeter Lara Lubienski Jasmine Beaudette Ida Sunnaborg Valeria Pazmino Maria Trabanino Brianna Bell Natalia Esparragoza Kanako Seiji Marignima Souane* ", rmOr.getNames());
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
	}
	
	
	

}
