package com.albamch.userservice.service;

import com.albamch.userservice.models.Role;
import com.albamch.userservice.repository.RoleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Role findById(Integer id) {

        log.info("buscando por id: " + id);
        return roleRepository.findById(id).get();
    }

    @Override
    public List<Role> findByName(String nombre) {

        log.info("buscando por nombre: " + nombre);
        return roleRepository.findByNameContainingIgnoreCase(nombre);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
