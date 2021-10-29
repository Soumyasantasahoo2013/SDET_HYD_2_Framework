package com.vtiger.genericutil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

/**
 * This class is used to read data from JSON File
 * @author SOUMYASANTA SAHOO
 *
 */
public class JSONFileUtility {
	
	@Test
	public String jsonFileUtility(String key) throws Throwable
	{
		FileReader fir=new FileReader(IPathConstant.JSONFILEPATH);
		JSONParser parser=new JSONParser();
		Object jObj = parser.parse(fir);
		HashMap obj = (HashMap)jObj;
		Object value = obj.get(key);
		return (String) value;
	}

}
