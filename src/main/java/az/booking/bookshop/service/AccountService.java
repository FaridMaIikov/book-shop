package az.booking.bookshop.service;

import az.booking.bookshop.entity.Account;
import az.booking.bookshop.exception.NotFoundException;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.model.request.AccountRequest;
import az.booking.bookshop.model.request.SignUpRequest;
import az.booking.bookshop.model.response.AccountResponse;
import az.booking.bookshop.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomMapper accountMapper;

    public List<AccountResponse> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.accountToAccountDTO(accounts);
    }

    public Account add(SignUpRequest signUpRequest) {
        if (!accountRepository.existsByUsername(signUpRequest.getUsername())) {
            Account account = accountMapper.signUpRequestToEntity(signUpRequest);
            return accountRepository.save(account);
        }
        throw new RuntimeException("Account not saved");
    }

    public void update(Long id, AccountRequest accountRequest) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Not found account "+id));
        if (!(accountRequest.getUsername()== null))
            account.setUsername(accountRequest.getUsername());
        if (!(accountRequest.getPassword() == null))
            account.setPassword(accountRequest.getPassword());
        accountRepository.save(account);
    }

    public void delete(Account account) {
        accountRepository.delete(account);
    }
}
