package com.example.logica;

import es.ucm.gdv.interfaces.Image;

public class Bomb {
    public Bomb(Image image, int x, int y){
        _image = image;
        _posy = y;
        _posx = x;
    }
    public void move(){
        _posy -= 1;
    }

    public Image get_image() {
        return _image;
    }

    public int get_posx() {
        return _posx;
    }

    public int get_posy() {
        return _posy;
    }

    private Image _image;
    private int _posx;
    private int _posy;

}
