package com.qait.automation.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class DataProvider {

    public DataProvider() {
    }

    public static Object[][] provider(String csvFile, String hasHeader) {
        BufferedReader br = null;
        ArrayList<String> dataRows = new ArrayList<String>();
        String line = "";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            if (hasHeader.equalsIgnoreCase("yes") ||hasHeader.equalsIgnoreCase("true")){
              br.readLine();// in case first line is header in the csv file
            }
            while ((line = br.readLine()) != null) {
               dataRows.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Object[][] returnObject = new Object[dataRows.size()][1];


            for (int i = 0; i < dataRows.size(); i++){
                returnObject[i][0]  = dataRows.get(i);
            }
       return returnObject;
    }
    
    public int getRandomInteger(int max, int min){
		Random r = new Random();
		int randomNum = r.nextInt((max - min) + 1) + min;
		System.out.println("Random number: "+randomNum);
		return randomNum;
	}
    
	public static String getCurrentMonthNameInAlphabets(){
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };
		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];
		return month;
	}
}
