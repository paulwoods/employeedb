package org.mrpaulwoods.employee.personnel

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping(value = "/personnel")
class PersonnelController {

    @RequestMapping(method=GET)
    String index() {
        "personnel/index"
    }

}
