package com.vahtakiss.classes.utils;

import com.vahtakiss.classes.basement.Beverage;

import java.util.List;

public class OrderToEmail {
    private List<Beverage> beverages;
    private Order.User         user;
    private String         description;

    public OrderToEmail(List<Beverage> beverages, Order.User user, String description) {
        this.beverages = beverages;
        this.user = user;
        this.description = description;
    }

    public void sendOrder(String ... receivers) {
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(getMessageText(), getMessageSubject(), receivers);
    }

    private String getMessageText() {
        StringBuilder stringBuilder = new StringBuilder();
        double fullCost = 0;

        stringBuilder.append("User: " + user.getUserLink() + "\n");
        stringBuilder.append("Hostage: " + user.getHostel() + "\n");
        stringBuilder.append("Room: " + user.getRoom() + "\n");
        for (Beverage bev : beverages) {
            stringBuilder.append("beverages: ");
            for (String el : bev.getDescription())
                stringBuilder.append(el + "\t");
            stringBuilder.append("getCost: " );
            stringBuilder.append(String.format("%.2f", bev.getCost()) + "\n");
            fullCost += bev.getCost();
        }
        stringBuilder.append("Full getCost: " + String.format("%.2f", fullCost));

        stringBuilder.append("\n\n").append(description);

        return stringBuilder.toString();
    }

    private String getMessageSubject() {
        return "Order from: " + user.getUserLink();
    }
}
