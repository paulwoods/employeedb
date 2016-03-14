package org.mrpaulwoods.employee.person

import org.mrpaulwoods.employee.payroll.Payroll
import org.mrpaulwoods.employee.profile.Profile

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

/**
 * Created on 3/7/2016.
 */
@Entity
class Person implements Serializable {

    @Id
    @GeneratedValue
    Long id

    String firstName

    String lastName

    @OneToOne(mappedBy="person", cascade=CascadeType.PERSIST, orphanRemoval=true)
    Profile profile

    @OneToOne(mappedBy="person", cascade=CascadeType.PERSIST, orphanRemoval=true)
    Payroll payroll

    String getFullName() {
        "${firstName} ${lastName} [$id]"
    }

    static class NotFoundException extends RuntimeException {
        NotFoundException() {
            super("The person was not found")
        }
    }

}
