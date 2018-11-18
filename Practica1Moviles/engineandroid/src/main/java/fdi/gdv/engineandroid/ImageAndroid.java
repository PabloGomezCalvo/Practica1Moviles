package fdi.gdv.engineandroid;

import android.graphics.Bitmap;
import fdi.gdv.engine.*;
public class ImageAndroid implements Image {
    private Bitmap _sprite;

    public ImageAndroid(Bitmap sprite){
        _sprite = sprite;
    }
    @Override
    public int getHeight() {
        return _sprite.getHeight();
    }

    public Bitmap getBitmap(){
        return _sprite;
    }
    @Override
    public int getWidth() {
        return _sprite.getWidth();
    }




}