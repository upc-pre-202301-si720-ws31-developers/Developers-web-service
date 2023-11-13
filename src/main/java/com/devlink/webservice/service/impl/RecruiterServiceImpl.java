package com.devlink.webservice.service.impl;

import com.devlink.webservice.entities.Recruiter;
import com.devlink.webservice.entities.Company;
import com.devlink.webservice.repository.IRecruiterRepository;
import com.devlink.webservice.service.IRecruiterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RecruiterServiceImpl implements IRecruiterService {

    private final IRecruiterRepository recruiterRepository;

    public RecruiterServiceImpl(IRecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    @Transactional
    public Recruiter save(Recruiter recruiter) throws Exception {
        return recruiterRepository.save(recruiter);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        recruiterRepository.deleteById(id);
    }

    @Override
    public List<Recruiter> getAll() throws Exception {
        return recruiterRepository.findAll();
    }

    @Override
    public Optional<Recruiter> getById(Long id) throws Exception {
        return recruiterRepository.findById(id);
    }

    @Override
    public List<Recruiter> getByCompany(Company company) throws Exception {
        return recruiterRepository.findByCompany(company);
    }

    //@Override
    //public List<Recruiter> getByLocation(String location) throws Exception {
    //    return recruiterRepository.findByLocation(location);
    //}

    @Override
    @Transactional
    public Recruiter updateRecruiter(Long id, Recruiter updatedRecruiter) throws Exception {
        Recruiter existingRecruiter = recruiterRepository.findById(id).orElse(null);
        if (existingRecruiter != null) {
            existingRecruiter.setName(updatedRecruiter.getName());
            existingRecruiter.setCompany(updatedRecruiter.getCompany());
            // ... Otros campos

            return recruiterRepository.save(existingRecruiter);
        } else {
            throw new Exception("Reclutador no encontrado");
        }
    }
}