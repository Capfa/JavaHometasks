package ru.itmo.exam2;

public class SaveCommand implements Command{
    private SaveLoad saving;
    private String text;
    private Node node1;
    private Node node2;
    public SaveCommand (SaveLoad saving,String text,Node node1,Node node2){
        this.saving=saving;
        this.text=text;
        this.node1=node1;
        this.node2=node2;

    }
    public void execute(){
        saving.saveGame(text,node1,node2);
    }
}
