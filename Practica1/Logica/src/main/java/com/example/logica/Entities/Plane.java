package com.example.logica.Entities;

import es.ucm.gdv.interfaces.Image;

public class Plane extends Entity {
    public Plane(Image imagePlane,Image imageBomb, int x, int y){
        _image = imagePlane;
        _imageBomb = imageBomb;
        _posx = x;
        _posy = y;
    }

    public void update(){
        if(_posx + 1 == 17) {
            _posy -= 1;
            _posx = 1;
        }
        else{
            _posx += 1;
        }
    }

    public Bomb generateBomb(){
        Bomb bomba = new Bomb(_imageBomb,_posx,_posy-1);
        return bomba;
    }

    public boolean endReached(){
        return (_posy == 22);
    }

    public Image getImage() {
        return _image;
    }

    private Image _imageBomb;
}
