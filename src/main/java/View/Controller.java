package View;

import Main.BaseClass;
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
    if(DirChooser.getPathes()!=null)
      SelectFolderImages=true;
  }

  @FXML
  public void ButtonSaveTo(ActionEvent event)
  {
    DirChooser.ChooseDirForSaveImages();
    if(DirChooser.getPathToSave()!=null)
      SelectFolderToSave=true;
  }

  @FXML
  public void CompareButton(ActionEvent event)
  {
    if(SelectFolderImages == false) {
      Dialogs.AlertImage("Didn't select directory of images");
      return;
    }
    if(SelectFolderToSave == false) {
      Dialogs.AlertImage("Didn't select directory to save images ");
      return;
    }
    new Thread( () -> new BaseClass().CompareImage()).start();
  }



  public static void setSelectFolderToSave(boolean selectFolder) {
    SelectFolderToSave = selectFolder;
  }

  public static void setSelectFolderImages(boolean selectFolderImages) {
    SelectFolderImages = selectFolderImages;
  }

}
