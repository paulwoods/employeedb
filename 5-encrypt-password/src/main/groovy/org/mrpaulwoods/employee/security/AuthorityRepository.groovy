package org.mrpaulwoods.employee.security

import org.springframework.data.jpa.repository.JpaRepository

interface AuthorityRepository extends JpaRepository<Authority, Long> {

}