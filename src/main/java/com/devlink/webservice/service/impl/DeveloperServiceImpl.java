package com.devlink.webservice.service.impl;
import com.devlink.webservice.entities.Developer;
import com.devlink.webservice.repository.IDeveloperRepository;
import com.devlink.webservice.service.IDeveloperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DeveloperServiceImpl implements IDeveloperService {

    private final IDeveloperRepository developerRepository;

    public DeveloperServiceImpl(IDeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    @Transactional
    public Developer save(Developer developer) throws Exception {
        return developerRepository.save(developer);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        developerRepository.deleteById(id);
    }

    @Override
    public List<Developer> getAll() throws Exception {
        return developerRepository.findAll();
    }

    @Override
    public Optional<Developer> getById(Long id) throws Exception {
        return developerRepository.findById(id);
    }

    @Override
    public Optional<Developer> getByUsername(String username) throws Exception {
        return developerRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public Developer updateDeveloper(Long id, Developer updatedDeveloper) throws Exception {
        Developer existingDeveloper = developerRepository.findById(id).orElse(null);
        if (existingDeveloper != null) {
            existingDeveloper.setName(updatedDeveloper.getName());
            existingDeveloper.setLastname(updatedDeveloper.getLastname());
            // ... Otros campos

            return developerRepository.save(existingDeveloper);
        } else {
            throw new Exception("Desarrollador no encontrado");
        }
    }
}
