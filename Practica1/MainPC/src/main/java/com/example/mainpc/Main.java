package com.example.mainpc;

import com.example.logica.States.GameStateLogic;
import es.ucm.gdv.pc.GamePC;

public class Main {
    public static void main (String [ ] args) {

        GameStateLogic gameState = new GameStateLogic();

        GamePC game = new GamePC(gameState);

        game.run();
    }
}
