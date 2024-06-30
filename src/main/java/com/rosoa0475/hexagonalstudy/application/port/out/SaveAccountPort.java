package com.rosoa0475.hexagonalstudy.application.port.out;

import com.rosoa0475.hexagonalstudy.domain.AccountDomain;

public interface SaveAccountPort {
    void save(AccountDomain accountDomain);
}
