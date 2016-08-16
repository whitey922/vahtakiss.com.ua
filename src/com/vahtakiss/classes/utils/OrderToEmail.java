package com.vahtakiss.classes.utils;

import com.vahtakiss.classes.Beverage;

import java.util.List;

public class OrderToEmail {
    private List<Beverage> order;
    private String id;
    private String description;

    public OrderToEmail(List<Beverage> order, String id, String description) {
        this.order = order;
        this.id = id;
        this.description = description;
    }

    public void sendOrder() {
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(getMessageText(), getMessageSubject());
    }

    private String getMessageText() {
        StringBuilder stringBuilder = new StringBuilder();
        double fullCost = 0;

        stringBuilder.append("user: " + id + "\n");
        for (Beverage bev : order) {
            stringBuilder.append("order: ");
            for (String el : bev.getDescription())
                stringBuilder.append(el + "\t");
            stringBuilder.append("cost: " );
            stringBuilder.append(String.format("%.2f", bev.cost()) + "\n");
            fullCost += bev.cost();
        }
        stringBuilder.append("Full cost: " + String.format("%.2f", fullCost));

        stringBuilder.append("\n\n").append(description);

        return stringBuilder.toString();
    }

    private String getMessageSubject() {
        return "order from: " + id;
    }
}
