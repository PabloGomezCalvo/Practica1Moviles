package com.example.android;

import es.ucm.gdv.interfaces.Graphics;
import es.ucm.gdv.interfaces.Image;
import es.ucm.gdv.interfaces.Rect;


import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;



public class GraphiscAndroid implements Graphics{
    public GraphiscAndroid(SurfaceView surfaceView,AssetManager assetManager){
        _surfaceView = surfaceView;
        _surfaceHolder = surfaceView.getHolder();
        _assetManager = assetManager;
    }
    @Override
    public Image newImage(String name) {
        Bitmap image;
        ImageAndroid imageAndroid = null;
        try{
            InputStream inputStream = _assetManager.open(name);
            image = BitmapFactory.decodeStream(inputStream);
            imageAndroid = new ImageAndroid(image);
            inputStream.close();
        }catch (IOException e){

        }


        return imageAndroid;
    }

    @Override
    public int getHeight() {
        return _surfaceView.getHeight();
    }

    @Override
    public int getWidth() {
        return _surfaceView.getWidth();
    }

    @Override
    public void clear(int color) {
        while (!_surfaceHolder.getSurface().isValid());
        _canvas = _surfaceHolder.lockCanvas();
        _canvas.drawColor(0xFFFFFFFF);
    }

    @Override
    public void drawImage(Image image, Rect x, Rect y) {

        android.graphics.Rect xx = new android.graphics.Rect(
                x.get_x(),
                x.get_y(),
                x.get_x()+x.get_width(),
                x.get_y()+x.get_height());

        android.graphics.Rect yy = new android.graphics.Rect(
                y.get_x(),
                y.get_y(),
                y.get_x()+y.get_width(),
                y.get_y()+y.get_height());

        _canvas.drawBitmap(((ImageAndroid) image).getBitmap(),xx,yy,null);
    }

    @Override
    public void present() {
        _surfaceHolder.unlockCanvasAndPost(_canvas);
    }

    private SurfaceView _surfaceView;
    private AssetManager _assetManager;
    private SurfaceHolder _surfaceHolder;
    private Canvas _canvas;
}
