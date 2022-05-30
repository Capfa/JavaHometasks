package ru.itmo.exam2;

public class Play {
    public void start(){
        Game game=new Game();
        Command runGameCommand=new RunCommand(game);
        Command loadGameCommand=new LoadCommand(game);
        StartMenu startMenu = new StartMenu(runGameCommand,loadGameCommand);
        startMenu.showMenu();
    }
}
