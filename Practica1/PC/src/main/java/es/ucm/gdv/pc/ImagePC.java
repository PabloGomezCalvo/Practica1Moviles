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
    public java.awt.image.BufferedImage getAwtImage(){return _image;}
    java.awt.image.BufferedImage _image;
}
