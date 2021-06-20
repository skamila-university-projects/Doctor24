package skamila.doctor24.pdfprescription.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skamila.doctor24.pdfprescription.external.dto.User;

@FeignClient(name = "USER-SERVICE")
public interface UserServiceClient {

    @RequestMapping(value = "/users/byEmail/{userEmail}", method = RequestMethod.GET)
    User getByEmail(@PathVariable(value = "userEmail") String userEmail);

}
