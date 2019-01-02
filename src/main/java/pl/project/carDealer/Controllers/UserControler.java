package pl.project.carDealer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.project.carDealer.Repositories.UserRepositories;
import pl.project.carDealer.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping( "/user" )
public class UserControler {


    @Autowired
    public UserRepositories userRepositories;

    @GetMapping( "/register" )
    public String showAddNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

//    @PostMapping("/save")
//    public String saveUser(@ModelAttribute("user") User user) {
//        spitterUserService.save(user);
//        return "redirect:/";
//    }

    @GetMapping( value = "/login" )
    public String login(Model model, String error, String logout, RedirectAttributes ra) {
        return "login";
    }

    @RequestMapping( value = "/logout", method = RequestMethod.GET )
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }


}

