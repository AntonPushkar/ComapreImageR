package util;

public class FilesFormat
{
  
  public static String getFormatOfFile(String fileName)
  {
    int IndexExtension = fileName.lastIndexOf('.');

    String AllowedExtension = fileName.substring(IndexExtension);

    return AllowedExtension;
  }
}
