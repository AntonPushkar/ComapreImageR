package Model;

import Entities.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HashBit
{
  public synchronized void HashOfImage(Image image) {
    File input = new File(image.getPathOfEditedImage());
    String BitCode = "0";
    try {
      BufferedImage buffImage = ImageIO.read(input);
      Graphics2D g2d = buffImage.createGraphics();
      Long average;
      Long sumPixel = 0L;

      int resolution = WorkOnTheImages.getScaledHeight() * WorkOnTheImages.getScaledWidth();

      for (int i = 0; i < buffImage.getWidth(); i++)
        for (int j = 0; j < buffImage.getHeight(); j++)
          sumPixel += buffImage.getRGB(i, j);

      average = sumPixel / resolution;
      StringBuilder hash = new StringBuilder();


      for (int i = 0; i < buffImage.getWidth(); i++) {

        for (int j = 0; j < buffImage.getHeight(); j++) {
          if (buffImage.getRGB(i, j) < average)
            hash.append(0);
          else if (buffImage.getRGB(i, j) >= average)
            hash.append(1);
        }

      }
      image.setBitcode(String.valueOf(hash));
      g2d.setBackground(new Color(0, 0, 0, 0));
      g2d.clearRect(0, 0, buffImage.getWidth(), buffImage.getHeight());

    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
