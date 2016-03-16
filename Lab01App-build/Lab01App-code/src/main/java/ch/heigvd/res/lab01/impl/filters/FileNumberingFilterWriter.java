package ch.heigvd.res.lab01.impl.filters;

import ch.heigvd.res.lab01.impl.Utils;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

/**
 * This class transforms the streams of character sent to the decorated writer. When
 * filter encounters a line separator, it sends it to the decorated writer. It then
 * sends the line number and a tab character, before resuming the write process.
 *
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */




public class FileNumberingFilterWriter extends FilterWriter {

   boolean first_time = true;
   int nmbrLigne=1;
   boolean first_char = true;
   boolean next_char = false;
   int prev_char = '0';
   
   
   private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());
   

   public FileNumberingFilterWriter(Writer out) {
      super(out);
   }

   @Override
   public void write(String str, int off, int len) throws IOException {
      str = str.substring(off, off + len);
         
      String[] temp = Utils.getNextLine(str);      
      // write ligne's number only for the first time
      if (first_time) {
         out.write(nmbrLigne + "\t");
         first_time = false;
      }
            
      if (temp[0] == "") {
         out.write(temp[1]);
      }
      else if (temp[1] == "") {
         nmbrLigne++;
      out.write(temp[0]+ nmbrLigne + "\t");
      }
      else {
         nmbrLigne++;
         out.write(temp[0] + nmbrLigne+ "\t");
         this.write(temp[1]);
      }
    }


@Override
        public void write(char[] cbuf, int off, int len) throws IOException {
   write (new String (cbuf), off,len);
}

  @Override
        public void write(int c) throws IOException {
        
         char temp = (char)c;
          // next line mac
         if (temp == '\r') {            
            next_char= true;
            return;
         }
                
   
        if(next_char){
            //  if the current char is a \n we have to deal with windows EOF.
            if(temp == '\n'){
                nmbrLigne ++;
                out.write("\r\n" + nmbrLigne + "\t");
                next_char = false;
            }// If it was a false alarm write the last \r and the current
             // char.
            else{
                nmbrLigne++;
                out.write("\r" + nmbrLigne + "\t" +temp);
                next_char = false; 
            }
        }
        else{
            this.write(Character.toString(temp));
            next_char = false;
        }
        
        }   
        
        
  }