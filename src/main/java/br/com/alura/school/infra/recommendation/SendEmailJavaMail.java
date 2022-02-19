package br.com.alura.school.infra.recommendation;

import br.com.alura.school.application.recommendation.SendEmail;
import br.com.alura.school.domain.student.Student;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailJavaMail implements SendEmail {

    private Properties getProps() {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        return props;
    }

    private Session getSession() {
        return Session.getDefaultInstance(getProps(),
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("alura@gmail.com","yourpassword123");
                }
            });
    }

    private void fillHeaders(MimeMessage message) throws MessagingException {
        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.addHeader("format", "flowed");
        message.addHeader("Content-Transfer-Encoding", "8bit");
    }

    @Override
    public void sendTo(Student indicated) {
        try
        {
            Session session = getSession();
            MimeMessage message = new MimeMessage(session);
            fillHeaders(message);

            message.setFrom(new InternetAddress("alura@gmail.com"));

            Address[] toUser = InternetAddress.parse(indicated.getEmail());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Send email with JavaMail");
            message.setText("Congrats! You received a recommendation!");

            Transport.send(message);

            System.out.println("Email sent successful");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
