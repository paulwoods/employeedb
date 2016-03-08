package org.mrpaulwoods.employee.profile

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * Created on 3/7/2016.
 */
@Controller
@RequestMapping(value = "/profile")
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

}
