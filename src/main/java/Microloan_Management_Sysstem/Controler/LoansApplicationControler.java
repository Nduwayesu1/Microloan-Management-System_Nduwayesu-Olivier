package Microloan_Management_Sysstem.Controler;

import Microloan_Management_Sysstem.Model.Loans;
import Microloan_Management_Sysstem.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

public class LoansApplicationControler {


    // inject Loan service
    @Autowired
    private LoanService loanService;
    @GetMapping("/register")
    public String showCreateClaimForm(Model model) {
        model.addAttribute("claim", new Loans()); // Provide an empty Claim object for the form
        return "createLoans"; // Render the create_claim.html template
    }

    @PostMapping("/register")
    public String createClaim(@RequestParam("userId") UUID userId,
                              @ModelAttribute("claim") Loans loans,
                              Model model) {
        try {
            // Save the claim with the associated userId and policyId
            Loans createdLoan= loanService.loanApplication(userId, loans);
            model.addAttribute("message", "Loans created successfully!"); // Add success message
        } catch (IllegalArgumentException ex) {
            // Handle errors, such as invalid userId or policyId
            model.addAttribute("errorMessage", ex.getMessage()); // Add error message
            return "createLoans"; // Return to the form with the error message
        }
        model.addAttribute("claim", new Loans()); // Reset the form with an empty claim
        return "createLoans"; // Render the same form with success feedback
    }
}
