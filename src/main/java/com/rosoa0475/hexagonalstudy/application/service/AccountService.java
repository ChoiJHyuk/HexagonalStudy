package com.rosoa0475.hexagonalstudy.application.service;

import com.rosoa0475.hexagonalstudy.application.port.in.DepositUseCase;
import com.rosoa0475.hexagonalstudy.application.port.in.WithdrawUseCase;
import com.rosoa0475.hexagonalstudy.application.port.out.LoadAccountPort;
import com.rosoa0475.hexagonalstudy.application.port.out.SaveAccountPort;
import com.rosoa0475.hexagonalstudy.domain.AccountDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService implements DepositUseCase, WithdrawUseCase {
    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;


    @Override
    public void deposit(Long id, BigDecimal amount) {
        AccountDomain accountDomain = loadAccountPort.load(id);
        accountDomain.deposit(amount);
        saveAccountPort.save(accountDomain);
    }

    @Override
    public boolean withdraw(Long id, BigDecimal amount) {
        AccountDomain accountDomain = loadAccountPort.load(id);
        boolean result = accountDomain.withdraw(amount);
        if(result)
            saveAccountPort.save(accountDomain);
        return result;
    }
}
