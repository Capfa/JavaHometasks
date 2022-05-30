package ru.itmo.exam2;

import java.io.IOException;


public interface Command {
    void execute();
   /* static Command getInstance(int actionNumber,Game game){
        if (actionNumber==1) {

            return (RunCommand(game));
        } else if (actionNumber==2){
            LoadGame loadGame=new LoadGame();
            return (loadGame.loadGame());
        } else {
            return () -> {
                try {
                    server.getConnection()
                            .sendMessage(SimpleMessage.getMessage("server", "команда не может быть обработана"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };
        }
    }*/


}
