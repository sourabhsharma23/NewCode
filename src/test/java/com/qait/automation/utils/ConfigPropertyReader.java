package com.qait.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

/**
 * This is the utility class for data read write
 *
 * @author QAIT
 *
 */
public class ConfigPropertyReader {

    private static String defaultConfigFile = "./Config.properties";
    
    /**
     * construtor of this class
     */
    public ConfigPropertyReader() {
    }

    /**
     *
     * This method will get the properties pulled from a file located relative to the base dir
     *
     * @param propFile complete or relative (to base dir) file location of the properties file
     * @param Property property name for which value has to be fetched
     * @return String value of the property
     */
    public static String getProperty(String propFile, String Property) {
        try {
            Properties prop = ResourceLoader.loadProperties(propFile);
            return prop.getProperty(Property);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static HashMap<String,String> readAllPropertyVlauesFromConfigFile(){
        HashMap<String,String> mymap = new HashMap<String, String>();
        Properties prop;
        try {
           prop =ResourceLoader.loadProperties(defaultConfigFile);
           for (final Entry<Object, Object> entry : prop.entrySet()) {
             mymap.put((String) entry.getKey(), (String) entry.getValue());
            }
            return mymap;
        } catch (IOException e) {
            return null;
        }finally {
            //prop.c
           }
      }
    
    public static String getProperty(String property){
        return getProperty(defaultConfigFile, property);
    }
    
    public static void writeProperty(String key, String val) throws IOException {
    	Properties properties = new Properties();
    	 InputStream inPropFile = new FileInputStream(System.getProperty("user.dir")+"/Config.properties");
         properties.load(inPropFile);
         inPropFile.close();
         OutputStream outPropFile = new FileOutputStream(System.getProperty("user.dir")+"/Config.properties");
         properties.setProperty(key, val);
         properties.store(outPropFile, null);
         outPropFile.close();
    	} 
}
