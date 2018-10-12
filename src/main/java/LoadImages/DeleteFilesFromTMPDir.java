package LoadImages;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteFilesFromTMPDir
{
  public static void DeleteFilesFromTmp() {
    if (Files.exists(Paths.get("tmpImages"))) {
      String Path = "tmpImages";

      for (File file : new File(Path).listFiles())
        if (file.isFile())
          file.delete();
    }
  }
}
