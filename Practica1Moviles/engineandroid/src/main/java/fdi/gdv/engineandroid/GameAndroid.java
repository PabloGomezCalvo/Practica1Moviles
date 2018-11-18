package fdi.gdv.engineandroid;

import android.content.res.AssetManager;

import fdi.gdv.engine.Game;
import fdi.gdv.engine.Graphics;
import fdi.gdv.engine.Input;
import fdi.gdv.engine.LogicInterface;

import android.view.SurfaceView;

public class GameAndroid implements Game{
    private SurfaceView _ventana;

    public GameAndroid(SurfaceView view,AssetManager assetManager){
        _graphiscAndroid = new GraphicsAndroid(view,assetManager);
        _inputAndroid = new InputAndroid();


    }

    @Override
    public Input getInput() {
        return _inputAndroid;
    }
    @Override
    public Graphics getGraphics() {
        return _graphiscAndroid;
    }



    public void run() {
        while (true) {
            _gameState.run();
            _graphiscAndroid.present();
        }
    }
    public void setLogic(LogicInterface games){
        _gameState = games;
        _gameState.initLogic();
    }

    private GraphicsAndroid _graphiscAndroid;
    private InputAndroid _inputAndroid;
    private LogicInterface _gameState;

}