package Microloan_Management_Sysstem.Controler;

import Microloan_Management_Sysstem.Model.Users;
import Microloan_Management_Sysstem.Service.usersServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class usersLoginController {

  @Autowired
  private usersServices usersService;
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new Users());  // Add an empty User object to the model
        return "login"; // Return the login page
    }
    //login
    @PostMapping("/post-login")
    public String postLogin(@ModelAttribute("user") Users user, HttpSession session) {
        // Authenticate the user based on the provided email, password, and role
        Users authenticatedUser = usersService.login(user.getTelephone(), user.getPassword(), user.getUserType());

        if (authenticatedUser != null) {
            // Store the user's role, username, and userId in the session after successful login
            session.setAttribute("role", authenticatedUser.getUserType());
            session.setAttribute("loggedInUsername", authenticatedUser.getFirst_name());
            session.setAttribute("userId", authenticatedUser.getId());

            // Redirect based on the user's role
            if ("admin".equals(authenticatedUser.getUserType())) {
                return "redirect:/payments/payments"; // Redirect to admin dashboard
            } else if ("end_user".equals(authenticatedUser.getUserType())) {
                return "redirect:/users/usersList"; // Redirect to customer dashboard
            } else {
                // Redirect to 403 page for other roles
                return "redirect:/403";
            }
        } else {
            // If authentication failed, redirect back to login with an error message
            return "redirect:/login?error=true";
        }
    }
}
