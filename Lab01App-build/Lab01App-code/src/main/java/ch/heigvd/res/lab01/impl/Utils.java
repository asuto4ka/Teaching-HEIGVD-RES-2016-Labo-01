package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {

     String[] table = new String[2];
     String temp = "";
     final String SEP1 = "\n";
     final String SEP2 = "\r";  
     final String SEP3 = "\r\n";
     int current_position =0,
         position1 = -1,
         position2 = -1,
         position3= -1;
     int temp_pos=0;
     
     // find the position of these delimiters
     if (lines.contains(SEP1)) {
        position1 = lines.indexOf(SEP1);
     } 
     else if (lines.contains(SEP2)) {
        position2 = lines.indexOf(SEP2);

     } 
     else if (lines.contains(SEP3)) {
        position3 = lines.indexOf(SEP3);
     }
       
     // nothing was found
     else {
        table[0]= "";
        table [1]= lines;
        return table;
     }    
     
     
     
     //which one occurs first
     if   ( position1 < position2 ){
        temp_pos = position1; 
     }
     else{
        temp_pos = position2; 
     }
   
      if (temp_pos > position3) 
         temp_pos= position3;
       
      current_position= temp_pos;
   
    table[0] = lines.substring(0, current_position + 1);
    table[1] = lines.substring(current_position);
    
    
    return table;
    
} 
}