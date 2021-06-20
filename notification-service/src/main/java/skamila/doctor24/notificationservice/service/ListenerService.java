package skamila.doctor24.notificationservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import skamila.doctor24.notificationservice.dto.AppUserRabbitDto;

@Service("listenerService")
public class ListenerService {

    private final MailService mailService;

    public ListenerService(MailService mailService) {
        this.mailService = mailService;
    }

    @RabbitListener(queues = "welcome-email")
    public void receiveNote(AppUserRabbitDto user) {
        System.out.printf("----------------------");
        mailService.sendMail(user);
    }

}
