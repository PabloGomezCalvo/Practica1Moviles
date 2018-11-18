package fdi.gdv.enginepc;


import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import fdi.gdv.engine.*;
public class GraphicsPC implements Graphics {


    public GraphicsPC(JFrame frame) {
        this._height = 720;
        this._width = 1280;
        this._ventana = frame;
        this._ventana.setSize(_width, _height);
        this._ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this._ventana.setUndecorated(true);
        this._ventana.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-_width/2, (Toolkit.getDefaultToolkit().getScreenSize().height/2)-_height/2);
        this._ventana.setVisible(true);
        _ventana.createBufferStrategy(2);
        this._strategy = _ventana.getBufferStrategy();
        this._awtGraphics = _ventana.getBufferStrategy().getDrawGraphics();

    }

    @Override
    public void clear(int color) {
        _ventana.getBufferStrategy().getDrawGraphics();
        _awtGraphics.setColor(new Color(color));
        _awtGraphics.fillRect(0,0,_ventana.getWidth(), _ventana.getHeight());
    }



    @Override
    public boolean drawImage(Image im, Rect dest, Rect source) {
        ImagePC temp = (ImagePC)im;

        _ventana.getBufferStrategy().getDrawGraphics().drawImage(
                temp.get_AwtImage(),
                dest.get_x(),
                dest.get_y(),
                dest.get_x()+dest.get_width(),
                dest.get_y()+dest.get_height(),
                source.get_x(),
                source.get_y(),
                source.get_x()+source.get_width(),
                source.get_y()+source.get_height(),
                null);
        return true;
    }
    @Override
    public ImagePC newImage(String name) {
        try {
            java.awt.Image temp = ImageIO.read(new java.io.File(name));
            return new ImagePC(temp);
        }
        catch(Exception e){
            System.out.print(e);
        }
        return null;
    }

    public void present(){
        do {
            do {
                _awtGraphics.dispose();
            } while (_strategy.contentsRestored());
            // We show the buffer we had stored
            _strategy.show();
            //And then change the pointer to the new buffer in which the program will draw
            _awtGraphics = _strategy.getDrawGraphics();
        }while(_strategy.contentsLost());
    }
    @Override
    public int getWidth() {
        return _ventana.getWidth();
    }

    @Override
    public int getHeight() {
        return _ventana.getHeight();
    }
    java.awt.Graphics _awtGraphics;
    BufferStrategy _strategy;
    JFrame _ventana;
    int _width;
    int _height;
}
