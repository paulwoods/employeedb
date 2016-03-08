package org.mrpaulwoods.employee.payroll

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created on 3/7/2016.
 */
interface SalaryRepository extends JpaRepository<Salary, Long> {
}
