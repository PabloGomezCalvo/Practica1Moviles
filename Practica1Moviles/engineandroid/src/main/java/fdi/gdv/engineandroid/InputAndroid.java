package fdi.gdv.engineandroid;


import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;
import java.util.List;
import fdi.gdv.engine.*;
public class InputAndroid implements Input,View.OnTouchListener {

    public InputAndroid(){
        touchEvents = new LinkedList<>();

    }

    @Override
    public void release() { }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        boolean insert = false;
        TouchEvent.eventType eventType=null;
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                eventType = TouchEvent.eventType.BUTTON_PRESSED;
                insert = true;
                break;
            case MotionEvent.ACTION_UP:
                eventType = TouchEvent.eventType.BUTTON_RELEASED;
                insert = true;
                break;
        }
        if(insert) {
            TouchEvent touchEvent = new TouchEvent(
                    event.getActionIndex(),
                    eventType,
                    (int) event.getX(),
                    (int) event.getY());


            synchronized (this) {
                touchEvents.addLast(touchEvent);
            }
        }

        return true;
    }
    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchEvents;
    }

    LinkedList<TouchEvent> touchEvents;
}
