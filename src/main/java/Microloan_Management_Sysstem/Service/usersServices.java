package Microloan_Management_Sysstem.Service;

import Microloan_Management_Sysstem.Model.Enum.user_type;
import Microloan_Management_Sysstem.Model.Users;

import java.util.List;
import java.util.UUID;

public interface usersServices {
    // this contains Method Signature
    Users registerUser(Users user);
    Users login(String telephone,String pasword, user_type role);
    Users findByPhone(String telephone);

    Users findById(UUID id);
//    public List<Users> gettAll();

//    Users findById(UUID id);
}
