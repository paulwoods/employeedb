package org.mrpaulwoods.employee.profile

import org.mrpaulwoods.employee.personnel.Personnel

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

/**
 * Created on 3/7/2016.
 */
@Entity
class Profile implements Serializable {

    @Id
    @GeneratedValue
    Long id

    @OneToOne
    @JoinColumn(name="person_id")
    Personnel person

    String street
    String city
    String state
    String zip

}
