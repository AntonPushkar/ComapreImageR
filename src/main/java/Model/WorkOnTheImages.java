package Model;

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
  private int ScaledWidth = 8;
  private int ScaledHeight = 8;


  public WorkOnTheImages()
  {
  }


  private synchronized void WorkImage(File FileImage)
  {
      try {
        File inputImage = FileImage;
        BufferedImage BuffImage = ImageIO.read(inputImage);

        BufferedImage outImage = new BufferedImage(ScaledWidth, ScaledHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = outImage.createGraphics();

        g2d.drawImage(BuffImage, 0, 0, Color.GRAY, null);

        g2d.drawImage(BuffImage, 0, 0, ScaledWidth, ScaledHeight, null);
        g2d.dispose();

        String formatNameWithOutPoint = FilesFormat.getFormatOfFile(FileImage.getName()).replace(".", "");

        String outName = Thread.currentThread().getName() + FileImage.getName();
        if(!Files.exists(Paths.get("tmpImages")))
          Files.createDirectory(Paths.get("tmpImages"));

        String newPathForImage = "tmpImages\\"+outName;


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



  private synchronized void HashOfImage(Graphics2D image)
  {

    long average;
    long sumPixel = 0L;

  }

}
