public class Admin {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    public static boolean login(String user, String pass) {
        return USERNAME.equals(user) && PASSWORD.equals(pass);
    }
}
