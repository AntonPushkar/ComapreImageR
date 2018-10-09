package LoadImages;

import Entities.Image;
import View.DirChooser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class CopyImages
{
  public static void Copy()
  {
    String FolderForCopy = DirChooser.getPathToSave();
    if(FolderForCopy == null)
      throw new NullPointerException("Folder for copy is null!");
    ArrayList<Image> listOfImages = LoadImages.getlistOfImages();
    if(listOfImages == null || listOfImages.isEmpty())
      throw new NullPointerException("List Of Images for copy is null or empty!");


    Path ToCopy;
    Path originalPath;

    for(Image x: listOfImages)
    {
      ToCopy = Paths.get(FolderForCopy + "\\"+x.getName());
      originalPath = Paths.get(x.getPath());

      if(!Files.exists(Paths.get(FolderForCopy))) {
        try {
          Files.createDirectory(Paths.get(FolderForCopy));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      try {
        Files.copy(originalPath, ToCopy, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
      } catch (IOException e) {
        e.printStackTrace();
      }


    }

  }
}
