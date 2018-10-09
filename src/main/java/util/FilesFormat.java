package util;

import java.io.File;

public class FilesFormat
{
  
  public static String getFormatOfFile(String fileName)
  {
    int IndexExtension = fileName.lastIndexOf('.');

    String AllowedExtension = fileName.substring(IndexExtension);

    return AllowedExtension;
  }

  public static boolean isFileAllowed(File file)
  {
    boolean isFileAllowed = false;

    if(file.isDirectory())
      return false;

    String[] FileType = {".jpg", ".png", ".jpeg", ".raw"};



    String AllowedExtension = FilesFormat.getFormatOfFile(file.getName());

    for(String aFileType : FileType)
    {
      if(AllowedExtension.equals(aFileType) || AllowedExtension.equalsIgnoreCase(aFileType))
        isFileAllowed = true;
    }
    return isFileAllowed;
  }
}
