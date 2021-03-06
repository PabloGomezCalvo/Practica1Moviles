package fdi.gdv.engineandroid;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import fdi.gdv.engine.*;
import static android.content.ContentValues.TAG;

public class GraphicsAndroid implements Graphics  {
    private SurfaceHolder surfaceHolder_;
    private Canvas currentCanvas_;
    private SurfaceView surfaceView_;
    private AssetManager assetManager_;

    public GraphicsAndroid(SurfaceView surfaceView,AssetManager assetManager){
        assetManager_ = assetManager;
        surfaceView_ = surfaceView;
        surfaceHolder_ = surfaceView_.getHolder();
        surfaceView.setVisibility(View.VISIBLE);


    }

    @Override
    public Image newImage(String name) {
        ImageAndroid img = null;
        Bitmap sprite_ ;

        try {
            InputStream inputStream = assetManager_.open(name);
            sprite_ = BitmapFactory.decodeStream(inputStream);
            img = new ImageAndroid(sprite_);
            inputStream.close();
        }catch (IOException e){
            Log.d(TAG, "newImage: "+ e.getMessage());

        }
        return img;
    }




    @Override
    public boolean drawImage(Image im, Rect dest, Rect source) {
        android.graphics.Rect dest2 = new android.graphics.Rect(
                dest.get_x(),
                dest.get_y(),
                dest.get_x()+dest.get_width(),
                dest.get_y()+dest.get_height());
        android.graphics.Rect src2 = new android.graphics.Rect(
                source.get_x(),
                source.get_y(),
                source.get_x()+source.get_width(),
                source.get_y()+source.get_height());

        ImageAndroid img = (ImageAndroid) im;

        currentCanvas_.drawBitmap(img.getBitmap(),src2,dest2,null);
        return true;
    }



    @Override
    public void present() {
        surfaceHolder_.unlockCanvasAndPost(currentCanvas_);



    }
    @Override
    public int getWidth() {
        return surfaceView_.getWidth();
    }
    @Override
    public int getHeight() {
        return surfaceView_.getHeight();
    }
    @Override
    public void clear(int color) {

        while (!surfaceHolder_.getSurface().isValid()){}
        currentCanvas_ = surfaceHolder_.lockCanvas();

        currentCanvas_.drawColor(color);


    }
}

