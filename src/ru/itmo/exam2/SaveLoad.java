package ru.itmo.exam2;

import java.io.*;

public class SaveLoad {

    private File file=new File("exam2.bin");

    public SaveLoad (){}
    public SaveLoad (File file){

        this.file=file;
    }
    public void saveGame(String text,Node node1,Node node2){
        PassingNode nodeToSave=new PassingNode(text,node1,node2);
        try(FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput= new ObjectOutputStream(fileOutput)) {
            objectOutput.writeObject(nodeToSave);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public Node loadGame(){
        Object result = null;
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput =new ObjectInputStream(fileInput)){
            result = objectInput.readObject();

        }catch (IOException| ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return (Node) result;

    }
    public void startLoaded(){
        Node loaded=loadGame();
        loaded.nodeMethode();

    }
}