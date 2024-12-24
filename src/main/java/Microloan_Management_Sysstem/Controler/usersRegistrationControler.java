package Microloan_Management_Sysstem.Controler;

import Microloan_Management_Sysstem.Model.Users;
import Microloan_Management_Sysstem.Repository.UsersRepository;
import Microloan_Management_Sysstem.Service.usersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class usersRegistrationControler {


    @Autowired
    private final usersServices userService;
    @Autowired
    private UsersRepository userRepository;  // Assumed that UserRepository is defined for accessing the database
    public usersRegistrationControler(usersServices userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "register"; // Renders the register.html template
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Users user, Model model) {
        try {
            // Try to register the user
            userService.registerUser(user);
            model.addAttribute("message", "User registered successfully!"); // Add success message
        } catch (IllegalArgumentException ex) {
            // If there's an error (like duplicate contact), add it to the model
            model.addAttribute("errorMessage", ex.getMessage());
            return "register"; // Return to the form with the error message
        }
        model.addAttribute("user", new Users()); // Reset the form with an empty user
        return "register"; // Renders success feedback
    }

}
