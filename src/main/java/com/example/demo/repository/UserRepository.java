package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUserName(String username);

    @Query(nativeQuery = true,value = "SELECT * FROM role  WHERE id_role = 2")
    Role findRoleById(int id);

    @Query(nativeQuery = true, value = "SELECT MAX(id_user) FROM user")
    int getIdMax();


}
