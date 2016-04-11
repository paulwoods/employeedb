package org.mrpaulwoods.employee.payroll

import org.mrpaulwoods.employee.person.Person

import javax.validation.constraints.NotNull

/**
 * Created on 3/13/2016.
 */
class PayrollForm {

    Long id

    @NotNull
    Long personId

    @NotNull
    BigDecimal salary

    PayrollForm() {
    }

    PayrollForm(Payroll payroll) {
        this.id = payroll.id
        this.personId = payroll.person.id
        this.salary = payroll.salary
    }

    void update(Payroll payroll) {
        payroll.person = new Person(id:personId)
        payroll.salary = salary
    }

}

