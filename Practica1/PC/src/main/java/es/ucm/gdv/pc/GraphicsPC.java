package es.ucm.gdv.pc;
import es.ucm.gdv.interfaces.Graphics;
import es.ucm.gdv.interfaces.Image;

import java.awt.Color;
import java.io.*;

public class GraphicsPC implements Graphics{
    public GraphicsPC(int width, int height, Ventana ventana){
        _height = height;
        _width = width;
        _ventana = ventana;
    }
    public Image newImage(String name){
        ImagePC image = null;
        try {
            java.awt.image.BufferedImage awtImage = javax.imageio.ImageIO.read(new java.io.File(name));
             image = new ImagePC(awtImage);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        return image;
    }
    public void initGraphics(){
        _ventana.createBufferStrategy(2);
        _buffer = _ventana.getBufferStrategy();
        _g = _buffer.getDrawGraphics();

    }
    public void clear(int color){
        _g.setColor(new Color(color));
        _g.fillRect(0, 0, getWidth(), getHeight());
    }
    public void drawImage(Image image,int x, int y){//dibuja en la pos x e y la imagen dada
        _g.drawImage((java.awt.image.BufferedImage)image,x,y,null);
    }
    public void present(){
        _g = _ventana.getGraphics();
        do {
            do {
                _g.dispose();
            } while (_buffer.contentsRestored());
            _buffer.show();
            _g = _buffer.getDrawGraphics();
        }while(_buffer.contentsLost());
    }
    public int getWidth(){
        return _width;
    }
    public int getHeight(){
        return _height;
    }
    //ancho y alto de la pantalla
    private int _width;
    private int _height;
    //guardamos el graphics de la pantalla
    private java.awt.Graphics _g;
    private java.awt.image.BufferStrategy _buffer;
    public Ventana _ventana;
}
