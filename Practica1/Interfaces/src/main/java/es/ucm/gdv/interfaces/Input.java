package es.ucm.gdv.interfaces;

import java.util.List;

public interface Input {
    public class TouchEvent {
        public enum eventType{
            BUTTON_PRESSED,
            BUTTON_RELEASED
        }

        public TouchEvent(int buttonIndex, TouchEvent.eventType eventType, int x, int y){
            this._x = x;
            this._y = y;
            this._buttonIndex = buttonIndex;
            this._eventType = eventType;
        }


        public int get_buttonIndex() {
            return _buttonIndex;
        }

        public eventType get_eventType() {
            return _eventType;
        }

        public int get_x() {
            return _x;
        }

        public int get_y() {
            return _y;
        }

        private int _buttonIndex;
        private TouchEvent.eventType _eventType;
        private int _x;
        private int _y;

    }
    List<TouchEvent> getTouchEvents();
}
