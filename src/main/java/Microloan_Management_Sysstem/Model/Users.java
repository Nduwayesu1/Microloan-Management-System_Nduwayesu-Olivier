package Microloan_Management_Sysstem.Model;

import Microloan_Management_Sysstem.Model.Enum.user_type;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 10)
    private String first_name;
    @Column(length = 10)
    private String last_name;
    @Column(length = 10,unique = true)
    private String telephone;
    @Enumerated(EnumType.STRING)
    private user_type userType;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Loans> loans;


    //constructors without field

    public Users() {
    }

    // constructors with primary key

    public Users(UUID id) {
        this.id = id;
    }
    // constructors with filed


    public Users(UUID id, String first_name, String last_name, String telephone, user_type userType, String password, List<Loans> loans) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.userType = userType;
        this.password = password;
        this.loans = loans;
    }

    // setters and getters method

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public user_type getUserType() {
        return userType;
    }

    public void setUserType(user_type userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
