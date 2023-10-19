package az.booking.bookshop.service;

import az.booking.bookshop.entity.Account;
import az.booking.bookshop.model.response.AccountDTO;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomMapper accountMapper;

    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.accountToAccountDTO(accounts);
    }
}
