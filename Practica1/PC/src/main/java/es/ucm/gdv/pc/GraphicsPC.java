package es.ucm.gdv.pc;
import es.ucm.gdv.interfaces.Graphics;
import es.ucm.gdv.interfaces.Image;
import java.awt.*;
import java.io.*;

public class GraphicsPC implements Graphics{
    public GraphicsPC(int width, int height){
        _height = height;
        _width = width;
    }
    public void actualizaGraphisc(java.awt.Graphics g){//actualiza Graphisc en el main para saber donde pintar
        _g = g;
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
    public void clear(int color){
        
    }
    public void drawImage(Image image,int x, int y){//dibuja en la pos x e y la imagen dada
        _g.drawImage((java.awt.image.BufferedImage)image,x,y,null);
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
}
