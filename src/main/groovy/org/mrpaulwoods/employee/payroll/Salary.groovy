package org.mrpaulwoods.employee.payroll

import org.mrpaulwoods.employee.personnel.Personnel

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created on 3/7/2016.
 */
@Entity
class Salary implements Serializable {

    @Id
    @GeneratedValue
    Long id

    Personnel person

    BigDecimal salary
}
