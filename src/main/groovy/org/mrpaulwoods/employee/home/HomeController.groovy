package org.mrpaulwoods.employee.home

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

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
    String index() {
        homeService.example()
        "home/index"
    }

}

