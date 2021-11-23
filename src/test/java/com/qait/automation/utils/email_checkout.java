
 package com.qait.automation.utils;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class email_checkout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//MERGE check
		  Properties props = new Properties();
	        props.setProperty("mail.store.protocol", "imaps");
	        props.put("mail.imaps.auth.plain.disable", "true");
	        props.put("mail.imaps.auth.ntlm.disable", "true");
	          props.put("mail.imaps.auth.gssapi.disable", "true");
	        try {
	            Session session = Session.getInstance(props, null);
	            Store store = session.getStore();
	            store.connect("outlook.office365.com", "priyadarshi.bharat@harvardbusiness.org/clqatest", "Hero4135%");
	            Folder inbox = store.getFolder("INBOX");
	            inbox.open(Folder.READ_ONLY);
	            int some=inbox.getUnreadMessageCount();
	            System.out.println("Unread messages are: "+some);
	            System.out.println("Message count is: "+inbox.getMessageCount());
	            Message msg = inbox.getMessage(inbox.getMessageCount());
	            Address[] in = msg.getFrom();
	            for (Address address : in) {
	                System.out.println("FROM:" + address.toString());
	            }
	            
	            Object content = msg.getContent();  
	            if (content instanceof String)  
	            {  
	                String body = (String)content;
		            System.out.println("SENT DATE:" + msg.getSentDate());
		            System.out.println("SUBJECT:" + msg.getSubject());
		            System.out.println("CONTENT:" + msg.getContent());
	            }  
	            else if (content instanceof Multipart)  
	            {  
	                Multipart mp = (Multipart) msg.getContent();
		            BodyPart bp = mp.getBodyPart(0);
		            System.out.println("SENT DATE:" + msg.getSentDate());
		            System.out.println("SUBJECT:" + msg.getSubject());
		            System.out.println("CONTENT:" + bp.getContent());
	            }  
	            
	           
	        } catch (Exception mex) {
	            mex.printStackTrace();
	        }
	    }
	}

