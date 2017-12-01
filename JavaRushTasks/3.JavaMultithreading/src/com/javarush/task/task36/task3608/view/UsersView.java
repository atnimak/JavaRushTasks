package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Maxim on 23.08.2017.
 */
public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        if(modelData.isDisplayDeletedUserList()){
            System.out.println("All deleted users:");
            for(int i = 0;i<modelData.getUsers().size();i++){
                System.out.println("\t"+modelData.getUsers().get(i));
            }
            System.out.println("===================================================");

        }else{
            System.out.println("All users:");
            for(int i = 0;i<modelData.getUsers().size();i++){
                System.out.println("\t"+modelData.getUsers().get(i));
            }
            System.out.println("===================================================");
        }




    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
