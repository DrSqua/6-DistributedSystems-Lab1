package app.AccountBalance;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/balance")
    AccountBalance newAccountBalance(@RequestBody AccountBalance newBalance) {
        return repository.save(newBalance);
    }
}
