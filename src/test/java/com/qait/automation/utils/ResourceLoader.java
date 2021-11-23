package com.qait.automation.utils;

/**
 *
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

/**
 * @author Administrator
 *
 */
public class ResourceLoader {

	 private ResourceLoader() {
	    }

	 /**
     *
     * @param resourceName
     * @return
     * @throws IOException
     */
    public static URL getResourceUrl(String resourceName) throws IOException {
        ClassLoader classLoader = ResourceLoader.class.getClassLoader();

        URL resourceUrl = null;

        if (classLoader != null) {
        	resourceUrl = classLoader.getResource(resourceName);
        }

        if (resourceUrl == null) {
            classLoader = ClassLoader.getSystemClassLoader();
            if (classLoader != null) {
            	resourceUrl = classLoader.getResource(resourceName);
            }
        }

        return resourceUrl;
    }//end loadResource

	    /**
	     *
	     * @param resourceName
	     * @return
	     * @throws IOException
	     */
	    public static InputStream loadResource(String resourceName) throws IOException {
	        ClassLoader classLoader = ResourceLoader.class.getClassLoader();

	        InputStream inputStream = null;

	        if (classLoader != null) {
	            inputStream = classLoader.getResourceAsStream(resourceName);
	        }

	        if (inputStream == null) {
	            classLoader = ClassLoader.getSystemClassLoader();
	            if (classLoader != null) {
	                inputStream = classLoader.getResourceAsStream(resourceName);
	            }
	        }

	        if (inputStream == null) {
	            File file = new File(resourceName);
	            if (file.exists()) {
	                inputStream = new FileInputStream(file);
	            }
	        }

	        return inputStream;
	    }//end loadResource

	    /**
	     *
	     * @param resourceName
	     * @return
	     * @throws IOException
	     */
	    public static Properties loadProperties(String resourceName) throws IOException {
	        Properties properties = null;
	        InputStream inputStream = null;
	        try {
	            inputStream = loadResource(resourceName);
	            if (inputStream != null) {
	                properties = new Properties();
	                properties.load(inputStream);
	            }
	        } finally {
	            if (inputStream != null) {
	                inputStream.close();
	            }
	        }
	        return properties;
	    }
	    
		public static void writeInExcel(String fileName,String sheetName,int row, int cell, String messageLog) throws IOException{
			FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"/"+fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			Row r=sheet.getRow(row);
			r.createCell(cell).setCellValue(messageLog);
			file.close();
			FileOutputStream outFile =new FileOutputStream(new File(System.getProperty("user.dir")+"/"+fileName));
			workbook.write(outFile);
			outFile.close();
		}
		
		public static String readValueFromXLS(String fileName,String sheetName,int row,int cell) throws IOException{
			//TODO, FIXME after Integrations
//			String environment=getData();
//			HSSFWorkbook myWorkBook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(new File(System.getProperty("user.dir")+"/"+fileName))));
			FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"/"+fileName));
//			if(StringUtils.containsIgnoreCase(environment, "prod")){
				file = new FileInputStream(new File(System.getProperty("user.dir")+"/"+fileName));
//			}
//			XSSFWorkbook	
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row r=sheet.getRow(row);
			return r.getCell(cell).getStringCellValue();
		}
		

}
