package LoadImages;

import Entities.Image;
import View.DirChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import util.FilesFormat;

public class LoadImages
{
  static private ArrayList<Image> listOfImages = new ArrayList<>();

  public void getFiles()
   {
      ArrayList<File> allListFiles = new ArrayList<>();
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
        AllowedFile = FilesFormat.isFileAllowed(allListFiles.get(i));

        if(!AllowedFile) {
          System.out.println(allListFiles.get(i) + " remove");
          allListFiles.remove(i);
        }
        i--; //when we use remove in ArrayList index get possition i-1;
      }

      // Create image objects
      for(File x : allListFiles)
        listOfImages.add(new Image(x.getName(), x.getPath()));

     System.out.println("Size listFiles " + allListFiles.size());
   }


  public static ArrayList<Image> getlistOfImages() {
    return listOfImages;
  }
}
