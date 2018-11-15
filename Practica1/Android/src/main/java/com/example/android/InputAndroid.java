package com.example.android;

import es.ucm.gdv.interfaces.Input;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;
import java.util.List;


public class InputAndroid implements Input,View.OnTouchListener {

    public InputAndroid(){
        _touchEvent = new LinkedList<TouchEvent>();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return _touchEvent;
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchEvent e=null;

        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                e = new TouchEvent(motionEvent.getActionIndex(),TouchEvent.eventType.BUTTON_PRESSED,(int)motionEvent.getX(),(int)motionEvent.getY());

                break;
            case MotionEvent.ACTION_UP:
                e = new TouchEvent(motionEvent.getActionIndex(),TouchEvent.eventType.BUTTON_RELEASED,(int)motionEvent.getX(),(int)motionEvent.getY());
                break;
        }
        synchronized (this){
            if(e.equals(null))
                _touchEvent.add(e);
        }

        return true;
    }



    List<TouchEvent> _touchEvent;
}
