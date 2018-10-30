package es.ucm.gdv.pc;

import es.ucm.gdv.interfaces.Game;

public class GamePC implements Game {
    public GamePC(GraphicsPC g, InputPC input){
        _graphics = g;
        _input = input;
    }
    public GraphicsPC getGraphics (){
        return _graphics;
    }
    public InputPC getInput(){
        return _input;
    }

    private GraphicsPC _graphics;
    private InputPC _input;

}
