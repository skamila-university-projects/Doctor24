package skamila.doctor24.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import skamila.doctor24.notificationservice.config.SpringConfiguration;
import skamila.doctor24.notificationservice.dto.AppUserRabbitDto;

@Service("mailService")
public class MailService {

    private final JavaMailSender emailSender;

    @Autowired
    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMail(AppUserRabbitDto user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SpringConfiguration.MAIL);
        message.setTo(user.getEmail());
        message.setSubject("Doctor24 - witamy!");
        String welcome = "Witaj " + user.getName() + "!\nSerdecznie witamy cię w witrynie Doctor24. Dziękujemy za zaufanie.\nZespół Doctor24";
        message.setText(welcome);
        emailSender.send(message);
    }

}
