package az.booking.bookshop.controller;


import az.booking.bookshop.entity.Role;
import az.booking.bookshop.model.response.ERole;
import az.booking.bookshop.model.response.RoleResponse;
import az.booking.bookshop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<RoleResponse> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/role-name")
    public Role findByRoleName(@RequestParam ERole eRole) {
        return roleService.findByRoleName(eRole);
    }
}