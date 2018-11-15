package es.ucm.gdv.pc;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana(int x, int y){
        super("GamePC");
        setSize(x,y);
        setIgnoreRepaint(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    private int _x;
    private int _y;

}
