package Model;

import View.FileChooser;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadImages
{

   void getFiles()
   {
      boolean AllowedFile;
      String pathes[] = new String[new FileChooser().getPathes().size()];
      File[] files = null;
      ArrayList<File> allListFiles = new ArrayList<>();
      for(String x : pathes)
        files = new File(x).listFiles();

      allListFiles.addAll(Arrays.asList(files));

      for(int i=0; i<allListFiles.size(); i++)
      {
        AllowedFile = isFileAllowed(allListFiles.get(i));

        if(!AllowedFile)
          allListFiles.remove(i);

        i--; //when we use remove in ArrayList index get possition i-1;
      }
   }


   private boolean isFileAllowed(File file)
   {
      boolean isFileAllowed = false;

      if(file.isDirectory())
        return false;

      String[] FileType = {".jpg", ".png", ".jpeg", ".raw"};

     int IndexExtension = file.toString().lastIndexOf('.');

     String AllowedExtension = file.toString().substring(IndexExtension);

     for(String aFileType : FileType)
     {
       if(AllowedExtension.equals(aFileType) || AllowedExtension.equalsIgnoreCase(aFileType))
         isFileAllowed = true;
     }

     return isFileAllowed;
   }
}
