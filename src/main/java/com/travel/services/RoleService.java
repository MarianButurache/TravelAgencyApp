package com.travel.services;

import com.travel.entities.Role;
import com.travel.entities.RoleTypes;
import com.travel.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role save(Role role) {
        Role roleInDatabase = roleRepository.findRoleByName(role.getName());
        if (roleInDatabase != null) {
            throw new RuntimeException("Role already exists");
        } else {
            Role save = roleRepository.save(role);
            return save;
        }
    }

    public Role findByName(RoleTypes roleTypes) {
        return roleRepository.findRoleByName(roleTypes);
    }

}
