package org.mrpaulwoods.employee.person

import org.mrpaulwoods.employee.payroll.PayrollRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

/**
 * Created on 3/13/2016.
 */
@Service
@Transactional
class PersonService {

    final PersonRepository personRepository

    @Autowired
    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository
    }

    Person create(PersonForm personForm) {
        Person person = new Person()
        personForm.update person
        personRepository.save person
    }
}
