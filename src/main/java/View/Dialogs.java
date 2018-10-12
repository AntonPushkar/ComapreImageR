package View;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Dialogs
{
  private static Alert alert;
  public static void AlertImage(String text)
  {
    alert = new Alert(AlertType.WARNING);
    alert.setTitle("Warning!");
    alert.setHeaderText(text);
    alert.setContentText(null);
    alert.showAndWait();
  }

  public static void Done()
  {
    alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information");
    alert.setHeaderText("Compare has done!");
    alert.showAndWait();
  }
}
