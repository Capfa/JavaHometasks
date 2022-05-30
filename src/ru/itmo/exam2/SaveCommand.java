package ru.itmo.exam2;

public class SaveCommand implements Command{
    private Game game;
    public SaveCommand (Game game){
        this.game=game;
    }
    public void execute(){
        game.saveGame();
    }
}
