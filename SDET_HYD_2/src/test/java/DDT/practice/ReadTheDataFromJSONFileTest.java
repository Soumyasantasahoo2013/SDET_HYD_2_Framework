package DDT.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

/**
 * This class for reading data from JSON File
 * @author SOUMYASANTA SAHOO
 *
 */
public class ReadTheDataFromJSONFileTest {
	
	@Test
	public void readTheDataFromJsonFile() throws Throwable
	{
		//Step=1 convert the JSON File into Json Object
		FileReader fr=new FileReader("./Data/commonData.json");
		
		//Step=2 convert JSON Object into Java Object
		JSONParser jp=new JSONParser();
		Object jObj = jp.parse(fr);
		
		//Step=3 Read the data using HashMap
		HashMap obj = (HashMap)jObj;
		Object value = obj.get("url");
		System.out.println(value);
	}

}
