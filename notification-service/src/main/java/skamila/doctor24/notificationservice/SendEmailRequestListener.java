package skamila.doctor24.notificationservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service("sendEmailRequestListener")
public class SendEmailRequestListener {

    private final MailService mailService;

    public SendEmailRequestListener(MailService mailService) {
        this.mailService = mailService;
    }

    @RabbitListener(queues = "welcome-email")
    public void receiveNote(AppUserDto user) {
        mailService.sendMail(user);
    }

}
