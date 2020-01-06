package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUserName(String username);

    @Query(nativeQuery = true, value = "SELECT MAX(id_user) FROM user")
    int getIdMax();

    User findById(int id);

    @Modifying
    @Query(nativeQuery = true,value = "UPDATE user SET fullname = ?1 ,passworld= ?2,phone = ?3 ,email = ?4 WHERE id_user = ?4")
    void updateUser(String fullname, String pass, String phone, String email, int id);


}
