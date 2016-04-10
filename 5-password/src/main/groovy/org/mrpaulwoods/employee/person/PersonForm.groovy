package org.mrpaulwoods.employee.person

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created on 3/13/2016.
 */
class PersonForm implements Serializable {

    Long id

    @NotNull
    @Size(min=1, max=100)
    String firstName

    @NotNull
    @Size(min=1, max=100)
    String lastName

    PersonForm() {
    }

    PersonForm(Person person) {
        this.id = person.id
        this.firstName = person.firstName
        this.lastName = person.lastName
    }

    void update(Person person) {
        person.firstName = firstName
        person.lastName = lastName
    }

    String getFullName() {
        "${firstName} ${lastName} [$id]"
    }

}
