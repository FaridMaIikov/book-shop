package az.booking.bookshop.controller;

import az.booking.bookshop.entity.Account;
import az.booking.bookshop.model.request.AccountRequest;
import az.booking.bookshop.model.response.AccountResponse;
import az.booking.bookshop.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return accountService.getAllAccounts();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody AccountRequest accountRequest){
        accountService.update(id, accountRequest);
    }

    @DeleteMapping
    public void delete(Account account) {
        accountService.delete(account);
    }

}