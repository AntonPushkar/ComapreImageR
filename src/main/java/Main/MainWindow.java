package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application
{

  public void start(Stage Stage){
    try {
      Parent root = FXMLLoader.load(getClass().getResource("/MainView.fxml"));
      Stage.setScene(new Scene(root, 394, 150));

      Stage.setResizable(false);
      Stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
