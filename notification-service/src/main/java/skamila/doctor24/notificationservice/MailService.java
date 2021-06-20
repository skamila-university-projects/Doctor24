package skamila.doctor24.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {

    private final JavaMailSender emailSender;

    @Autowired
    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMail(AppUserDto user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SpringConfiguration.MAIL);
        message.setTo(user.getEmail());
        message.setSubject("Doctor-24 - witamy!");
        String welcome = "Witaj " + user.getName() + "!\nSerdecznie witamy cię w witrynie Doctor24. Dziękujemy za zaufanie.\nEkipa Doctor-24";
        message.setText(welcome);
        emailSender.send(message);
    }

}
