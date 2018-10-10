package View;

import LoadImages.LoadImages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class Controller
{
  @FXML
  private Button Path1;
  @FXML
  private Button compare;
  @FXML
  private Button setting;
  @FXML
  private ProgressIndicator ProgressIndicatorCompare;
  @FXML
  private Label CountNotUbiqueImage;


  private static boolean SelectFolderToSave = false;

  private static boolean SelectFolderImages = false;

  @FXML
  public void ButtonPathes(ActionEvent event)
  {
    DirChooser.ChooseDirOfImage();
  }

  @FXML
  public void CompareButton(ActionEvent event)
  {


    LoadImages loadImages = new LoadImages();
    loadImages.getFiles();

  }

  @FXML
  public void ButtonSettings(ActionEvent event)
  {
    /*MainSettings mainSettings = new MainSettings();
    mainSettings.SettingsWindow();*/
  }


  public static void setSelectFolder(boolean selectFolder) {
    SelectFolderToSave = selectFolder;
  }

  public static void setSelectFolderImages(boolean selectFolderImages) {
    SelectFolderImages = selectFolderImages;
  }

}
