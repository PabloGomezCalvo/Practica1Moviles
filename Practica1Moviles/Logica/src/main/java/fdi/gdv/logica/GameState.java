package fdi.gdv.logica;

import fdi.gdv.engine.*;
public abstract class GameState {
    abstract void tick();
    void draw()
    {
        _screen.clear(0x00000000);
        _screen.draw();
    }
    abstract void init();
    abstract void deinit();
    abstract void pollEvents();

    Screen _screen;
    Game _game;
    Logic _logic;
}
