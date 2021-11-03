package com.example.demo.advice;


/**
 * Created by author on 2021/10/17 17:47
 */
public class UserDao {

    public void select() {
        System.out.println("select_111");
    }

    public void update() {
        System.out.println("update_222");
    }

    private void delete() {
        System.out.println("delete_333");
    }
}
