package Microloan_Management_Sysstem.Service;

import Microloan_Management_Sysstem.Model.Loans;

import java.util.UUID;

public interface LoanService {

    Loans loanApplication(UUID users_id,Loans loans);
}
