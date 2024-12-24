package Microloan_Management_Sysstem.Service;

import Microloan_Management_Sysstem.Model.Enum.Status;
import Microloan_Management_Sysstem.Model.Loans;
import Microloan_Management_Sysstem.Model.Users;
import Microloan_Management_Sysstem.Repository.LoansRepository;
import Microloan_Management_Sysstem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoanSericeImpl implements LoanService{

    // use autowired to inject all dependencies and propertied from the field
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private LoansRepository loansRepository;
    @Override
    public Loans loanApplication(UUID users_id, Loans loans) {
        Users user = userRepository.findById(users_id)
                .orElseThrow(() -> new RuntimeException("User not found"));


        loans.setUser(user);

        loans.setStatus(Status.pending); // Default status

        return loansRepository.save(loans);

    }


}
