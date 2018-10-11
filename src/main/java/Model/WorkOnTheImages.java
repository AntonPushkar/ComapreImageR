package Model;

import Entities.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

  public static int getScaledHeight() {
    return ScaledHeight;
  }

  public static int getScaledWidth() {
    return ScaledWidth;
  }
}
