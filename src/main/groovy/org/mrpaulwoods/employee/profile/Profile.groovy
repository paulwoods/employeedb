package org.mrpaulwoods.employee.profile

import org.mrpaulwoods.employee.person.Person

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.MapsId
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
    Person person

    String street

    String city

    String state

    String zip

}
