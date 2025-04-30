package com.example.ormcoursework.dao.custom;

import com.example.ormcoursework.dao.CrudDAO;
import com.example.ormcoursework.entity.User;

public interface UserDAO extends CrudDAO<User> {

    boolean isExist(User user);

    boolean updatePassword(User user);

    boolean changeUserDetailsOne(String[] data, String[] column);

    boolean changeUserDetailsTwo(String[] data, String[] column);

    boolean changeUserDetailsThree(String[] data, String[] column);

//    boolean changeUserDetailsFour(String[] data, String[] column);
}
