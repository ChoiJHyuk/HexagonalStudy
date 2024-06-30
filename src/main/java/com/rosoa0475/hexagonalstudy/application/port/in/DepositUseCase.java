package com.rosoa0475.hexagonalstudy.application.port.in;

import java.math.BigDecimal;

public interface DepositUseCase {
    void deposit(Long id, BigDecimal amount);
}