package fdi.gdv.engine;

import java.util.List;

public interface Input {

    public class TouchEvent {
        public enum eventType{
            BUTTON_PRESSED,
            BUTTON_RELEASED,
        }

        public TouchEvent(int buttonIndex, eventType eventType, int x_, int y_){
            this.x_ = x_;
            this.y_ = y_;
            this._buttonIndex = buttonIndex;
            this._eventType = eventType;

        }

        public int get_buttonIndex() {
            return _buttonIndex;
        }

        public eventType get_eventType() {
            return _eventType;
        }

        int _buttonIndex;
        eventType _eventType;
        int x_;
        int y_;


        public int getX() {
            return x_;
        }

        public int getY() {
            return y_;
        }


    }

    List<TouchEvent> getTouchEvents();
    void release();
}
