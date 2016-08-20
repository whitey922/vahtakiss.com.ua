package com.vahtakiss.classes.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class EmailSender {

    private static String[] recipientsEmails;
    private static String sendersEmail = "order@vahtakiss.com.ua";
    private static String sendersPwd   = "vapenation13";

    static void sendEmail(String messageText, String messageSubj, String ... recipients) {
        recipientsEmails = initRecipients(recipients);

        Properties mailProps = new Properties();

        mailProps.put("mail.smtp.host", "smtp-5.1gb.ua");
        mailProps.put("mail.smtp.port", "465");
        mailProps.put("mail.smtp.auth", "true");
        mailProps.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication( ) {
                return new PasswordAuthentication("u80391", sendersPwd);
            }
        };

        Session session = Session.getDefaultInstance(mailProps, authenticator);
        try {
            final MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("order@vahtakiss.com.ua"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientsEmail));
            message.addRecipients(Message.RecipientType.TO, initInternetAddresses());
            message.setSubject(messageSubj);
            message.setText(messageText);
            Transport.send(message);
        } catch (Exception e) {
            System.err.println("Problem sending email. Exception : " + e.getMessage());
        }
    }

    private static String[] initRecipients(String ... inRecipients) {
        String[] recipients;

        if (inRecipients != null) {
            recipients = new String[inRecipients.length + 1];
            System.arraycopy(inRecipients, 0, recipients, 1, inRecipients.length);
        }
        else
            recipients = new String[1];

        recipients[0] = "basketwall.info@mail.ru";

        return recipients;
    }

    private static InternetAddress[] initInternetAddresses() throws AddressException {
        InternetAddress[] addresses = new InternetAddress[recipientsEmails.length];
        for (int i = 0; i < recipientsEmails.length; i++) {
            addresses[i] = new InternetAddress(recipientsEmails[i]);
        }
        return addresses;
    }
}