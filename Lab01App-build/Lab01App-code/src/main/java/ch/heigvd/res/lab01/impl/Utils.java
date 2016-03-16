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

      int position, position1 = -1, position2 = -1, position3 = -1;
      int flag=1;

      // find the position of these delimiters
      if (lines.contains(SEP1)) {
         position1 = lines.indexOf(SEP1);
      }
      if (lines.contains(SEP2)) {
         position2 = lines.indexOf(SEP2);
      // check if the "\n" is the next char after "\r"
          if (position2 < lines.length()-2 && lines.substring(position2+1, position2+2).equals(SEP1)  )
                  position2=-1;
      }
      if (lines.contains(SEP3)) {
         position3 = lines.indexOf(SEP3);
                 
            
      }

//If there is no delimiter
      if (position1 == -1 && position2 == -1 && position3 == -1) {

         table[0] = "";
         table[1] = lines;
         return table;

      } else {
      // since -1 is always smaller that the min value of existing caracter we have
         // to fixe it to the biggest value in order to be sure to pick the smallest position   
         if (position1 == -1) {
            position1 = Integer.MAX_VALUE;
         }

         if (position2 == -1) {
            position2 = Integer.MAX_VALUE;
         }

         if (position3 == -1) {
            position3 = Integer.MAX_VALUE;
         }

         // find the smallest potision
         if (position2 < position3) {
            if (position1 < position2) {
               position = position1;
            } else {
               position = position2;
            }
         } else {
            if (position3 < position1) {
               position = position3;
               flag=2;
            } else {
               position = position1;
            }
         }
         
         //if \r\n was found we have to add 2 position, if not we add 1
         table[0] = lines.substring(0, position + flag);
         table[1] = lines.substring(position + flag);
         return table;

      }
   }
}
