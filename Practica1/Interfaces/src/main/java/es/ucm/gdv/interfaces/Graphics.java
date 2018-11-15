package es.ucm.gdv.interfaces;

public interface Graphics {
    public Image newImage(String name);
    public void clear(int color);
    public void drawImage(Image image,int x, int y);
    public int getWidth();
    public int getHeight();
    public void present();
}
