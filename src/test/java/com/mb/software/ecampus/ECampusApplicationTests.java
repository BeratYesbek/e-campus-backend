package com.mb.software.ecampus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.mb.software.ecampus.core.security.encryption.PasswordHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ECampusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void verifyPassword() {
     String hashedPassword =    PasswordHelper.hashPassword("123456");
     boolean result = PasswordHelper.verifyPassword("123456",hashedPassword);

     assertEquals(true,result);
    }

}
