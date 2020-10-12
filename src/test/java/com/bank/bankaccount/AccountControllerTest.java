package com.bank.bankaccount;

import com.bank.bankaccount.controllers.AccountController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountControllerTest {
    @Autowired
    private AccountController controller;

    @Test
    public void contextLoads() {
        Assertions.assertThat(controller).isNotNull();
    }
}
