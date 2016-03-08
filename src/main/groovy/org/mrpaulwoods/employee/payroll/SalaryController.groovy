package org.mrpaulwoods.employee.payroll

import org.mrpaulwoods.employee.profile.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping(value = "/salary")
class SalaryController {

    private final SalaryRepository salaryRepository

    @Autowired
    SalaryController(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository
    }

    @RequestMapping(method=GET)
    String index(final Model model) {
        model.addAttribute "salaries", salaryRepository.findAll()
        "salary/index"
    }
}
