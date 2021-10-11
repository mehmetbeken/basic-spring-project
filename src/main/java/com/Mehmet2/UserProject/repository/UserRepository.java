package com.Mehmet2.UserProject.repository;

import com.Mehmet2.UserProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
