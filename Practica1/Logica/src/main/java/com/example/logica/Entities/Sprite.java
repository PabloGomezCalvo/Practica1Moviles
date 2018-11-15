package com.example.logica.Entities;

import es.ucm.gdv.interfaces.Image;
import es.ucm.gdv.interfaces.Graphics;
import es.ucm.gdv.interfaces.Rect;
import sun.security.provider.ConfigFile;

public class Sprite {

    public Sprite(Image image, Rect src){
        _src = src;
        _image = image;
    }

    public Sprite(String path, Rect src,Graphics g){
        _image = g.newImage(path);
        _src = src;
    }

    public void draw(Graphics g, Rect dest){
        g.drawImage(_image,dest,_src);
    }
    public Image get_image() {
        return _image;
    }

    public Rect get_src() {
        return _src;
    }

    Image _image;
    Rect _src;
}
