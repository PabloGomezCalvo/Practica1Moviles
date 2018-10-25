package es.ucm.gdv.pc;
import es.ucm.gdv.interfaces.Image;

public class ImagePC implements Image {
    public ImagePC(java.awt.image.BufferedImage image){
        _image = image;
    }
    public int getWidth(){
        return _image.getWidth();
    }
    public int getHeight(){
        return _image.getHeight();
    }
    java.awt.image.BufferedImage _image;
}
