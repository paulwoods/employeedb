package org.mrpaulwoods.employee.profile

import org.mrpaulwoods.employee.personnel.Personnel

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created on 3/7/2016.
 */
@Entity
class Profile implements Serializable {

    @Id
    @GeneratedValue
    Long id

    Personnel person

    BigDecimal salary

}
