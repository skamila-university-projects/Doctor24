package skamila.doctor24.pdfprescription.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skamila.doctor24.pdfprescription.external.dto.Visit;

@FeignClient(name = "visitClient")
public interface VisitClient {

    @RequestMapping(value = "/visits/{visitId}", method = RequestMethod.GET)
    Visit getById(@PathVariable(value = "visitId") long visitId);

}
