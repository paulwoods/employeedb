package org.mrpaulwoods.employee.person

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

import javax.validation.Valid

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping(value = "/person")
@Slf4j
class PersonController {

    private final PersonRepository personRepository

    @Autowired
    PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository
    }

    @RequestMapping(method=GET)
    String index(final Model model) {
        log.info "index"
        model.addAttribute "people", personRepository.findAll()
        "person/index"
    }

    @RequestMapping(value="/create", method=GET)
    String create(final Model model) {
        log.info "create"
        model.addAttribute "personForm", new PersonForm()
        "person/create"
    }

    @RequestMapping(value="/save", method= POST)
    String save(final Model model, @Valid PersonForm personForm, BindingResult bindingResult) {
        log.info "save personForm={}", personForm.dump()
        if (bindingResult.hasErrors()) {
            "person/create"
        } else {
            Person person = new Person()
            personForm.update person
            personRepository.save person
            "redirect:/person/show/${person.id}"
        }
    }

    @RequestMapping(value="/show/{id}", method=GET)
    String show(final Model model, @PathVariable Long id) {
        log.info "show id={}", id
        Person person = personRepository.getOne(id)
        if(person) {
            model.addAttribute "person", person
            "person/show"
        } else {
            throw new Person.NotFoundException()
        }
    }

    @RequestMapping(value="/edit/{id}", method=GET)
    String edit(final Model model, @PathVariable Long id) {
        log.info "edit id={}", id
        Person person = personRepository.getOne(id)
        if(person) {
            model.addAttribute "person", person
            model.addAttribute "personForm", new PersonForm(person)
            "person/edit"
        } else {
            throw new Person.NotFoundException()
        }
    }

    @RequestMapping(value="/update/{id}", method= POST)
    String update(final Model model, @PathVariable Long id, @Valid PersonForm personForm, BindingResult bindingResult) {
        log.info "update id={}, personForm={}", id, personForm.dump()
        Person person = personRepository.getOne(id)
        if(person) {
            if (bindingResult.hasErrors()) {
                model.addAttribute "person", person
                "person/edit"
            } else {
                personForm.update person
                personRepository.save person
                "redirect:/person/show/${person.id}"
            }
        } else {
            throw new Person.NotFoundException()
        }
    }

    @RequestMapping(value="/confirm/{id}", method=GET)
    String confirm(final Model model, @PathVariable Long id) {
        log.info "confirm id={}", id
        Person person = personRepository.getOne(id)
        if(person) {
            model.addAttribute "person", person
            "person/confirm"
        } else {
            throw new Person.NotFoundException()
        }
    }

    @RequestMapping(value="/delete/{id}", method= POST)
    String delete(final Model model, @PathVariable Long id) {
        log.info "delete id={}", id
        Person person = personRepository.getOne(id)
        if(person) {
            personRepository.delete(id)
            "redirect:/person"
        } else {
            throw new Person.NotFoundException()
        }
    }

}
