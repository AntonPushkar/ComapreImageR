package Model;

import Entities.Image;
import java.util.ArrayList;


public class HammingDistance {

  public static void HammDist(ArrayList<Image> images) {

    int HammingDistance = 0;
    int Resolution = WorkOnTheImages.getScaledHeight() * WorkOnTheImages.getScaledWidth();

    for(int i=0; i<images.size(); i++)
    {
      Image first = images.get(i);
      for(int j=0; j<images.size(); j++)
      {
        Image second = images.get(j);
        if(first.getPath().equals(second.getPath())) continue;

        for(int k=0; k<Resolution; k++)
        {
          if(first.getBitcode().charAt(k)!=second.getBitcode().charAt(k))
            HammingDistance++;
        }

        if(HammingDistance ==0 || HammingDistance<5)
        {
          if(first.getResolution() >= second.getResolution())
          {
            second.setUnique(false);
            images.remove(j);
            j--;
          }
        }

        HammingDistance=0;
      }
    }
  }
}
