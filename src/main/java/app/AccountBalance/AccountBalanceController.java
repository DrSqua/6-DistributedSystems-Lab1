package app.AccountBalance;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountBalanceController {
    static class AccountBalanceNotFoundException extends RuntimeException {
        AccountBalanceNotFoundException(long account_identifier) {
            super("Could not find balance " + account_identifier);
        }
    }

    private final AccountBalanceRepository repository;

    AccountBalanceController(AccountBalanceRepository repository) {
        this.repository = repository;
    }

    // Query
    @GetMapping("/balance")
    List<AccountBalance> query() {
        return repository.findAll();
    }

    // Get Unique
    @GetMapping("/balance/{balance_identifier}")
    AccountBalance get(@PathVariable long balance_identifier) {
        return repository.findById(balance_identifier).orElseThrow(() -> new AccountBalanceNotFoundException(balance_identifier));
    }

    // Create New
    @PostMapping("/balance")
    AccountBalance newAccountBalance(@RequestBody AccountBalance newBalance) {
        // Ensure the ID is not set to avoid conflicts
        AccountBalance accountBalance = new AccountBalance(newBalance.getUser_identifier(), newBalance.getBalance());
        return repository.save(accountBalance);
    }

    // Delete
    @DeleteMapping("/balance/{balance_identifier}")
    void delete(@PathVariable long balance_identifier) {
        repository.deleteById(balance_identifier);
    }
}
