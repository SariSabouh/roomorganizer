package src;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class xmlMaker{
	public static void main(String [] args) throws FileNotFoundException{
		String output = "";
		output = "<?xml version=\"1.0\" encoding=\""+ "UTF-8" + "\"?>"+"\r\n<students>";
        for (int i = 0; i<40; i++)
        {
			output += "\r\n\t<student>\r\n\t\t<fullName></fullName>";
			output += "\r\n\t\t<year></year>";
			output += "\r\n\t\t<sharedBathroom></sharedBathroom>";
			output += "\r\n\t\t<country></country>";
			output += "\r\n\t\t<gender></gender>\r\n\t</student>";
        }
        output += "\r\n</students>";
        PrintWriter file = new PrintWriter("Student Names.xml");
        file.write(output);
        file.close();
	}
}