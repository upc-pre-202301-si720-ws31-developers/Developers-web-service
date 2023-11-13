package com.devlink.webservice.service.impl;
import com.devlink.webservice.entities.Company;
import com.devlink.webservice.repository.ICompanyRepository;
import com.devlink.webservice.service.ICompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements ICompanyService {

    private final ICompanyRepository companyRepository;

    public CompanyServiceImpl(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional
    public Company save(Company company) throws Exception {
        return companyRepository.save(company);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> getAll() throws Exception {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getById(Long id) throws Exception {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> getByLocation(String location) throws Exception {
        return companyRepository.findByLocation(location);
    }


    @Override
    @Transactional
    public Company updateCompany(Long id, Company updatedCompany) throws Exception {
        Company existingCompany = companyRepository.findById(id).orElse(null);
        if (existingCompany != null) {
            existingCompany.setName(updatedCompany.getName());
            existingCompany.setLocation(updatedCompany.getLocation());
            // ... Otros campos

            return companyRepository.save(existingCompany);
        } else {
            throw new Exception("Compañía no encontrada");
        }
    }
}