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
    /*if(SelectFolderImages && SelectFolderToSave) {
      new DBImages().DeleteTableEntry();
      CompareImage.Controller.DirChooser.FileStart();
      FilesImages.DeleteFilesFromTmp();
      setProgressIndicatorCompare(true);
      setDisableCompareButton(true);*//*

    }

    if(!SelectFolderToSave)
      Alerts.NoChooseFolderToSave();
    if(!SelectFolderImages)
      Alerts.NoChooseFolderImage();*/

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



  public void CountNoneUniqueImages(int Count)
  {
    System.out.println("Count " + Count);
    if (CountNotUbiqueImage == null) {
      System.out.println("count label null");
    }
    //CountNotUbiqueImage.setText(CountNotUbiqueImage.getText() + Count);
  }

  public void setProgressIndicatorCompare(boolean Visible)
  {
    ProgressIndicatorCompare.setVisible(Visible);
  }

  public void setDisableCompareButton(boolean Disable)
  {
    compare.setDisable(Disable);
  }

  int countpress = 0;
}
