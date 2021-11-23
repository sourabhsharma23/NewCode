package com.qait.automation.utils;

import static com.qait.automation.utils.ConfigPropertyReader.getProperty;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import junit.framework.Assert;

public class PropFileHandler {

	public PropFileHandler() {
		// TODO Auto-generated constructor stub
	}
	static Properties properties = new Properties();
	public static String tier;
	String filePath = "";
	
	public PropFileHandler(File file){
		  properties = new Properties();
		  if(file.exists())
		   file.delete();
		  try {
		   file.createNewFile();
		   filePath = file.getAbsolutePath();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		 }
	
	public void writeToFile(Map<String, String> storedData)  {
		  try {
		   InputStream inPropFile = new FileInputStream(filePath);
		   properties.load(inPropFile);
		   System.out.println("Properties object"+properties);
		   inPropFile.close();
		   OutputStream outPropFile = new FileOutputStream(filePath);
		   System.out.println(storedData);
		   properties.putAll(storedData);
		   properties.store(outPropFile, null);
		   outPropFile.close();
		  } catch (Exception e) {
		   System.out.println("Unable to write data in property file :- "+storedData);
		   e.printStackTrace();
		  }
		 }

	/**
	 * This method is used to read the value of the given property from the
	 * properties file.
	 *
	 * @param property : the property whose value is to be fetched.
	 * @return the value of the given property.
	 * @throws IOException 
	 */
	public static String readProperty(String property) {
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/Data.properties");
			properties.load(inPropFile);
		} catch (IOException e) {
			System.out.println("There was Exception reading the Test data");
		}
		String value = properties.getProperty(property);
		return value;
	}

	
	public static String readHartfordProperty(String property) {
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream("data/hartford.properties");
			properties.load(inPropFile);

		} catch (IOException e) {
		}
		String value = properties.getProperty(property);

