package com.example.logica;

import es.ucm.gdv.interfaces.Image;

public class Tower {
    public Tower(Image image, int salud, int x,int y){
        _salud = salud;
        _image = image;
        _posx = x;
        _posy = y;
    }

    public void set_salud(int _salud) {
        this._salud = _salud;
    }

    public int get_salud() {
        return _salud;
    }


    public int get_posx() {
        return _posx;
    }

    public int get_posy() {
        return _posy;
    }

    public Image get_image() {
        return _image;
    }

    private Image _image;
    private int _posx;
    private int _posy;
    private int _salud;
}
