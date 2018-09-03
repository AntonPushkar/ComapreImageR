package View;

import java.io.File;
import java.util.ArrayList;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class FileChooser
{
  private static ArrayList<String> pathes = new ArrayList<>();
  private static int numOfDirectories = 1;

  public static void ChooseDiroFImage()
  {
    String nameTitle = "Выбор директории №" + String.valueOf(numOfDirectories)  +" с фото";

    Stage stage = new Stage();
    DirectoryChooser chooser = new DirectoryChooser();
    chooser.setTitle(nameTitle);
    chooser.setInitialDirectory(new File(System.getProperty("user.home")));
    // -1 because numOfDirectories is count for title, i am use it for index at array
    pathes.add(String.valueOf(chooser.showDialog(stage)));
  }

  public ArrayList<String> getPathes()
  {
    return pathes;
  }



}
