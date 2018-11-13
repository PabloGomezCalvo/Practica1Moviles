package com.example.logica.Entities;

import es.ucm.gdv.interfaces.Image;

public class Tower extends Entity{
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

    public Image getImage() {
        return _image;
    }

    public void update(){}

    private int _salud;
}