		return value;
	}
	/**
	 * This method is used to store a new property in the properties file.
	 *
	 * @param property : name for the new property.
	 * @param value : value for the new property.
	 * @throws IOException
	 */
	public static void writeProperty(String property, String value) {
		// Write properties file.
		//OutputStream outPropFile = null;

		try {
			InputStream inPropFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/Data.properties");
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/Data.properties");
			//System.getProperty("user.dir")+"\\AnswerKeys\\"+top+".properties"

			properties.setProperty(property, value);
			properties.store(outPropFile, null);
			outPropFile.close();
		} catch (IOException e) {
		}
	}

	public static void writePropertyInContentMetaDataFile(String property, String value) {

		try {
			InputStream inPropFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/test.properties");
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/test.properties");
			//System.getProperty("user.dir")+"\\AnswerKeys\\"+top+".properties"

			properties.setProperty(property, value);
			properties.store(outPropFile, null);
			outPropFile.close();
		} catch (IOException e) {
		}
	}

	public static Set<Object> getAllKeysFromPropertiesFile (String fileName){
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/"+fileName+".properties");
			properties.load(inPropFile);
		} catch (IOException e) {
			System.out.println("There was Exception reading the Test data");
		}
		return properties.keySet();
	}

	public static int getSumOfAssetsWithSpecificKey(String keyName,Set<Object> keys){
		int i=0;
		for (Iterator<Object> it = keys.iterator(); it.hasNext(); ) {
			String s=it.next().toString();
			if(s.contains(keyName)){
//				System.out.println("calculating assets for: "+s);
				i=i+Integer.parseInt(readDataFromDataPropertiesFile("test",s));
			}
		}return i;
	}


	public static void clearProperty() {
		try {
			InputStream inPropFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/Data.properties");
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/Data.properties");
			properties.clear();
			outPropFile.close();
		} catch (IOException e) {
		}
	}

	public static void writeDataInReportsData(String property, String str){
		try {
			InputStream inPropFile = new FileInputStream(System.getProperty("user.dir")+"/ReportsData/Data.properties");
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(System.getProperty("user.dir")+"/ReportsData/Data.properties");
			//System.getProperty("user.dir")+"\\AnswerKeys\\"+top+".properties"

			properties.setProperty(property, str);
			properties.store(outPropFile, null);
			outPropFile.close();
		} catch (IOException e) {
		}
	}

	public static void writeDataInReportsData(String property, String str,String fileName){
		try {
			InputStream inPropFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testData/"+fileName+".properties");
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/testData/"+fileName+".properties");
			//System.getProperty("user.dir")+"\\AnswerKeys\\"+top+".properties"
			properties.store(outPropFile, null);
			outPropFile.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	public static String readReportsData(String property) {
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(System.getProperty("user.dir")+"/ReportsData/Data.properties");

			properties.load(inPropFile);

		} catch (IOException e) {
			System.out.println("There was Exception reading the Test data");
		}
		String value = properties.getProperty(property);
		return value;
	}

	public static void clearPropertyFromReports() {
		try {
			InputStream inPropFile = new FileInputStream(System.getProperty("user.dir")+"/ReportsData/Data.properties");
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(System.getProperty("user.dir")+"/ReportsData/Data.properties");
			properties.clear();
			outPropFile.close();
		} catch (IOException e) {
		}
	}


	//********* Handle Data Properties With Time Stamp ***********

	public static boolean writeDataToFileWithTimeStamp(String Property, String Data) {
		tier = getProperty("Config.properties", "tier").trim();
		tier = System.getProperty("tier",tier);
		PrintWriter pw = null;
		boolean result = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String timeStamp = dateFormat.format(cal.getTime());
		String value = Data+"_Created_"+timeStamp;
		System.out.println("Data="+ value);
		try 
		{
			System.out.println("Start of try block");
			URL url = ResourceLoader.getResourceUrl("data");
			System.out.println(url);
			String path = System.getProperty("user.dir")+"/src/test/resources/testdata/SelfRegistrationUsers"+tier.toUpperCase()+".properties";
			String dataFolderPath = URLDecoder.decode(path, "UTF-8");
			String outFilePath = dataFolderPath;
			System.out.println(outFilePath);
			pw = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath , true)));
			pw.println(Property + "=" + value);
			result = true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
		finally {
			if (pw != null) {
				pw.close();
			}

		}

		return result;
	}

	public static void writePropertyForUserData(String property, String value) {
		tier = getProperty("Config.properties", "tier").trim();
		tier = System.getProperty("tier",tier);
		try {
			InputStream inPropFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/SelfRegistrationUsers"+tier.toUpperCase()+".properties");
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/SelfRegistrationUsers"+tier.toUpperCase()+".properties");
			//System.getProperty("user.dir")+"\\AnswerKeys\\"+top+".properties"

			properties.setProperty(property, value);
			properties.store(outPropFile, null);
			outPropFile.close();
		} catch (IOException e) {
		}
	}

	public static String readDataFromFile(String Property) {
		tier = getProperty("Config.properties", "tier").trim();
		tier = System.getProperty("tier",tier);
		try {
			Properties prop = ResourceLoader.loadProperties(System.getProperty("user.dir")+"/src/test/resources/testdata/SelfRegistrationUsers"+tier.toUpperCase()+".properties");
			String value = prop.getProperty(Property).split("_Created_")[0];
			return value;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String readDataFromFileWithTimeStamp(String Property){
		tier = getProperty("Config.properties", "tier").trim();
		tier = System.getProperty("tier",tier);
		try {
			Properties prop = ResourceLoader.loadProperties(System.getProperty("user.dir")+"/src/test/resources/testdata/SelfRegistrationUsers"+tier.toUpperCase()+".properties");
			return prop.getProperty(Property);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	public static boolean writeDataToFile(String Property, String Data) {
		PrintWriter pw = null;
		boolean result = false;
		System.out.println("Data="+ Data);
		try 
		{
			System.out.println("Start of try block");
			URL url = ResourceLoader.getResourceUrl("data");
			System.out.println(url);
			String path = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Data.properties";
			String dataFolderPath = URLDecoder.decode(path, "UTF-8");
			String outFilePath = dataFolderPath;
			System.out.println(outFilePath);
			pw = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath , true)));
			pw.println(Property + "=" + Data);

			result = true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
		finally {
			if (pw != null) {
				pw.close();
			}

		}

		return result;
	}
	
	public static boolean writeDataToDataValidationFile(String Property, String Data) {
		PrintWriter pw = null;
		boolean result = false;
		System.out.println("Data="+ Data);
		try 
		{
			System.out.println("Start of try block");
			URL url = ResourceLoader.getResourceUrl("data");
			System.out.println(url);
			String path = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\data_validation.properties";
			String dataFolderPath = URLDecoder.decode(path, "UTF-8");
			String outFilePath = dataFolderPath;
			System.out.println(outFilePath);
			pw = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath , true)));
			pw.println(Property + "=" + Data);

			result = true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
		finally {
			if (pw != null) {
				pw.close();
			}

		}

		return result;
	}

	public static String readDataFromDataValidationFile(String Property) {
		try {
			Properties prop = ResourceLoader.loadProperties(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\data_validation.properties");
			return prop.getProperty(Property);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	public static String readDataFromDataPropertiesFile(String Property) {
		try {
			//				Properties prop = ResourceLoader.loadProperties("data/data.txt");
			Properties prop = ResourceLoader.loadProperties(System.getProperty("user.dir")+"/src/test/resources/testdata/Data.properties");
			return prop.getProperty(Property);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String readDataFromDataPropertiesFile( String fileName,String Property) {
		try {
			//				Properties prop = ResourceLoader.loadProperties("data/data.txt");
			Properties prop = ResourceLoader.loadProperties(System.getProperty("user.dir")+"/src/test/resources/testdata/"+fileName+".properties");
			return prop.getProperty(Property);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
