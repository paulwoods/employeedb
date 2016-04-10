package org.mrpaulwoods.employee.api

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created on 4/6/2016.
 */
@RestController
@RequestMapping(value = "/api/1")
@PreAuthorize("hasRole('ROLE_XYZ')")
class ApiController {

    @PreAuthorize("hasRole('ROLE_XYZ')")
    @RequestMapping(value = "/home")
    Message home() {
        new Message()
    }
}
