package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;
import javassist.compiler.ast.Visitor;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  /*@param rootDirectory the directory where to start the traversal
   * @param vistor defines the operation to be performed on each file
  */
  public void explore(File rootDirectory, IFileVisitor vistor) {
 
    File[] myList = rootDirectory.listFiles();
    vistor.visit(rootDirectory);
 
     
     if (myList != null){
   
       // if this is a file we should visit it
       for (File f: myList){
          if (f.isFile())
             vistor.visit(f);  
       }
       //  if this is a flder we shoud explore this
       for (File d: myList){
          if (d.isDirectory())
             explore(d,vistor);  
       }    
       
    }
    
    
  }
   
}