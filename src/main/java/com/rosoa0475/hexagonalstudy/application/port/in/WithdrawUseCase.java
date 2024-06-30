package com.rosoa0475.hexagonalstudy.application.port.in;

import java.math.BigDecimal;

public interface WithdrawUseCase {
    boolean withdraw(Long id, BigDecimal amount);
}
