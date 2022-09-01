package com.travel.repositories;

import com.travel.entities.Role;
import com.travel.entities.RoleTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName (RoleTypes name);
}
