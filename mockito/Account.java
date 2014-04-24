package mockito;

public interface Account {

    public boolean passwordsMatches(String password);
    
    public void setLoggedIn(boolean loggedIn);

    public boolean isLoggedIn();

    public void setBlocked(boolean blocked);

}
