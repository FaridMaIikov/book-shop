package az.booking.bookshop.service;

import az.booking.bookshop.entity.Role;
import az.booking.bookshop.model.response.RoleDTO;
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

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.roleToRoleDTO(roles);
    }
}
