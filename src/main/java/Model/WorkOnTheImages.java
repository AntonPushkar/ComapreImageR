package Model;

import Entities.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import util.FilesFormat;

public class WorkOnTheImages
{
  private static final int ScaledWidth = 8;
  private static final int ScaledHeight = 8;


  public WorkOnTheImages()
  {
  }


  public synchronized void WorkImage(Image image)
  {
      try {
        File fileOfImage = new File(image.getPath());
        BufferedImage BuffImage = ImageIO.read(fileOfImage);
        image.setResolution(BuffImage.getHeight() * BuffImage.getWidth());

        BufferedImage outImage = new BufferedImage(ScaledWidth, ScaledHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = outImage.createGraphics();

        g2d.drawImage(BuffImage, 0, 0, Color.GRAY, null);

        g2d.drawImage(BuffImage, 0, 0, ScaledWidth, ScaledHeight, null);
        g2d.dispose();

        String formatNameWithOutPoint = FilesFormat.getFormatOfFile(fileOfImage.getName()).replace(".", "");

        String outName = Thread.currentThread().getName() + fileOfImage.getName();
        if(!Files.exists(Paths.get("tmpImages")))
          Files.createDirectory(Paths.get("tmpImages"));

        String newPathForImage = "tmpImages\\"+outName;

        image.setPathOfEditedImage(newPathForImage);

        ImageIO.write(outImage, formatNameWithOutPoint, new File(newPathForImage));
        // clear the resource of memory
        g2d.setBackground(new Color(0,0,0,0));
        g2d.clearRect(0,0, BuffImage.getWidth(), BuffImage.getHeight());
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
  }


  public synchronized String HashOfImage(String ImagePath) {

    File input = new File(ImagePath);
    String BitCode = "0";
    try {
      BufferedImage image = ImageIO.read(input);
      Graphics2D g2d = image.createGraphics();
      Long average;
      Long sumPixel = 0L;

      int resolution = ScaledHeight * ScaledWidth;

      ArrayList<Integer> ListHash = new ArrayList<>();
      for (int i = 0; i < image.getWidth(); i++)
        for (int j = 0; j < image.getHeight(); j++)
          sumPixel += image.getRGB(i, j);

      average = sumPixel / resolution;

      for (int i = 0; i < image.getWidth(); i++) {

        for (int j = 0; j < image.getHeight(); j++) {
          if (image.getRGB(i, j) < average)
            ListHash.add(0);
          else if (image.getRGB(i, j) >= average)
            ListHash.add(1);
        }

      }

      StringBuilder hash = new StringBuilder();

      for (int x : ListHash)
        hash.append(x);
      ListHash.clear();
      BitCode = String.valueOf(hash);

      g2d.setBackground(new Color(0, 0, 0, 0));
      g2d.clearRect(0, 0, image.getWidth(), image.getHeight());

      return BitCode;
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return BitCode;
  }

  public static int getScaledHeight() {
    return ScaledHeight;
  }

  public static int getScaledWidth() {
    return ScaledWidth;
  }
}
