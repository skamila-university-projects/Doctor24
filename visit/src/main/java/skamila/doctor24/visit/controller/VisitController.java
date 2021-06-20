package skamila.doctor24.visit.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skamila.doctor24.visit.dto.VisitDto;
import skamila.doctor24.visit.service.VisitService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.QueryParam;
import java.security.Principal;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @RolesAllowed({ "ROLE_ADMIN", "ROLE_DOCTOR", "ROLE_PATIENT" })
    public VisitDto getVisit(@QueryParam("visitId") Long visitId) {
        return visitService.getVisitById(visitId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @RolesAllowed({ "ROLE_ADMIN", "ROLE_DOCTOR", "ROLE_PATIENT" })
    public void addVisit(@RequestBody @Validated VisitDto visit, Principal principal) {
        visitService.addVisit(visit, principal);
    }

}
