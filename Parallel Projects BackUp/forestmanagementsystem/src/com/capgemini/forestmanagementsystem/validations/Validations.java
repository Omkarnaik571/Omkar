package com.capgemini.forestmanagementsystem.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	
	public static boolean isStringOnlyAlphabet(String str) 
    { 
		
        return ((str != null) 
                && (!str.equals("")) 
                && (str.matches("^[a-zA-Z]*$"))); 
    }
	
	public static boolean isValid(String email) 
    {  
		String emailRegex = "^[a-z0-9_+&*-]+(?:\\."+ 
                "[a-z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	
	
	public static boolean isValidDate(String d) 
    { 
        String regex = "^(1[0-2]|0[1-9])/(3[01]"
                       + "|[12][0-9]|0[1-9])/[0-9]{4}$"; 
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher((CharSequence)d); 
        return matcher.matches(); 
    }

	public static boolean isNumber1(String s) {
		try {
			long t = Long.parseLong(s);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	} 
	
	
	public static boolean isValidDay(String s) {
		String temp=s.toLowerCase();
		if(temp.equals("sunday") || temp.equals("monday") || temp.equals("tuesday") || temp.equals("wednesday") 
			||temp.equals("thursday") || temp.equals("friday") || temp.equals("saturday")	
				) {
			return true;
		}
		return false;
	}
	
	public static boolean isVaidPhoneNumber(String number) {
		if(number.length() != 10 ) {
	       return false;
		}
		return true;

	}
	
	public static boolean isVaidPostalCode(String number) {
		if(number.length() != 6 ) {
	       return false;
		}
		return true;

	}
	
	
	
}









		