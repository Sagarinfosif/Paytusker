package com.example.paytusker.Utils;


public class Singleton {


    private static final Singleton ourInstance = new Singleton();


    public static Singleton getInstance() {
        return ourInstance;
    }

    int checkScreen=0;
    int logout=0;

    public int getLogout() {
        return logout;
    }

    public void setLogout(int logout) {
        this.logout = logout;
    }

    public int getCheckScreen() {
        return checkScreen;
    }

    public void setCheckScreen(int checkScreen) {
        this.checkScreen = checkScreen;
    }
}
