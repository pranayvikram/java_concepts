package com.concept.patternMatcher;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

   public static void main( String args[] ) {
	   
      // String to be scanned to find the pattern.
      String line = "This order was placed for QT3000! OK?";
      String patternString = "(.*)(\\d+)(.*)";

      // Create a Pattern object
      Pattern pattern = Pattern.compile(patternString);

      // Now create matcher object.
      Matcher m = pattern.matcher(line);
      if (m.find()) {
         System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
         System.out.println("Found value: " + m.group(3) );
        // System.out.println("Found value: " + m.group(4) );
      } else {
         System.out.println("NO MATCH");
      }
   }
}