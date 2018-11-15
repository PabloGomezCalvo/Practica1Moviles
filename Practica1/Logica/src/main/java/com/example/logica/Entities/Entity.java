package com.example.logica.Entities;

import es.ucm.gdv.interfaces.Image;

public abstract class Entity {

    abstract void update();

    abstract Image getImage();

    public int get_posx() {
        return _posx;
    }

    public int get_posy() {
        return _posy;
    }

    public int get_width(){return _image.getWidth();}

    public int get_height(){return _image.getWidth();}

    protected Image _image;
    protected int _posx;
    protected int _posy;

}
