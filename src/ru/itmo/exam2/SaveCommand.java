package ru.itmo.exam2;

public class SaveCommand implements Command{
    private Game game;
    private String text;
    private Node node1;
    private Node node2;
    public SaveCommand (Game game,String text,Node node1,Node node2){
        this.game=game;
        this.text=text;
        this.node1=node1;
        this.node2=node2;

    }
    public void execute(){
        game.saveGame(text,node1,node2);
    }
}
