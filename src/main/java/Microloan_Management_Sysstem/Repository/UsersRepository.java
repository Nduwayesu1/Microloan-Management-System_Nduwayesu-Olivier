package Microloan_Management_Sysstem.Repository;

import Microloan_Management_Sysstem.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    // This will be used to interact with the database
    Users findByPhone(String telephone);


}
