package es.ucm.gdv.pc;

import es.ucm.gdv.interfaces.Game;
import es.ucm.gdv.interfaces.GameState;

public class GamePC  implements Game{
    public GamePC(GameState gameState){
        _ventana = new Ventana(800,600);
        _gameState = gameState;
        _graphics = new GraphicsPC(800,600,_ventana);
        _input = new InputPC(_ventana);
    }

    public void run(){
        _graphics.initGraphics();
        while(true){

            _gameState.Tick();

            _gameState.Render();

            _graphics.present();

        }

    }

    public GraphicsPC getGraphics (){
        return _graphics;
    }
    public InputPC getInput(){
        return _input;
    }

    private GraphicsPC _graphics;
    private InputPC _input;
    private GameState _gameState;
    private Ventana _ventana;
}
