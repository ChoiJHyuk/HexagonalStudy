package com.rosoa0475.hexagonalstudy.adapter.out.persistence;

import com.rosoa0475.hexagonalstudy.application.port.out.LoadAccountPort;
import com.rosoa0475.hexagonalstudy.application.port.out.SaveAccountPort;
import com.rosoa0475.hexagonalstudy.domain.AccountDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort, SaveAccountPort {
    private final AccountJpaRepository accountJpaRepository;
    private final AccountMapper accountMapper;
    @Override
    public AccountDomain load(Long id) {
        Optional<AccountEntity> oae = accountJpaRepository.findById(id);
        if(oae.isPresent()) {
            return accountMapper.toDomain(oae.get());
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void save(AccountDomain accountDomain) {
        AccountEntity accountEntity = accountMapper.toEntity(accountDomain);
        accountJpaRepository.save(accountEntity);
    }
}
