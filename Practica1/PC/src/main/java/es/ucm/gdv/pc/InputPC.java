package es.ucm.gdv.pc;

import java.util.LinkedList;
import java.util.List;
import es.ucm.gdv.interfaces.Input;
import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputPC implements Input, MouseListener {
    public InputPC(JFrame ventana) {
        _ventana = ventana;
        _ventana.addMouseListener(this);
        _touchEvents = new LinkedList<TouchEvent>();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return _touchEvents;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {//el usuario clickea

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {//se llama al pulsar cualquier boton del raton en la ventana
        synchronized (this){
            _touchEvents.add(new TouchEvent(mouseEvent.getButton(), TouchEvent.eventType.BUTTON_PRESSED,mouseEvent.getX(),mouseEvent.getY()));
        }
    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        synchronized (this){
            _touchEvents.add(new TouchEvent(mouseEvent.getButton(), TouchEvent.eventType.BUTTON_RELEASED,mouseEvent.getX(),mouseEvent.getY()));
        }
    }

    List<TouchEvent> _touchEvents;
    JFrame _ventana;
}
