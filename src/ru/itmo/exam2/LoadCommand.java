package ru.itmo.exam2;

public class LoadCommand implements Command{
    private Game game;
    public LoadCommand(Game game){
        this.game=game;
    }
    public void execute(){
        game.loadGame();
    }
}
