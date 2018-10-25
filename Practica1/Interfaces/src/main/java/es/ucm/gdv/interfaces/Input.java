package es.ucm.gdv.interfaces;

import java.util.List;

public interface Input {
    public static class TouchEvent{

    }
    List<TouchEvent> getTouchEvents();
}
