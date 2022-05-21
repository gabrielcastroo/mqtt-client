package auth;

public class Credentials {

    private static String host = "f5c333233b4844a3a3c621706d87d512.s1.eu.hivemq.cloud";
    private static String userName = "teste_origem_motos";
    private static String password = "Origemmotos8";

    public Credentials(String host, String userName, String password) {
        this.host = host;
        this.userName = userName;
        this.password = password;
    }

    public static String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public static String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
