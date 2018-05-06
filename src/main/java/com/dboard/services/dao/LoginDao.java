package com.dboard.services.dao;

import com.dboard.services.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends JpaRepository<LoginEntity, String> {

    LoginEntity findByUserNameEqualsAndPasswordEquals(String userName, String password);
}
