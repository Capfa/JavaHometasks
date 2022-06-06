package ru.itmo.exam2;

public class LoadCommand implements Command{
    private SaveLoad loading;
    public LoadCommand(SaveLoad loading){
        this.loading=loading;
    }
    public void execute(){
         loading.startLoaded();
    }
}
