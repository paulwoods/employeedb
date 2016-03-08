package org.mrpaulwoods.employee.profile

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping(value = "/profile")
class ProfileController {

    @RequestMapping(method=GET)
    String index() {
        "profile/index"
    }

}
