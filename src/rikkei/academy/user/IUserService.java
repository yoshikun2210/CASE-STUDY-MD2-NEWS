package rikkei.academy.user;

import rikkei.academy.model.role.User;
import rikkei.academy.service.IGenericService;

public interface IUserService extends IGenericService<User> {

    boolean existedByUsername(String username);

    boolean existedByEmail(String email);

    boolean checkLogin(String username, String password);

    User findByUsername(String username);

    User getCurrentUser();
}