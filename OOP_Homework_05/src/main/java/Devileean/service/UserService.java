package Devileean.service;

import Devileean.model.User;
import Devileean.view.Messages;

public class UserService {
    public User createUser(int id, String name){
        return new User(id,name);
    }
    public void changeBalance(User user, int amount){
        user.changeBalance(amount);
        Messages.ShowOperation(amount);
    }
}
