package com.example.logica;
import es.ucm.gdv.interfaces.Image;

public class Plane {
    public Plane(Image imagePlane,Image imageBomb, int x, int y){
        _image = imagePlane;
        _imageBomb = imageBomb;
        _posx = x;
        _posy = y;
    }

    public void move(){
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

    public int get_posx() {
        return _posx;
    }

    public int get_posy() {
        return _posy;
    }

    public Image get_image() {
        return _image;
    }

    private int _posx;
    private int _posy;
    private Image _image;
    private Image _imageBomb;
}
