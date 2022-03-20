package com.example.ProjectPolovinkin.model.repositories;

import com.example.ProjectPolovinkin.model.ERole;
import com.example.ProjectPolovinkin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName (ERole name);
}
