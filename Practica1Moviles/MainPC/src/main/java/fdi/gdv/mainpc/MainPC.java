package fdi.gdv.mainpc;

import fdi.gdv.enginepc.GamePC;
import fdi.gdv.logica.Logic;

public class MainPC {
    public static void main (String [] args)
    {
        GamePC game = new GamePC();
        Logic logica = new Logic(game);
        game.setLogic(logica);

        game.run();
    }
}
