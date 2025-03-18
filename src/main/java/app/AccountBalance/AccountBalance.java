package app.AccountBalance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public//  JPA annotation to make this object ready for storage in a JPA-based data store.
class AccountBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID
    private Long id;

    private String user_identifier;
    private int balance;

    // Constructor without ID (used for creating new instances)
    public AccountBalance(String user_identifier, int balance) {
        this.user_identifier = user_identifier;
        this.balance = balance;
    }

    public AccountBalance() {

    }

    public String getUser_identifier() {
        return user_identifier;
    }

    public void setUser_identifier(String user_identifier) {
        this.user_identifier = user_identifier;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }
}
