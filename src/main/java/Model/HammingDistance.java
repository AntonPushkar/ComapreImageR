package Model;

import Entities.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class HammingDistance
{
  public static void HammDist(ArrayList<Image> images)
  {
    int HammingDistance = 0;
    int Resolution = WorkOnTheImages.getScaledHeight() * WorkOnTheImages.getScaledWidth();



  }

  public static int CompareImages(Image imageOne, Image imageTwo)
  {
    return imageOne.getResolution() - imageTwo.getResolution();
  }
}
