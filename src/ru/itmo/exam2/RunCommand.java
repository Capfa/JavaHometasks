package ru.itmo.exam2;

public class RunCommand implements Command{
    private Game game;
    public RunCommand(Game game){
        this.game=game;
    }
    public void execute(){
        game.runGame();
    }

}
