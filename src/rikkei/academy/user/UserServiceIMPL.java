package rikkei.academy.user;

import rikkei.academy.config.Config;
import rikkei.academy.model.role.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService{
    public static String PATH_USER = "D:\\New folder\\untitled8\\src\\rikkei\\academy\\database\\user.txt";
    public static List<User> userList = new ArrayList<>();


    @Override
    public List<User> findALl() {
        new Config<User>().writeFile(PATH_USER,userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);

    }

    @Override
    public boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByEmail(String email) {
        for (int i = 0; i < userList.size(); i++) {
            if (email.equals(userList.get(i).getEmail())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUsername())&&password.equals(userList.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUsername())){
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public User getCurrentUser() {
        if(new Config<User>().readFile(Config.PATH_USER_PRINCIPAL)!=null){
            User user = new Config<User>().readFile(Config.PATH_USER_PRINCIPAL).get(0);
            return user;
        }
        return null;
    }
}
