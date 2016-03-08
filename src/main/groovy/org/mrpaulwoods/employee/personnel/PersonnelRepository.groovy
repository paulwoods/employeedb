package org.mrpaulwoods.employee.personnel

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created on 3/7/2016.
 */
interface PersonnelRepository extends JpaRepository<Personnel, Long> {
}
