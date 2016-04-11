package org.mrpaulwoods.employee.payroll

import org.mrpaulwoods.employee.person.Person
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created on 3/7/2016.
 */
interface PayrollRepository extends JpaRepository<Payroll, Long> {
    Payroll findByPerson(Person person)

}
