package com.jap.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Authenticator userAuthenticator=new Authenticator();
        TaskManager taskManagerNew = new TaskManager();
        User authenticatedUser=null;
        while (authenticatedUser==null){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your Username");
            String username = scanner.next();
            System.out.println("Enter your Password");
            String password = scanner.next();
            authenticatedUser=userAuthenticator.authenticateNewUser(username,password);
        }
        taskManagerNew.takeChoices(authenticatedUser);





    }
}
