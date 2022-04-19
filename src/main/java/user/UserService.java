package user;

import java.util.List;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public List<User> getListOfUsers(User currentUser) throws Exception {
        List<User> users;
        if (currentUser.getRole() == UserRole.ADMIN) {
            users = userRepository.executeQuery("SELECT * FROM USER");
        } else {
            throw new Exception("USER is not ADMIN");
        }
        return users;
    }

    public void registeredUser(User user) throws Exception {
        int count = userRepository.executeUpdate("INSERT INTO USER (LOGIN, NAME, AGE, ROLE, PASSWORD) VALUES (?,?,?,?,?)", user);
        if (count == 0) {
            throw new Exception("Sign up failed");
        }
    }

    public User loginUser(String login, String password) throws Exception {
        List<User> users = userRepository.executeQuery("SELECT * FROM USER WHERE LOGIN LIKE '" + login + "' AND PASSWORD LIKE '" + password + "'");
        if (users.size() == 0) {
            throw new Exception("There is no user with such login and password");
        }
        return users.get(0);
    }

}
