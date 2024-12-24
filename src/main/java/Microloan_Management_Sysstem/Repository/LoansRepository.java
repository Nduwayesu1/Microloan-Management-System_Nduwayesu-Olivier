package Microloan_Management_Sysstem.Repository;

import Microloan_Management_Sysstem.Model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LoansRepository extends JpaRepository<Loans,UUID> {

    // This will be used to interact with the database
}
