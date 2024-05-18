package inventorymanagementsystem;
import java.util.Scanner;
class UserManagement {
    private User[] users;
    private int size;
    private static final int MAX_USERS = 100;

    public UserManagement() {
        this.users = new User[MAX_USERS];
        this.size = 0;
    }

    public void createUser(String username, String role) {
        if (size < MAX_USERS) {
            users[size] = new User(username, role);
            size++;
        } else {
            throw new IllegalStateException("Cannot create user. Maximum user capacity reached.");
        }
    }

    public void updateUser(String username, String newRole) {
        for (int i = 0; i < size; i++) {
            if (users[i].getUsername().equals(username)) {
                users[i].setRole(newRole);
                return;
            }
        }
        throw new IllegalArgumentException("User not found!");
    }

    public void deleteUser(String username) {
        for (int i = 0; i < size; i++) {
            if (users[i].getUsername().equals(username)) {
                shiftUsersLeft(i);
                size--;
                return;
            }
        }
        throw new IllegalArgumentException("User not found!");
    }

    private void shiftUsersLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            users[i] = users[i + 1];
        }
        users[size - 1] = null;
    }
}
