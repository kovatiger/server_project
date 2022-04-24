package app.service.role_service;

import app.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role findRoleByRoleNameAndSaveIfDoesntExists(String statusName);
}
