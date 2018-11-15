package es.ucm.gdv.interfaces;



public interface Graphics {
    public Image newImage(String name);
    public void clear(int color);
    public void drawImage(Image image,Rect x, Rect y);
    public int getWidth();
    public int getHeight();
    public void present();
}
