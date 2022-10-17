package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	
public	String  getPropertyKeyValue1(String key) throws Throwable {
	FileInputStream fils =new FileInputStream("./Common_Data.properties");
	Properties pro=new Properties();
	pro.load(fils);
	String value = pro.getProperty(key);
	return value;
	
}

}
