package Ej2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.*;

class passwordSecureTest {

    @Test
    void testHashPassword() throws NoSuchAlgorithmException, InvalidKeySpecException {

        String passwordEncode = passwordSecure.generatePasswordHash("1234567890");

        System.out.println(passwordEncode);

        Assertions.assertNotEquals(null, passwordEncode);
    }

    @Test
    void testValidatePassword () throws NoSuchAlgorithmException, InvalidKeySpecException {

        String pass1 = "1000:8e5d46d9162af5b8bf1c8ad397dd6cfa:e34bffcf0ff4a3e84cc5a1b7fa21f2a5262c78804306e91bec677389a59ca935706035757f415b19b74df5d3bbd0c7e5146019a139ad5884b68bf3a09a55c5c0";
        String pass2 = "1000:95782e2901b355311f76156c3e2b8168:0d581cb3f3368cc89e650d7e9734b4c9b60bbe89b1fa1c8a9202c0460ac4bbe0d9785ce766968ed5477d6d095251fc47e97b44d6d35af02f3bf9ac006b95a0a2";

        Assertions.assertEquals(true, passwordSecure.validatePassword("1234567890", pass2));
    }
}