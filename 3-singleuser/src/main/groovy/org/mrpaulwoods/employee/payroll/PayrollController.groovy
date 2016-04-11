package org.mrpaulwoods.employee.payroll

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

import javax.validation.Valid

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping(value = "/payroll")
@Slf4j
@Secured('ROLE_HR')
class PayrollController {

    private final PayrollRepository payrollRepository

    @Autowired
    PayrollController(PayrollRepository PayrollRepository) {
        this.payrollRepository = PayrollRepository
    }

    @RequestMapping(method=GET)
    String index(final Model model) {
        model.addAttribute "salaries", payrollRepository.findAll()
        "payroll/index"
    }

    @RequestMapping(value="/create/{personId}", method=GET)
    String create(final Model model, @PathVariable Long personId) {
        log.info "create personId={}", personId
        model.addAttribute "payrollForm", new PayrollForm(personId: personId)
        "payroll/create"
    }

    @RequestMapping(value="/save", method= POST)
    String save(final Model model, @Valid PayrollForm payrollForm, BindingResult bindingResult) {
        log.info "save payrollForm={}", payrollForm.dump()
        if (bindingResult.hasErrors()) {
            "payroll/create"
        } else {
            Payroll payroll = new Payroll()
            payrollForm.update payroll
            payrollRepository.save payroll
            "redirect:/payroll/show/${payroll.id}"
        }
    }

    @RequestMapping(value="/show/{id}", method=GET)
    String show(final Model model, @PathVariable Long id) {
        log.info "show id={}", id
        Payroll payroll = payrollRepository.getOne(id)
        if(payroll) {
            model.addAttribute "payroll", payroll
            "payroll/show"
        } else {
            throw new Payroll.NotFoundException()
        }
    }

    @RequestMapping(value="/edit/{id}", method=GET)
    String edit(final Model model, @PathVariable Long id) {
        log.info "edit id={}", id
        Payroll payroll = payrollRepository.getOne(id)
        if(payroll) {
            model.addAttribute "payroll", payroll
            model.addAttribute "payrollForm", new PayrollForm(payroll)
            "payroll/edit"
        } else {
            throw new Payroll.NotFoundException()
        }
    }

    @RequestMapping(value="/update/{id}", method= POST)
    String update(final Model model, @PathVariable Long id, @Valid PayrollForm payrollForm, BindingResult bindingResult) {
        log.info "update id={}, payrollForm={}", id, payrollForm.dump()
        Payroll payroll = payrollRepository.getOne(id)
        if(payroll) {
            if (bindingResult.hasErrors()) {
                model.addAttribute "payroll", payroll
                "payroll/edit"
            } else {
                payrollForm.update payroll
                payrollRepository.save payroll
                "redirect:/payroll/show/${payroll.id}"
            }
        } else {
            throw new Payroll.NotFoundException()
        }
    }

    @RequestMapping(value="/confirm/{id}", method=GET)
    String confirm(final Model model, @PathVariable Long id) {
        log.info "confirm id={}", id
        Payroll payroll = payrollRepository.getOne(id)
        if(payroll) {
            model.addAttribute "payroll", payroll
            "payroll/confirm"
        } else {
            throw new Payroll.NotFoundException()
        }
    }

    @RequestMapping(value="/delete/{id}", method= POST)
    String delete(final Model model, @PathVariable Long id) {
        log.info "delete id={}", id
        Payroll payroll = payrollRepository.getOne(id)
        if(payroll) {
            payroll.person.payroll = null // unlink the payroll and person
            payrollRepository.delete(id)
            "redirect:/payroll"
        } else {
            throw new Payroll.NotFoundException()
        }
    }

}
