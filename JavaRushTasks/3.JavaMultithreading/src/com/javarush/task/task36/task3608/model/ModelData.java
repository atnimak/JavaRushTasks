package com.javarush.task.task36.task3608.model;
import com.javarush.task.task36.task3608.bean.User;
import  java.util.List;

/**
 * Created by Maxim on 23.08.2017.
 */
public class ModelData {

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;

    private User activeUser;

    public User getActiveUser(){
        return activeUser;
    }

    public void setActiveUser(User activeUser){
        this.activeUser = activeUser;
    }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    private boolean displayDeletedUserList;
    
}
