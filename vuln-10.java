package jwt_test.jwt_test_1;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class App
{

    static String secret = "secret";

    private static void bad1() {
        try {
            // ruleid: java-jwt-hardcoded-secret
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    private static void ok1(String secretKey) {
        try {
            // ok: java-jwt-hardcoded-secret
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    public static void main( String[] args )
    {
        bad1();
        ok1(args[0]);
    }
}

abstract class App2
{
// ruleid: java-jwt-hardcoded-secret
    abstract class App2
    {
        public void bad2() {
            try {
                // Retrieve the secret key from an environment variable
                String secretKey = System.getenv("SECRET_KEY");
                if (secretKey == null) {
                    throw new IllegalArgumentException("SECRET_KEY environment variable not set");
                }

                Algorithm algorithm = Algorithm.HMAC256(secretKey);
                String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            } catch (JWTCreationException exception){
                //Invalid Signing configuration / Couldn't convert Claims.
            }
        }
    }

    public void bad2() {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }

}
