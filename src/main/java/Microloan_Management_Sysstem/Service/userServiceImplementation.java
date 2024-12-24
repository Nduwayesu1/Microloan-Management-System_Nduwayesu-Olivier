package Microloan_Management_Sysstem.Service;

import Microloan_Management_Sysstem.Model.Enum.user_type;
import Microloan_Management_Sysstem.Model.Users;
import Microloan_Management_Sysstem.Repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class userServiceImplementation implements  usersServices{

    private final UsersRepository userRepository;

    public userServiceImplementation(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users registerUser(Users user) {
        return userRepository.save(user);
    }

    private boolean isValidContactNumber(String contact) {
        // Validates if the contact number follows the required pattern
        return contact.matches("^(078|079|072|073)\\d{7}$");
    }

    @Override
    public Users login(String telephone, String password, user_type role) {
        Users existingUser = findByPhone(telephone);

        if (existingUser != null &&
                password.equals(existingUser.getPassword()) && // Direct comparison without encoding
                existingUser.getUserType().equals(role)) {
            return existingUser; // Return the authenticated user
        }

        return null; // Return null if no user found or credentials don't match
    }

    @Override
    public Users findByPhone(String telephone) {
        return userRepository.findByPhone(telephone);
    }


    @Override
    public Users findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

}
