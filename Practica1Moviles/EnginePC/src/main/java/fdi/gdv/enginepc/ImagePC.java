package fdi.gdv.enginepc;

import fdi.gdv.engine.*;
public class ImagePC implements Image {
    public ImagePC(java.awt.Image img) {
        this._image = img;
    }


    public java.awt.Image get_AwtImage() {
        return _image;
    }

    @Override
    public int getWidth() { return _image.getWidth(null); }
    @Override
    public int getHeight() {
        return _image.getHeight(null);
    }
    java.awt.Image _image;
}
