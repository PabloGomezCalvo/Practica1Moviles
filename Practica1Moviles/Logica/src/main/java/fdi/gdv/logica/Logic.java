package fdi.gdv.logica;

import fdi.gdv.engine.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Logic implements LogicInterface{

    public Logic(Game game)
    {
        this._game = game;
    }

    public void initLogic()
    {
        sprites = new ArrayList<ArrayList<Sprite>>();
        images = new ArrayList<>();
        _states = new LinkedList<>();

        loadSpritesheets();
        _activeState = 0;
        _states.add(new InstructionsState(_game, this));
        _states.add(new DificultyState(_game, this));

        _states.get(0).init();
    }
    private void loadSpritesheets(){

        int n = 0;
        for (n = 0; n < 16; n++) {
            Image spritesheet;
            if(n<10)
                spritesheet = _game.getGraphics().newImage("Assets/ASCII_" + "0"+ n + ".png");
            else
                spritesheet = _game.getGraphics().newImage("Assets/ASCII_" +  n + ".png");
            images.add(spritesheet);
            ArrayList<Sprite> sSheet = new ArrayList<>();

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    Sprite temp = new Sprite(spritesheet, new Rect(16 * j, 16 * i, 16, 16));
                    sSheet.add(temp);
                }
            }
            sprites.add(sSheet);
        }
    }
    public boolean run()
    {
        _states.get(_activeState).tick();
        _states.get(_activeState).draw();
        _game.getGraphics().present();


        return true;
    }


    public void setGamedificulty(int difficulty, int height){
        _gameDif = difficulty;
        _gameHeight = height;
    }
    public Sprite getSprite(int color, char character){
        return sprites.get(color).get(character);
    }


    public void changeScene(int nScene){
        int temp = _activeState;
        _activeState = nScene;
        _states.get(temp).deinit();
        _states.get(_activeState).init();

    }
    public int get_activeState() {
        return _activeState;
    }

    public void set_gameDif(int ndif){
        _gameDif = ndif;
    }
    public int get_gameDif(){
        return _gameDif;
    }
    public void set_gameHeight(int nHeight){
        _gameHeight = nHeight;
    }

    public int get_gameHeight(){
        return _gameHeight;
    }
    int _activeState;
    int _gameDif;
    int _gameHeight;
    Game _game;
    ArrayList<ArrayList<Sprite>> sprites;
    ArrayList<Image>images;

    LinkedList<GameState> _states;



}
