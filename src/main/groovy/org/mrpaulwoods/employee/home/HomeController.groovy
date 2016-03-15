package org.mrpaulwoods.employee.home

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import java.security.Principal

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping
@Slf4j
class HomeController {

    private final HomeService homeService

    @Autowired
    HomeController(HomeService homeService) {
        this.homeService = homeService
    }

    @RequestMapping(method=GET)
    String index(Principal principal) {
        log.info "current user = ${principal?.name}"
        homeService.example()
        "home/index"
    }
}


