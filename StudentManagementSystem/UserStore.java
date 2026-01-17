import java.util.ArrayList;

public class UserStore {

    static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(
                "admin",
                PasswordUtil.hashPassword("1234"),
                "ADMIN"
        ));

        users.add(new User(
                "staff",
                PasswordUtil.hashPassword("staff123"),
                "STAFF"
        ));
    }

    public static User authenticate(String inputUser, String inputPass) {

        String hash = PasswordUtil.hashPassword(inputPass);

        for (User u : users) {
            if (u.username.equals(inputUser)
                    && u.passwordHash.equals(hash)) {
                return u;
            }
        }
        return null;
    }
}
