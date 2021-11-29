@FieldEquals(firstField = "password", secondField = "retypedPassword")
class Login {
    private final String password;
    private final String retypedPassword;

    public Login(String password, String retypedPassword) {
        this.password = password;
        this.retypedPassword = retypedPassword;
    }
}

@FieldEquals(firstField = "password", secondField = "unknown")
class LoginWrongFields {
    private final String password;
    private final String retypedPassword;

    public LoginWrongFields(String password, String retypedPassword) {
        this.password = password;
        this.retypedPassword = retypedPassword;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(
                FieldEqualsValidator.validate(new Login("test", "test")));
        System.out.println(
                FieldEqualsValidator.validate(new Login("test", "another")));
        System.out.println(
                FieldEqualsValidator.validate(new LoginWrongFields("test", "test")));
        System.out.println(
                FieldEqualsValidator.validate(new LoginWrongFields("test", "another")));
    }
}
