package com.kulagin.SpringBootCRUD.dao;

import com.kulagin.SpringBootCRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>{


}
