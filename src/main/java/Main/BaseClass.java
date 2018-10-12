package Main;


import Entities.Image;
import LoadImages.*;
import Model.HammingDistance;
import Model.HashBit;
import Model.WorkOnTheImages;
import View.Controller;
import View.Dialogs;
import View.DirChooser;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;

public class BaseClass
{
  public void CompareImage()
  {
    System.out.println(Class.class.getName());
    ArrayList<Image> images = new LoadImages().LoadFiles(DirChooser.getPathes());
    System.out.println(images.size()+  " Size ");
    WorkOnTheImages workOnTheImages = new WorkOnTheImages();
    ExecutorService execWorkOnImage = Executors.newFixedThreadPool(5);
    ExecutorService execCalcBitCode = Executors.newFixedThreadPool(5);
    HashBit bit = new HashBit();

    for(int i=0; i<images.size(); i++) {
      Image image = images.get(i);
      execWorkOnImage.execute(() -> workOnTheImages.WorkImage(image));
    }

    execWorkOnImage.shutdown();
    while (!execWorkOnImage.isTerminated());

    for(int i=0; i<images.size(); i++) {
      Image image = images.get(i);
      execCalcBitCode.execute(() -> bit.HashOfImage(image));
    }

    execCalcBitCode.shutdown();
    while (!execCalcBitCode.isTerminated());
    HammingDistance.HammDist(images);
    DeleteFilesFromTMPDir.DeleteFilesFromTmp();
    CopyImages.Copy(images);

    Controller.setSelectFolderToSave(false);
    Controller.setSelectFolderImages(false);

    Platform.runLater(()-> Dialogs.Done());

  }
}
