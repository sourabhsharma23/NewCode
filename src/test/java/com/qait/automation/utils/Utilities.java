/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.utils;

/**
 *
 * @author 
 */

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
//import org.yaml.snakeyaml.Yaml;


public class Utilities {

	private Pattern pattern;
	  private Matcher matcher;
	  public static List<String>pre=Arrays.asList("a","atop","into","save","abaft","barring","like","since","abeam","before","mid","than","aboard","behind","through","about","below","midst","throughout","above","beneath","till","absent","beside","minus","across","besides","modulo","times","afore","between","near","to","after","beyond","next","towards","against","but","notwithstanding","along","towards","by","under","alongside","circa","underneath","amid","of","unlike","amidst","concerning","off","until","among","despite","on","unto","amongst","down","onto","up","an","during","apposite","upon","except","out","versus","amenst","excluding","outside","apropos","failing","over","apud","for","past","vice","around", "in","per","as","from","plus","with","given","pro","within","aside","in","qua","astride","including","regarding","without","at","inside","regarding","without","round","worth","athwart","sans","and");
	  private static final String TIME12HOURS_PATTERN = 
                              "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";

    public static String yamlFilePath = "testdata/integration_testData.yml";
//    HSSFWorkbook workbook;

    public Utilities() {
    }
    
	  public boolean validate(final String time){		  
		  matcher = pattern.matcher(time);
		  return matcher.matches();	    	    
	  }
	  
    public static String setYamlFilePath(String filePath) {
        yamlFilePath = filePath;
        return filePath;
    }

//    public static String getYamlValue(String yamlToken) {
//        Reader reader = null;
//        int tokenCount = 0, i = 0;
//		Map map = null;
//
//        StringTokenizer st = new java.util.StringTokenizer(yamlToken, ".");
//        try {
//            reader = new FileReader(yamlFilePath);
//            String val = null;
//            Yaml yaml = new Yaml();
//            map = (Map) yaml.load(reader);
//            tokenCount = st.countTokens();
//            for (i = 1; i < tokenCount; i++) {
//                String token = st.nextToken();
//                map = (Map) map.get(token);
//            }
//            val = map.get(st.nextToken()).toString();
//            return val;
//        } catch (Exception e) {
//            System.out.println("Yaml file not found!!!\n" + e);
//            return "";
//        }
//    }
//    
    public static String getTextFromClipboard() throws UnsupportedFlavorException, IOException{
    	Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		return result;
    }
    
    public static String copyTextfromInputFieldElementUsingKeyboard(WebElement elem) throws UnsupportedFlavorException, IOException{
    	elem.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"));
    	Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		return result;
    }
    
   

//    public static String writeYamlValue(String yamlToken) {
//        Writer writer = null;
//        int tokenCount = 0, i = 0;
//        Map map = null;

//        StringTokenizer st = new java.util.StringTokenizer(yamlToken, ".");
//        try {
//            writer = new FileWriter(yamlFilePath);
//            String val = null;
//            Yaml yaml = new Yaml();
//            map = (Map) yaml.load(writer.toString());
//            tokenCount = st.countTokens();
//            for (i = 1; i < tokenCount; i++) {
//                String token = st.nextToken();
//                map = (Map) map.get(token);
//            }
//            val = map.get(st.nextToken()).toString();
//            return val;
//        } catch (Exception e) {
//            System.out.println("Yaml file not found!!!\n" + e);
//            return "";
//        }
//    }


    public static void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }

    }
    
    public static boolean checkIfAllTheTopicIsPreVisted(List <WebElement> listWeb){
    	int size=listWeb.size();
    	boolean val=false;
    	for(int i=0;i<listWeb.size();i++){
    		   if(listWeb.get(i).getAttribute("class").equalsIgnoreCase("painted")){ return false;}
    		   else{
    			   
    			     val=true;}
    	}
    	return val;
    }
    


    public static String get_theTopicTilte(String str){
    	try{
    	char []ch= str.toCharArray(); 
    	 
    	   ch[0]=(char)( (int) ch[0] + 32);
    	  
    	  for(int i=1;i<str.length();i++){
    		
    		  
    		  	 if(ch[i]==' '){
    		  		 ch[i+1]=(char)( (int) ch[i+1] + 32);
    		  	 }
    		  	  
    	  }
    			String str1=new String(ch);
    			
    			String []str2=str1.split(" ");
    			return str2[0]+"_"+str2[1];
    				
    			
            }
    catch(Exception e){
    	return str;
        }
    }
    
    public static void copyUsingKeyboard(WebElement e){
	e.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"));
}
    public static String captureScreen(WebDriver driver) {

        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "C:/Users/priyadarshibharat.QAIT/Desktop/HMMv12_Automation";
            FileUtils.copyFile(source, new File(path)); 
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;

    }
    
    public static String removePrepositionsfromstring(String str){
		for(int y=0;y<pre.size();y++){
			String str1=pre.get(y);
			if(str.contains(str1)){
				//str.replace(str1, "");
				str=StringUtils.remove(str, str1+" ");
//				System.out.println("preposition found: "+str1);
//				System.out.println("preposition removed: "+str);
			}
		}return str;
	}
    
	public static boolean checkStringInTitleCase(String str){
		boolean a;
		str=removePrepositionsfromstring(str);
		String s=str.trim();
		if (!s.contains("_")){
			String firstChar=s.substring(0,1);
			a=testAllUpperCase(firstChar);
			if(!a){
//				System.out.println("char at 1st was:" +firstChar);
				return  false;
			}
			for(int i=0; i<s.length(); i++){
				String z=s.substring(i,i+1);
//				char c=s.charAt(i);
				if(z.equals(" ")){
					String y=s.substring(i+1,i+2);
//					b= d >=97 && c<=122; 
					if(!testAllUpperCase(y)){
//						System.out.println("break at, \\"+y);
						return false;
					}continue;
				}continue;
			}return true;
		}return false;
	}

	public static boolean testAllUpperCase(String str){
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c >=97 && c<=122) {
				return false;
			}
		}
		//str.charAt(index)
		return true;
	}
	
	public static String getCurrentMonthNameInAlphabets(){
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };
		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];
		return month;
	}
	
	public static String dateBeforeOneDays(){
		LocalDate now = LocalDate.now();
		now=now.minusDays(1);
		return now.getDayOfMonth()+"-"+now.getMonth()+"-"+now.getYear();
	}
	
	public static String dateAfterOneDay(){
		LocalDate now = LocalDate.now();
		now =now.plusDays(1);
		return now.getDayOfMonth()+"-"+now.getMonth()+"-"+now.getYear();
	}
	
	public static int getCurrentDay(){
		 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	     int day = calendar.get(Calendar.DATE);
	     return day;
	}
	
	public static String getCurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	public static int getCurrentYear(){
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int year = calendar.get(Calendar.YEAR);
		return year;
	}
	 

}
