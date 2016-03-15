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
    * @return an array with 2 elements; the first element is the next line with the
    * line separator, the second element is the remaining text. If the argument does
    * not contain any line separator, then the first element is an empty string.
    */
   public static String[] getNextLine(String lines) {

      String[] table = new String[2];
      final String SEP1 = "\n";
      final String SEP2 = "\r";
      final String SEP3 = "\r\n";
      int position ;

      // find the position of these delimiters
      if (lines.contains(SEP1)) {
         position = lines.indexOf(SEP1);
         // delimiteur = SEP1;
      } else if (lines.contains(SEP2)) {
         position = lines.indexOf(SEP2);
         //  delimiteur = SEP2;
      } else if (lines.contains(SEP3)) {
         position = lines.indexOf(SEP3);
         //delimiteur = SEP3;
      } //If there is no delimiter
      else {
         table[0] = "";
         table[1] = lines;
         return table;
      }

      
      
//       int idx = lines.indexOf(delimiter) + 1;
//    array[0] = lines.substring(0, idx);
//
//    //Case where the line contain other lines
//    if(lines.length() > idx){
//      array[1] = lines.substring(idx);
//    }
//    //Case where there is no other line
//    else{
//      array[1] = "";
//    }
//    return array;
//  }
//      
      
      
      table[0] = lines.substring(0, position + 1);

      //if something left in the ligne
      if (lines.length() > position) {
         table[1] = lines.substring(position+1);
      } 
      //if there is nothing
      else {
         table[1] = "";
      }
      return table;

   }
}
