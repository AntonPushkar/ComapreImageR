package View;

import java.io.File;
import java.util.ArrayList;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DirChooser
{
  private static ArrayList<String> pathes = new ArrayList<>();
  private static int numOfDirectories = 1;
  private static Stage stage = new Stage();
  private static DirectoryChooser chooser = new DirectoryChooser();
  private static String pathToSave;

  public static void ChooseDirOfImage()
  {
    String nameTitle = "Выбор директории №" + String.valueOf(numOfDirectories)  +" с фото";

    chooser.setTitle(nameTitle);
    if(pathes.isEmpty())
      chooser.setInitialDirectory(new File(System.getProperty("user.home")));
    else chooser.setInitialDirectory(new File(pathes.get(pathes.size()-1)));
    // -1 because numOfDirectories is count for title, i am use it for index at array
    pathes.add(String.valueOf(chooser.showDialog(stage)));
  }

  public static ArrayList<String> getPathes()
  {
    return pathes;
  }

  public static void ChooseDirForSaveImages()
  {
    String nameTitle = "Директория для сохранения изображений";
    chooser.setTitle(nameTitle);
    chooser.setInitialDirectory(new File(pathes.get(pathes.size()-1)));
    pathToSave = String.valueOf(chooser.showDialog(stage));
  }

  public static String getPathToSave()
  {
    return pathToSave;
  }


}
