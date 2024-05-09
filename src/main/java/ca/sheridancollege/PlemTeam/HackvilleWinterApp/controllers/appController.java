package ca.sheridancollege.PlemTeam.HackvilleWinterApp.controllers;

import ca.sheridancollege.PlemTeam.HackvilleWinterApp.beans.user;
import ca.sheridancollege.PlemTeam.HackvilleWinterApp.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@EnableMongoRepositories
public class appController {

    UserRepository userRepo;
    @GetMapping("/")
    public String goHome(){

        return "index.html";
    }

    //creation of user
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new user());
        return "create.html";

    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute user user){
        userRepo.save(user);
        System.out.println("User with email " + user.getEmail() + " logged in");
        return "redirect:/home";
    }

    //when the customer goes to the login page
    @GetMapping("/logIn")
    public String logIn(Model model){
        model.addAttribute("user", new user());
        return "login.html";
    }

    @PostMapping("/logUser")
    public String logUser(@ModelAttribute user user, Model model, HttpSession session){
        for(user u : userRepo.findAll()){
            if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())){
                session.setAttribute("loggedUser", u);
                return "redirect:/home";
            }
        }
        model.addAttribute("error", "Invalid login credentials");
        return "logIn";
    }

    @PostMapping("/addUser")
    public String addUser(Model model){

        return "home.html";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        user loggedUser = (user) session.getAttribute("loggedUser");
        if(loggedUser == null){
            return "redirect:/logIn";
        }
        model.addAttribute("user", loggedUser);
        return "home.html";
    }

    @GetMapping("/profile")
    public String userProfile() {
        return "profile.html";
    }

    @GetMapping("/emergencyContacts")
    public String contact() {
        return "emergencyContacts.html";
    }

    @GetMapping("/map")
    public String roadMap() {
        return "map.html";
    }



}

