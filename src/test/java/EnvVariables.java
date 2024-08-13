public class EnvVariables {
    public static void main(String[] args) {
        // Reading environment variables
        String loginUrl = System.getenv("LOGIN_URL");
        String acceptHeader = System.getenv("ACCEPT_HEADER");
        String contentTypeHeader = System.getenv("CONTENT_TYPE_HEADER");
        String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");

        // Print variables (for debugging purposes)
        System.out.println("LOGIN_URL: " + loginUrl);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Use these variables in your application logic, e.g., making HTTP requests
    }
}
