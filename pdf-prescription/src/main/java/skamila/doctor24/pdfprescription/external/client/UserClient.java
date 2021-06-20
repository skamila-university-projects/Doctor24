package skamila.doctor24.pdfprescription.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skamila.doctor24.pdfprescription.external.dto.User;

@FeignClient(name = "userClient")
public interface UserClient {

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    User getById(@PathVariable(value = "userId") long userId);

}
