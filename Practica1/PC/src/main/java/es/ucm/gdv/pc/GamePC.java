package es.ucm.gdv.pc;

import javax.swing.*;
import es.ucm.gdv.interfaces.Game;
import es.ucm.gdv.interfaces.GameState;

public class GamePC  extends JFrame implements Game{
    public GamePC(GameState gameState){
        super("GamePC");
        setSize(800,600);
        setIgnoreRepaint(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _gameState = gameState;
        _graphics = new GraphicsPC(800,600);
        _input = null;
    }

    public void run(){
        java.awt.Graphics g;

        while(true){

            _gameState.Tick();

            g = getGraphics();

            _graphics.actualizaGraphics(g);
            _gameState.Render();
            if(g != null)
                g.dispose();

        }

    }

    public GraphicsPC getMyGraphics (){
        return _graphics;
    }
    public InputPC getInput(){
        return _input;
    }

    private GraphicsPC _graphics;
    private InputPC _input;
    private GameState _gameState;

}
