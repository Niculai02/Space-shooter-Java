package com.company.main;

public class CustomEx  extends  Exception{

    public CustomEx(String mess, Throwable cause){
        super(mess, cause);
    }
    public CustomEx(String mess) {
        super(mess);
    }
}

