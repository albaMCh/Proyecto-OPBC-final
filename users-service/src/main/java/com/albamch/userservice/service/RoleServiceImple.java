package com.albamch.userservice.service;

import com.albamch.errors.Exceptions.CustomErrorResponse;
import com.albamch.modelcommons.models.users.Role;
import com.albamch.userservice.repository.RoleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Log4j2
@Service
public class RoleServiceImple implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImple(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void delete(Integer id) {

        log.info("borrando role: " + id);
        roleRepository.deleteById(id);
    }

    @Override
    public Role update(Role roles) {

        if((roles.getId() != null) && (roleRepository.existsById(roles.getId()))){

            roleRepository.deleteById(roles.getId());
            return roleRepository.save(roles);
        }

        return roleRepository.save(roles);
    }

    @Override
    public Role save(Role roles) {

        log.info("guardando rol: " + roles.toString());
        return roleRepository.save(roles);
    }

    @Override
    public Role enableRole(Integer id) {

        log.info("Activando rol: " + id);

        Role role = findById(id);
        role.setEnable(true);

        return save(role);
    }

    @Override
    public Role disableRole(Integer id) {

        log.info("Desactivando rol: " + id);

        Role role = findById(id);
        role.setEnable(false);

        return save(role);
    }

    @Override
    @Transactional
    public void assignUserToRole(Integer userId, String roleName) {

        log.info("Asignando rol " + roleName + " a usuario: " + userId);
        roleRepository.assignUserToRole(userId, findByName(roleName).getId());
    }

    @Override
    @Transactional
    public void unAssignUserToRole(Integer userId, String roleName) {

        log.info("Desasignando rol " + roleName + " a usuario: " + userId);
        roleRepository.unAssignUserToRole(userId, findByName(roleName).getId());
    }

    @Override
    public Role findById(Integer id) {

        log.info("buscando por id: " + id);
        return roleRepository.findById(id).orElseThrow(() -> new CustomErrorResponse(this.getClass(),
                "No existe registro con el id: " + id,
                "EntityNotFound"));
    }

    @Override
    public Role findByName(String nombre) {

        log.info("buscando role por nombre: " + nombre);
        return roleRepository.findByNameIgnoreCase(nombre);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
