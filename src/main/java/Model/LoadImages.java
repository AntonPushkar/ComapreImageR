package Model;

import View.FileChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadImages
{

  public void getFiles()
   {
      boolean AllowedFile;
      String pathes[] = FileChooser.getPathes().toArray(new String[FileChooser.getPathes().size()]);
     System.out.println(pathes.length);
      File[] files = null;
      ArrayList<File> allListFiles = new ArrayList<>();
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
