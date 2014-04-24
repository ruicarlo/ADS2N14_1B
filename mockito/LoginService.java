package mockito;

public class LoginService {
    private AccountRepository accountDB;
    private int failAttemps = 0;
    private Account previousAccount;
    
    public LoginService(AccountRepository accountDB) {
        this.accountDB = accountDB;
    }
    
    public void login(String userName, String password) throws AccountLoginLimitReachedException {
        Account account = accountDB.find(userName);

        if(account.isLoggedIn()) {
            throw new AccountLoginLimitReachedException();
        }

        if(account.passwordsMatches(password)) {
            account.setLoggedIn(true);
        } else {
            if(previousAccount != null && previousAccount.equals(account)) {
                failAttemps++;
            } else {
                previousAccount = account;
                failAttemps = 1;
            }
            
            if(failAttemps == 3) {
                account.setBlocked(true);
            }
        }
    }

}
