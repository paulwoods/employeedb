package org.mrpaulwoods.employee.profile

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
@RequestMapping(value = "/profile")
@Slf4j
class ProfileController {

    private final ProfileRepository profileRepository

    @Autowired
    ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository
    }

    @RequestMapping(method=GET)
    String index(final Model model) {
        model.addAttribute "profiles", profileRepository.findAll()
        "profile/index"
    }

    @RequestMapping(value="/create/{personId}", method=GET)
    String create(final Model model, @PathVariable Long personId) {
        log.info "create personId={}", personId
        model.addAttribute "profileForm", new ProfileForm(personId: personId)
        "profile/create"
    }

    @RequestMapping(value="/save", method= POST)
    String save(final Model model, @Valid ProfileForm profileForm, BindingResult bindingResult) {
        log.info "save profileForm={}", profileForm.dump()
        if (bindingResult.hasErrors()) {
            "profile/create"
        } else {
            Profile profile = new Profile()
            profileForm.update profile
            profileRepository.save profile
            "redirect:/profile/show/${profile.id}"
        }
    }

    @RequestMapping(value="/show/{id}", method=GET)
    String show(final Model model, @PathVariable Long id) {
        log.info "show id={}", id
        Profile profile = profileRepository.getOne(id)
        if(profile) {
            model.addAttribute "profile", profile
            "profile/show"
        } else {
            throw new Profile.NotFoundException()
        }
    }

    @RequestMapping(value="/edit/{id}", method=GET)
    String edit(final Model model, @PathVariable Long id) {
        log.info "edit id={}", id
        Profile profile = profileRepository.getOne(id)
        if(profile) {
            model.addAttribute "profile", profile
            model.addAttribute "profileForm", new ProfileForm(profile)
            "profile/edit"
        } else {
            throw new Profile.NotFoundException()
        }
    }

    @RequestMapping(value="/update/{id}", method= POST)
    String update(final Model model, @PathVariable Long id, @Valid ProfileForm profileForm, BindingResult bindingResult) {
        log.info "update id={}, profileForm={}", id, profileForm.dump()
        Profile profile = profileRepository.getOne(id)
        if(profile) {
            if (bindingResult.hasErrors()) {
                model.addAttribute "profile", profile
                "profile/edit"
            } else {
                profileForm.update profile
                profileRepository.save profile
                "redirect:/profile/show/${profile.id}"
            }
        } else {
            throw new Profile.NotFoundException()
        }
    }

    @RequestMapping(value="/confirm/{id}", method=GET)
    String confirm(final Model model, @PathVariable Long id) {
        log.info "confirm id={}", id
        Profile profile = profileRepository.getOne(id)
        if(profile) {
            model.addAttribute "profile", profile
            "profile/confirm"
        } else {
            throw new Profile.NotFoundException()
        }
    }

    @RequestMapping(value="/delete/{id}", method= POST)
    String delete(final Model model, @PathVariable Long id) {
        log.info "delete id={}", id
        Profile profile = profileRepository.getOne(id)
        if(profile) {
            profile.person.profile = null // unlink the profile and person
            profileRepository.delete(id)
            "redirect:/profile"
        } else {
            throw new Profile.NotFoundException()
        }
    }
}
