package org.mrpaulwoods.employee.payroll

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping(value = "/payroll")
class PayrollController {

    @RequestMapping(method=GET)
    String index() {
        "payroll/index"
    }
}
