package com.example.logica.Entities;

import es.ucm.gdv.interfaces.Image;

public class Bomb extends Entity{
    public Bomb(Image image, int x, int y){
        _image = image;
        _posy = y;
        _posx = x;
    }
    public void update(){
        _posy -= 1;
    }

    public Image getImage() {
        return _image;
    }

}
