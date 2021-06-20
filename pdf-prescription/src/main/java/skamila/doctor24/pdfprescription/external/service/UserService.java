package skamila.doctor24.pdfprescription.external.service;

import org.springframework.stereotype.Service;
import skamila.doctor24.pdfprescription.external.dto.User;
import skamila.doctor24.pdfprescription.external.client.UserServiceClient;

@Service("userService")
public class UserService {

    private final UserServiceClient userServiceClient;

    public UserService(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    public User getUser(long patientId) {
        return userServiceClient.getById(patientId);
    }

}
