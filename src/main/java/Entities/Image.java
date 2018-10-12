package Entities;

import Model.WorkOnTheImages;

public class Image
{
  private final String name;
  private final String path;
  private String pathOfEditedImage;
  private String bitcode;
  private boolean unique = true;
  private int Resolution;


  public Image(String name, String path)
  {
    this.name = name;
    this.path = path;
  }


  public String getName() {
    return name;
  }

  public String getPath() {
    return path;
  }

  public String getPathOfEditedImage() {
    return pathOfEditedImage;
  }

  public void setPathOfEditedImage(String pathOfEditedImage) {
    this.pathOfEditedImage = pathOfEditedImage;
  }

  public String getBitcode() {
    return bitcode;
  }

  public void setBitcode(String bitcode) {
    this.bitcode = bitcode;
  }

  public boolean isUnique() {
    return unique;
  }

  public void setUnique(boolean unique) {
    this.unique = unique;
  }

  public int getResolution() {
    return Resolution;
  }

  public void setResolution(int resolution) {
    Resolution = resolution;
  }
}
