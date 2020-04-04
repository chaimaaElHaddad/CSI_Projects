package csi.master.gestion_des_formations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import csi.master.gestion_des_formations.entities.User;
import csi.master.gestion_des_formations.services.SecurityServiceI;
import csi.master.gestion_des_formations.services.UserServiceI;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserServiceI userService;
	
	@Autowired
    private SecurityServiceI securityService;


	@PostMapping(value = "/create")
	public User createUser(@RequestBody User u) {
		return userService.save(u);
	}

	@PutMapping(value = "/update/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.update(id, user);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.delete(id);

	}

	@GetMapping(value = "/formateurs")
	public List<User> getFormateurs() {

		return userService.getByRole("FORMATEUR");
	}

	@GetMapping(value = "/beneficiaires")
	public List<User> getBeneficiaires() {

		return userService.getByRole("BENEFICIAIRE");
	}

	@GetMapping("/formateur/{id}")
	public User getFormateurById(@PathVariable Long id) {
		User user = userService.getById(id);
		if (user != null) {
			if (user.getRole() == "FORMATEUR") {
				return user;
			}
		}
		return null;
	}

	@GetMapping("/beneficiaire/{id}")
	public User getBeneficiaireById(@PathVariable Long id) {
		User user = userService.getById(id);
		if (user != null) {
			if (user.getRole() == "BENEFICIAIRE") {
				return user;
			}
		}
		return null;
	}

	@PostMapping("/registration")
	public User registration(@RequestBody User userForm) {

		if (userService.findByUsername(userForm.getUsername()) != null)
			return null;

		User user = userService.save(userForm);

		return user;
	}

	@GetMapping("/login")
	public User login() {
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();

		String username = authentication.getName();

		return userService.findByUsername(username);
	}
	
	
	
	//********************************** added by Intissar ***************************
	@GetMapping("/registrationOauth")
    public ModelAndView registration(Model model) {
//        model.addAttribute("userForm", new User());

        return new ModelAndView( "registration");
    }

    @PostMapping("/registrationOauth")
    public ModelAndView registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
//        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return new ModelAndView("loginSuccess");
    }

    @GetMapping("/loginOauth")
    public ModelAndView login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");

        return new ModelAndView("loginSuccess");
    }

}
