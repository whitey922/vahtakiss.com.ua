<%--
  Created by IntelliJ IDEA.
  User: Yegorov
  Date: 04.08.2016
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link rel="stylesheet" href="css/main.css"/>

</head>
<body>
<% 
 private final static String DEFAULT_SERVER = "mail.attbi.com";
 String smtpServ = DEFAULT_SERVER;

    String from = "order@vahtakiss.com.ua";

    String to = "vahtakiss.order@gmail.com";

    String subject = "subject line";

    String emailContent = "emailContent";

    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
    out
        .println("<html><head><title>Email message sender</title></head><body>");

    try {

      sendMessage(smtpServ, to, from, subject, emailContent);

    } catch (Exception e) {

      throw new ServletException(e.getMessage());

    }

    out.println("<h2>The message was sent successfully</h2>");

    out.println("</body></html>");

  } //doPost

  private void sendMessage(String smtpServer, String to, String from,
      String subject, String emailContent) throws Exception {

    Properties properties = System.getProperties();

    //populate the 'Properties' object with the mail
    //server address, so that the default 'Session'
    //instance can use it.
    properties.put("mail.smtp.host", smtpServer);

    Session session = Session.getDefaultInstance(properties);

    Message mailMsg = new MimeMessage(session);//a new email message

    InternetAddress[] addresses = null;

    try {

      if (to != null) {

        //throws 'AddressException' if the 'to' email address
        //violates RFC822 syntax
        addresses = InternetAddress.parse(to, false);

        mailMsg.setRecipients(Message.RecipientType.TO, addresses);

      } else {

        throw new MessagingException(
            "The mail message requires a 'To' address.");

      }

      if (from != null) {

        mailMsg.setFrom(new InternetAddress(from));

      } else {

        throw new MessagingException(
            "The mail message requires a valid 'From' address.");

      }

      if (subject != null)
        mailMsg.setSubject(subject);

      if (emailContent != null)
        mailMsg.setText(emailContent);

      //Finally, send the meail message; throws a 'SendFailedException'
      //if any of the message's recipients have an invalid adress
      Transport.send(mailMsg);

    } catch (Exception exc) {

      throw exc;

    }

  }//sendMessage
%>
</div>

</body>
<script>
    /*Get list objects from localstorage and put it into form to send it to server*/
    $("#orderList tbody").append(
            "<tr>" + "" +
            "<td>" + "<input type='hidden' name='count' value=" + localStorage.length + ">" + "</td>" +
            "</tr>");
//    function Remove(key) {
//        localStorage.removeItem(key);
//    }

    var count = 0;
    for (var i in localStorage) {
        var ord = JSON.parse(localStorage[i]);
        $("#orderList tbody").append(
                "<tr>" + "" +
//                "<td>" + "<span onclick='Remove(i)' '>"+"Remove"+"</span>"+"</td>" +
                "<td>" + "<input type='hidden' name=" + "coffee" + count + " value=" + ord.coffee + ">" + ord.coffee     + "</td>" +
                "<td>" + "<input type='number' min='0' max='2' name=" + "sugar" + count + " value=" + ord.sugar + ">" + "</td>" +
                "<td>" + "<input type='number' min='0' max='2'  name=" + "milk" + count + " value=" + ord.milk + ">" + "</td>" +
                "</tr>");
        count++;
    }


</script>
</html>
