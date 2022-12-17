package theTeamProject;

public interface gameInterface {
    public void register(gameObserver observer);
    public void unregister(gameObserver observer);
    public void notifyObservers();

    public int checkTurn();
    public int checkSpot(int x);
    public void turnIncrement();
    public boolean moveRed(int x);
    public boolean moveBlue(int x);
    public void resetGame();
    
}

