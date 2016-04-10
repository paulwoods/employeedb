package org.mrpaulwoods.employee.security

import org.springframework.security.core.GrantedAuthority

import javax.persistence.*

@Entity
class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    Long id

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    User user

    String authority

}
