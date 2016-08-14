package com.vahtakiss.classes.utils;

import com.vahtakiss.classes.Beverage;

import java.util.List;

public class OrderToEmail {
    private List<Beverage> order;
    private String id;

    public OrderToEmail(List<Beverage> order, String id) {
        this.order = order;
        this.id = id;
    }

    public void sendOrder() {
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(getMessageText(), getMessageSubject());
    }

    private String getMessageText() {
        StringBuilder stringBuilder = new StringBuilder();
        double fullCost = 0;

        stringBuilder.append("user: " + id + "\n");
        for (Beverage elem : order) {
            stringBuilder.append("order: ");
            stringBuilder.append(elem.getDescription() + "\t");
            stringBuilder.append("cost: " );
            stringBuilder.append(String.format("%.2f", elem.cost()) + "\n");
            fullCost += elem.cost();
        }
        stringBuilder.append("Full cost: " + String.format("%.2f", fullCost));

        return stringBuilder.toString();
    }

    private String getMessageSubject() {
        return "order from: " + id;
    }
}
