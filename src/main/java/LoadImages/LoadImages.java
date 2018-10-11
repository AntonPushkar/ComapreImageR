package LoadImages;

import Entities.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import util.FilesFormat;

public class LoadImages
{
  static private final ArrayList<Image> listOfImages = new ArrayList<>();

  public ArrayList<Image> LoadFiles(ArrayList<String> pathes)
   {
     System.out.println(LoadImages.class.getName());
      ArrayList<File> allListFiles = new ArrayList<>();
      boolean AllowedFile;
      System.out.println(pathes.size());
      File[] files = null;

      for(String x : pathes) {
        files = new File(x).listFiles();
      }

      allListFiles.addAll(Arrays.asList(files));

      for(int i=0; i<allListFiles.size(); i++)
      {
        AllowedFile = FilesFormat.isFileAllowed(allListFiles.get(i));

        if(!AllowedFile) {
          System.out.println(allListFiles.get(i) + " remove");
          allListFiles.remove(i);
          //when we use remove in ArrayList index get possition i-1;
          i--;
        }
      }

      // Create image objects
      for(File x : allListFiles)
        listOfImages.add(new Image(x.getName(), x.getPath()));
     return listOfImages;
   }


  public static ArrayList<Image> getlistOfImages() {
    return listOfImages;
  }

}
