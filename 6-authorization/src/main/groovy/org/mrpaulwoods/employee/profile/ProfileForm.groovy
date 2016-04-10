package org.mrpaulwoods.employee.profile

import org.mrpaulwoods.employee.person.Person

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created on 3/13/2016.
 */
class ProfileForm {

    Long id

    @NotNull
    Long personId

    @NotNull
    @Size(min=1, max=100)
    String street

    @NotNull
    @Size(min=1, max=100)
    String city

    @NotNull
    @Size(min=1, max=100)
    String state

    @NotNull
    @Size(min=1, max=100)
    String zip

    ProfileForm() {
    }

    ProfileForm(Profile profile) {
        this.id = profile.id
        this.personId = profile.person.id
        this.street = profile.street
        this.city = profile.city
        this.state = profile.state
        this.zip = profile.zip
    }

    void update(Profile profile) {
        profile.person = new Person(id:personId)
        profile.street = street
        profile.city = city
        profile.state = state
        profile.zip = zip
    }
    
}
