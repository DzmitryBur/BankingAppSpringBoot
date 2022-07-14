package com.cot.bankingappspringboot.service;

import com.cot.bankingappspringboot.mapper.RoleMapper;
import com.cot.bankingappspringboot.model.Role;
import com.cot.bankingappspringboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleRepository {

    private JdbcTemplate jdbcTemplate;
    private RoleMapper roleMapper;

    @Autowired
    public RoleService(JdbcTemplate jdbcTemplate, RoleMapper roleMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> getAllRoles() {
        return jdbcTemplate.query("SELECT * FROM roles", roleMapper);
    }

    @Override
    public Role getRole(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM roles WHERE id=?", roleMapper, id);
    }

    @Override
    public int createRole(Role role) {
        return jdbcTemplate.update("INSERT INTO roles (id, role) VALUES (DEFAULT,?)", role.getRole());
    }

    @Override
    public void updateRole(Role role) {
        jdbcTemplate.update("UPDATE roles SET role = ? WHERE id = ?", role.getRole(), role.getId());
    }

    @Override
    public void deleteRole(long id) {
        jdbcTemplate.update("DELETE FROM roles WHERE id=?", id);
    }
}
