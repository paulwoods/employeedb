package org.mrpaulwoods.employee.home

import groovy.util.logging.Slf4j
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

import javax.transaction.Transactional

/**
 * Created on 3/14/2016.
 */
@Slf4j
@Service
@Transactional
class HomeService {
    void example() {
        def principal = SecurityContextHolder.context?.authentication
        log.info "user = $principal.name"
    }
}
