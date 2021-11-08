package com.vtiger.genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

/**
 * This class is used to read data from Property file
 * @author SOUMYASANTA SAHOO
 *
 */
public class PropertyFileUtility {
	
	@Test
	public String propertyFileUtility(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.PROPERTYFILEPATH);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
