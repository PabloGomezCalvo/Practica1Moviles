package es.ucm.gdv.interfaces;

public class Rect {
    public Rect(int _x, int _y, int _width, int _height) {
        this._x = _x;
        this._y = _y;
        this._width = _width;
        this._height = _height;
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public int get_width() {
        return _width;
    }

    public int get_height() {
        return _height;
    }

    int _x;
    int _y;
    int _width;
    int _height;
}
