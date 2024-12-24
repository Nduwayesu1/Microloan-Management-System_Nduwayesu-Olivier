package Microloan_Management_Sysstem.Model;

import Microloan_Management_Sysstem.Model.Enum.Status;
import jakarta.persistence.*;

import java.util.UUID;
@Entity
public class Loans {
    // this the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private int amount;
    private int monthly_income;
    @Enumerated(EnumType.STRING)
    private Status status;

    // constructors without field

    public Loans() {
    }
    // constructors with primary key

    public Loans(UUID id) {
        this.id = id;
    }

    // constructors with all fields


    public Loans(UUID id, Users user, int amount, int monthly_income, Status status) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.monthly_income = monthly_income;
        this.status = status;
    }

    // setters and getters method


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(int monthly_income) {
        this.monthly_income = monthly_income;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
