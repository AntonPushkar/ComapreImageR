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
  public static void Copy(ArrayList<Image> images)
  {
    String FolderForCopy = DirChooser.getPathToSave();
    if(FolderForCopy == null)
      throw new NullPointerException("Folder for copy is null!");
    if(images == null || images.isEmpty())
      throw new NullPointerException("List Of Images for copy is null or empty!");


    Path ToCopy;
    Path originalPath;

    for(Image x: images)
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
