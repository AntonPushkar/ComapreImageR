package Model;

import View.DirChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import util.FilesFormat;

public class LoadImages
{
  static private ArrayList<File> allListFiles = new ArrayList<>();
  public void getFiles()
   {
      boolean AllowedFile;
      String pathes[] = DirChooser.getPathes().toArray(new String[DirChooser.getPathes().size()]);
      System.out.println(pathes.length);
      File[] files = null;

      for(String x : pathes) {
        System.out.println("In ForEach " + x);
        files = new File(x).listFiles();
      }

      allListFiles.addAll(Arrays.asList(files));

      for(int i=0; i<allListFiles.size(); i++)
      {
        AllowedFile = isFileAllowed(allListFiles.get(i));

        if(!AllowedFile) {
          System.out.println(allListFiles.get(i) + " remove");
          allListFiles.remove(i);
        }

        i--; //when we use remove in ArrayList index get possition i-1;
      }

     System.out.println("Size listFiles " + allListFiles.size());
   }


   private boolean isFileAllowed(File file)
   {
      boolean isFileAllowed = false;

      if(file.isDirectory())
        return false;

      String[] FileType = {".jpg", ".png", ".jpeg", ".raw"};



     String AllowedExtension = FilesFormat.getFormatOfFile(file.getName());

     for(String aFileType : FileType)
     {
       if(AllowedExtension.equals(aFileType) || AllowedExtension.equalsIgnoreCase(aFileType))
         isFileAllowed = true;
     }
     return isFileAllowed;
   }

  public static ArrayList<File> getAllListFiles() {
    return allListFiles;
  }
}
