package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/**
 * Created by Maxim on 23.08.2017.
 */
public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;
    public void setModel(Model model){
        this.model = model;
    }

   public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
        /*В методе onShowAllUsers()
        класса Controller должен вызываться метод refresh у объекта usersView
        с параметром model.getModelData() после вызова метода loadUsers().*/
   }

    public void onShowAllDeletedUsers() {
       model.loadDeletedUsers();
       usersView.refresh(model.getModelData());

    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id){
       model.deleteUserById(id);
       usersView.refresh(model.getModelData());
    }

   public void onUserChange(String name, long id, int level){
        model.changeUserData(name,id,level);
       // editUserView.refresh(model.getModelData());
        usersView.refresh(model.getModelData());

    }
}
