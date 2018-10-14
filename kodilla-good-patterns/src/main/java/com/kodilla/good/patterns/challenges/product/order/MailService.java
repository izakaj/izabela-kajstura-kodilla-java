package com.kodilla.good.patterns.challenges.product.order;

public class MailService implements InformationService {

    public void inform(User user, String message){
        System.out.println("Mail has been sent to: " + user.getEmail() + "\nMessage: " + message);
    }
}
