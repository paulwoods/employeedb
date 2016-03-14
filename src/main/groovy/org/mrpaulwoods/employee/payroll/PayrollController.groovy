package org.mrpaulwoods.employee.payroll

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping(value = "/payroll")
class PayrollController {

    private final PayrollRepository PayrollRepository

    @Autowired
    PayrollController(PayrollRepository PayrollRepository) {
        this.PayrollRepository = PayrollRepository
    }

    @RequestMapping(method=GET)
    String index(final Model model) {
        model.addAttribute "salaries", PayrollRepository.findAll()
        "payroll/index"
    }
}
