package com.ivanribeiro.FitHubAPI.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivanribeiro.FitHubAPI.models.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

}
