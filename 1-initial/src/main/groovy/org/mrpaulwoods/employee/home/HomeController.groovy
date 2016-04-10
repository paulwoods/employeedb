package org.mrpaulwoods.employee.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping
class HomeController {

    @RequestMapping(method=GET)
    String index() {
        "home/index"
    }
}


