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
     int size = table.length;
     final String SEP1 = "\n";
     final String SEP2 = "\r";
   
     
     for ( int i =0; i < size; i ++) {
            // looking for the delimeter, and remember its position
           if (lines.contains(SEP1)) {
              for ( int k = 0;k <i; k++ )
                 table[0] = lines.substring(0, lines.indexOf(SEP1));
              
              table[1]= lines.substring(lines.indexOf(SEP1)+1);
            
           }
           else if  (lines.contains(SEP2)) {
              for ( int k = 0;k <i; k++ )
                 table[0] = lines.substring(0, lines.indexOf(SEP2));
              
              table[1]= lines.substring(lines.indexOf(SEP2)+1);
          
           }
          
          // if nothing was found, lines does not containt any delimeters, we
          // put everything in the second cas and nothing in the first one
           else {
                   table[0] = null;
                   table[1]= lines;
     
     }   
  }
 return table;
  }

}
