package Ej3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class passwordSecureTest {

    @Test
    void generatePasswordHash() {

    }

    @Test
    void validatePassword() {

        passwordSecure passwordSecure = new passwordSecure();

        Assertions.assertEquals(true, passwordSecure.validatePassword(String.valueOf("1234".toCharArray()),passwordSecure.generatePasswordHash("1234")));
    }
}