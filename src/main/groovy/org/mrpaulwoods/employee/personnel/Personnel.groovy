package org.mrpaulwoods.employee.personnel

import org.mrpaulwoods.employee.payroll.Salary
import org.mrpaulwoods.employee.profile.Profile

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

/**
 * Created on 3/7/2016.
 */
@Entity
class Personnel implements Serializable {

    @Id
    @GeneratedValue
    Long id

    String firstName
    String lastName

    String getFullName() {
        lastName + ", " + firstName
    }

}
