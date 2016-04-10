package org.mrpaulwoods.employee.payroll

import org.mrpaulwoods.employee.person.Person

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

/**
 * Created on 3/7/2016.
 */
@Entity
class Payroll implements Serializable {

    @Id
    @GeneratedValue
    Long id

    @OneToOne
    Person person

    BigDecimal salary

    static class NotFoundException extends RuntimeException {
        NotFoundException() {
            super("The payroll was not found")
        }
    }

}
