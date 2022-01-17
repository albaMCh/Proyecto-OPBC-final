package Ej3;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class passwordSecure {

    private Argon2 argon2;

    public passwordSecure (){

        this.argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    }

    public String generatePasswordHash (String password){

        return argon2.hash(4, 1024 * 1024, 8,password.toCharArray());
    }

    public  boolean validatePassword(String originalPassword, String storedPassword){

        return argon2.verify(originalPassword, storedPassword.toCharArray());
    }
}
