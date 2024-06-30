package com.rosoa0475.hexagonalstudy.adapter.in.web;

import com.rosoa0475.hexagonalstudy.application.port.in.DepositUseCase;
import com.rosoa0475.hexagonalstudy.application.port.in.WithdrawUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountAccessAdapter {
    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;

    @PostMapping("/deposit/{id}/{amount}")
    public void deposit(@PathVariable Long id, @PathVariable BigDecimal amount) {
        depositUseCase.deposit(id, amount);
    }

    @PostMapping("/withdraw/{id}/{amount}")
    public void withdraw(@PathVariable Long id, @PathVariable BigDecimal amount) {
        withdrawUseCase.withdraw(id, amount);
    }
}
