package fdi.gdv.logica;

import fdi.gdv.engine.*;
import fdi.gdv.engine.Input.TouchEvent;
import java.util.List;

public class InstructionsState extends GameState{



    public InstructionsState(Game g, Logic l) {
        this._game = g;
        this._logic = l;
    }
    @Override
    public void tick()  {
        pollEvents();

    }


    @Override
    public void init() {

        String instrucciones = "Usted esta pilotando un avion sobre una ciudad desierta y tiene que pasar sobre " +
                "los edificios para aterrizar y repostar. Su avion se mueve de izquierda a derecha.\n"+
                "\nAl llegar a la derecha el avion vuelve a salir por la izquierda pero MAS BAJO. Dispone de un numero limitado de bombas"
                + "y puede hacerlas caer sobre los edificios pulsando sobre la pantalla.\n" +
                "\nCada vez que aterriza, sube la altura de los edificios y la velodicad.\n" +
                "\nUNA VEZ DISPARADA UNA BOMBA YA NO PUEDE DISPARAR OTRA MIENTRAS NO HAYA EXPLOSIONADO LA PRIMERA!!!!\n";

        _screen = new Screen(_game, _logic);
        _screen.init(25,45);

        _screen.print(instrucciones, 0,0,color.LIGHTGREEN);
        _screen.print("Pulse para empezar...", 0, _screen.get_rows()-5, color.RED);

        //Copiamos de color a
    }
    @Override
    public void pollEvents () {
        List<TouchEvent> temp;
        temp = _game.getInput().getTouchEvents();
        if (temp != null) {
            for (TouchEvent tE : temp) {
                synchronized (this) {
                    if(tE.get_eventType() == TouchEvent.eventType.BUTTON_PRESSED && tE.get_buttonIndex()== 1){
                        _logic.changeScene(_logic.get_activeState()+1);
                    }
                    temp.remove(tE);
                }
            }
        }
    }


    @Override
    public void deinit() {

    }
    private Game _game;
    private Logic _logic;
    int i = 0;
    int j = 0;
}
