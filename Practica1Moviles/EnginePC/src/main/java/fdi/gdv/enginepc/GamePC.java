package fdi.gdv.enginepc;

import javax.swing.JFrame;

import fdi.gdv.engine.Game;
import fdi.gdv.engine.Graphics;
import fdi.gdv.engine.Input;
import fdi.gdv.engine.LogicInterface;

public class GamePC implements Game {

    public GamePC() {
        JFrame frame = new JFrame("BLYAT");

        GraphicsPC g = new GraphicsPC(frame);
        InputPC i = new InputPC(frame);
        this._graphics = g;
        this._input = i;
    }
    @Override
    public Input getInput() {
        return _input;
    }

    public void setLogic(LogicInterface logica){
        _logica = logica;
        _logica.initLogic();
    }
    @Override
    public Graphics getGraphics(){
        return _graphics;
    }


    public void run(){
        while(_logica.run());

        _input.release();
    }


    GraphicsPC _graphics;
    InputPC _input;
    LogicInterface _logica;

}
