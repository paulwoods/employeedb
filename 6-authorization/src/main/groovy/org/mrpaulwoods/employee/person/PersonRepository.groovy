package org.mrpaulwoods.employee.person

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created on 3/7/2016.
 */
interface PersonRepository extends JpaRepository<Person, Long> {
}
