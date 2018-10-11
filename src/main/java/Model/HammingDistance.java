package Model;

import Entities.Image;
import java.util.ArrayList;


public class HammingDistance {

  public static void HammDist(ArrayList<Image> images) {

    int HammingDistance = 0;
    int Resolution = WorkOnTheImages.getScaledHeight() * WorkOnTheImages.getScaledWidth();

    for (int i = 0; i < images.size(); i++) {

      for (int j = 0; j < images.size(); j++) {
        if(images.get(i).getName().equals(images.get(j).getName()))
          continue;
        String BitCodeOne = images.get(i).getBitcode();
        String BitCodeTwo = images.get(j).getBitcode();


        for (int k = 0; k < Resolution; k++) {
          if (BitCodeOne.charAt(k) != BitCodeTwo.charAt(k))
            HammingDistance++;
        }

        if (HammingDistance == 0 || HammingDistance < 5) {
          if (images.get(i).getResolution() <= images.get(j).getResolution()) {
            images.get(i).setUnique(false);
            images.get(j).setUnique(true);
            images.remove(i);
            i--;
            continue;
          } else {
            images.get(i).setUnique(true);
            images.get(j).setUnique(false);
            images.remove(j);
            j--;
            continue;
          }
        }
        else
          images.get(i).setUnique(true);

        System.out.println(images.get(i).getName());
        System.out.println(images.get(i).isUnique());
        System.out.println(images.get(j).getName());
        System.out.println(images.get(j).isUnique());
        System.out.println("HammDist " + HammingDistance);
        System.out.println("_______________________________");
        HammingDistance = 0;
      }

    }
  }


}
