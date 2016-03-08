package org.mrpaulwoods.employee.personnel

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created on 3/7/2016.
 */
@Entity
class Personnel implements Serializable {

    @Id
    @GeneratedValue
    Long id

    String firstName
    String lastName
}
