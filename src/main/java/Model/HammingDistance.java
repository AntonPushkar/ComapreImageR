package Model;

import Entities.Image;
import java.util.ArrayList;


public class HammingDistance {

  public static void HammDist(ArrayList<Image> images) {
    int HammingDistance = 0;
    int Resolution = WorkOnTheImages.getScaledHeight() * WorkOnTheImages.getScaledWidth();

    for(int i=0; i<images.size(); i++)
    {
      //Because the latest element
      if(i==images.size()-1) break;

      String BitCodeOne = images.get(i).getBitcode();
      String BitCodeTwo = images.get(i+1).getBitcode();

      for(int j=0; j<Resolution; j++)
      {
        if(BitCodeOne.charAt(j) != BitCodeTwo.charAt(j))
          HammingDistance++;
      }
      if(HammingDistance == 0 || HammingDistance < 5)
      {
        if(images.get(i).getResolution() > images.get(i+1).getResolution()) {
          images.get(i).setUnique(true);
          images.get(i + 1).setUnique(false);
        }
        else {
          images.get(i).setUnique(false);
          images.get(i + 1).setUnique(true);
        }
      }

      else images.get(i).setUnique(true);
      HammingDistance = 0;
    }

  }


}
