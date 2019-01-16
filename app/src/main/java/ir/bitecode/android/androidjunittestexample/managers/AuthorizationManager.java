package ir.bitecode.android.androidjunittestexample.managers;

public class AuthorizationManager {

    private String userName = "guest";
    private boolean isAuthorized = false;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }
}
