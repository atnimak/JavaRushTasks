package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;
import com.sun.javafx.iio.ImageStorage;

/**
 * Created by Maxim on 28.03.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){

     if(type==ImageTypes.BMP) {
         return new BmpReader();
     } else if((type==ImageTypes.JPG)){
         return new JpgReader();
     }else if((type==(ImageTypes.PNG))){
         return new PngReader();

    /* }else if(!((type.equals(ImageTypes.BMP))&&((type.equals(ImageTypes.JPG)))&&(type.equals(ImageTypes.PNG)))){
         throw new IllegalArgumentException("Неизвестный тип картинки");*/
     }
     else {
         throw new IllegalArgumentException("Неизвестный тип картинки");
     }
    }

    /*public static ImageReader getImageReader(ImageTypes jpg) {
    }*/
}
