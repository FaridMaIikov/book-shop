package az.booking.bookshop.service;

import az.booking.bookshop.entity.Role;
import az.booking.bookshop.model.response.ERole;
import az.booking.bookshop.model.response.RoleResponse;
import az.booking.bookshop.model.mapper.CustomMapper;

import az.booking.bookshop.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final CustomMapper roleMapper;

    public List<RoleResponse> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.roleToRoleDTO(roles);
    }
    public Role findByRoleName(ERole eRole) {
        return roleRepository.findByRoleName(eRole);
    }
}
