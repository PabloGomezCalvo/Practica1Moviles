package fdi.gdv.p1;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.content.Context;

import fdi.gdv.engineandroid.GameAndroid;
import fdi.gdv.engine.LogicInterface;
import fdi.gdv.logica.Logic;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _view = new MyView(this);
        AssetManager assets = this.getAssets();
        _gameAndroid = new GameAndroid(_view,assets);
        LogicInterface gameState = new Logic(_gameAndroid);
        _gameAndroid.setLogic(gameState);
    }
    @Override
    protected void onResume(){
        super.onResume();
        _view.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        _view.pause();
    }

    class MyView extends SurfaceView implements Runnable {

        public MyView(Context context) {
            super(context);
            _running = false;
        }

        public void resume(){
            if(!_running){
                _running=true;

                _runningThread = new Thread(this);
                _runningThread.start();
            }
        }
        public void pause(){
            _running = false;
        }

        @Override
        public void run() {
            while(_gameAndroid.equals(null));
            _gameAndroid.run();
        }
        volatile boolean _running;
        Thread _runningThread;
    }

    GameAndroid _gameAndroid;
    MyView _view;
}
