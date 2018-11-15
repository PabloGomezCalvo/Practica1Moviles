package com.example.android;

import es.ucm.gdv.interfaces.Image;
import android.graphics.Bitmap;

public class ImageAndroid implements Image{
    public ImageAndroid(Bitmap bitmap){
        _bitmap = bitmap;
    }

    @Override
    public int getWidth() {
        return _bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return _bitmap.getHeight();
    }

    public Bitmap getBitmap(){
        return _bitmap;
    }

    private Bitmap _bitmap;
}
