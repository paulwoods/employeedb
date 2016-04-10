package org.mrpaulwoods.employee.security

import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.*

@Entity
class User implements UserDetails {

    @Id
    @GeneratedValue
    Long id

    @Column(unique = true)
    String username

    String password
    boolean enabled = true
    boolean accountNonExpired = true
    boolean accountNonLocked = true
    boolean credentialsNonExpired = true

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Authority> authorities = []

}
