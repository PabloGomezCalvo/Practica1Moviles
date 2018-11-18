package fdi.gdv.enginepc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import fdi.gdv.engine.*;

public class InputPC implements Input, MouseListener {

    public InputPC(JFrame ventana) {
        _ventana = ventana;
        ventana.addMouseListener(this);
        this._touchEvents = new LinkedList<TouchEvent>();
    }



    @Override
    public List<TouchEvent> getTouchEvents(){
        return _touchEvents;
    }


    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        synchronized (this){
            _touchEvents.add(new TouchEvent(mouseEvent.getButton(), TouchEvent.eventType.BUTTON_PRESSED,mouseEvent.getX(),mouseEvent.getY()));
        }
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void release(){
        _ventana.removeMouseListener(this);
    }

    List<TouchEvent> _touchEvents;
    JFrame _ventana;
}
