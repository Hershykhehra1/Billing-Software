package in.harshaunkhehra.billingsoftware.service;

import java.util.List;

import in.harshaunkhehra.billingsoftware.io.UserRequest;
import in.harshaunkhehra.billingsoftware.io.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);

}
