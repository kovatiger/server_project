package app.service.role_service;

import app.entity.Role;
import app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByRoleNameAndSaveIfDoesntExists(String roleName) {
        Role role = roleRepository.findRoleByRoleName(roleName);
        if (role == null) {
            Role userRole = new Role();
            userRole.setRoleName(roleName);
            roleRepository.save(userRole);
            return userRole;
        } else return role;
    }
}
