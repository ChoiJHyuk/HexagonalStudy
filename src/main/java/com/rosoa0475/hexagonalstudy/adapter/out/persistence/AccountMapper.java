package com.rosoa0475.hexagonalstudy.adapter.out.persistence;

import com.rosoa0475.hexagonalstudy.domain.AccountDomain;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDomain toDomain(AccountEntity accountEntity) {
        return AccountDomain.builder()
                .id(accountEntity.getId())
                .balance(accountEntity.getBalance())
                .build();
    }

    public AccountEntity toEntity(AccountDomain accountDomain) {
        return AccountEntity.builder()
                .id(accountDomain.getId())
                .balance(accountDomain.getBalance())
                .build();
    }
}
