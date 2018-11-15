package com.example.android;

import android.content.res.AssetManager;

import es.ucm.gdv.interfaces.Game;
import es.ucm.gdv.interfaces.Graphics;
import es.ucm.gdv.interfaces.Input;
import es.ucm.gdv.interfaces.GameState;
import android.view.SurfaceView;

public class GameAndroid implements Game{
    private SurfaceView _ventana;

    public GameAndroid(SurfaceView view,AssetManager assetManager, GameState games){
        _graphiscAndroid = new GraphiscAndroid(view,assetManager);
        _inputAndroid = new InputAndroid();
        _gameState = games;

    }
    @Override
    public Graphics getGraphics() {
        return _graphiscAndroid;
    }

    @Override
    public Input getInput() {
        return _inputAndroid;
    }

    public void run() {
        while (true) {
            _gameState.Tick();
            _gameState.Render();
            _graphiscAndroid.present();
        }
    }

    private GraphiscAndroid _graphiscAndroid;
    private InputAndroid _inputAndroid;
    private GameState _gameState;

}
