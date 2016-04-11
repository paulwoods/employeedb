package org.mrpaulwoods.employee.profile

import org.mrpaulwoods.employee.person.Person
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created on 3/7/2016.
 */
interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByPerson(Person person)
}
