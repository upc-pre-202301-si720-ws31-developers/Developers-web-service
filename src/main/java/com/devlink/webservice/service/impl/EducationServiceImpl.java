package com.devlink.webservice.service.impl;
import com.devlink.webservice.entities.Education;
import com.devlink.webservice.entities.Developer;
import com.devlink.webservice.entities.StudyCenter;
import com.devlink.webservice.repository.IEducationRepository;
import com.devlink.webservice.service.IEducationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository educationRepository;

    public EducationServiceImpl(IEducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    @Transactional
    public Education save(Education education) throws Exception {
        return educationRepository.save(education);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        educationRepository.deleteById(id);
    }

    @Override
    public List<Education> getAll() throws Exception {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> getById(Long id) throws Exception {
        return educationRepository.findById(id);
    }

    @Override
    public List<Education> getByDeveloper(Developer developer) throws Exception {
        return educationRepository.findByDeveloper(developer);
    }

    @Override
    public List<Education> getByStudyCenter(StudyCenter studyCenter) throws Exception {
        return educationRepository.findByStudyCenter(studyCenter);
    }

    @Override
    public List<Education> getByFieldOfStudy(String fieldOfStudy) throws Exception {
        return educationRepository.findByFieldOfStudy(fieldOfStudy);
    }

    @Override
    @Transactional
    public Education updateEducation(Long id, Education updatedEducation) throws Exception {
        Education existingEducation = educationRepository.findById(id).orElse(null);
        if (existingEducation != null) {
            existingEducation.setDegree(updatedEducation.getDegree());
            existingEducation.setSchool(updatedEducation.getSchool());
            // ... Otros campos

            return educationRepository.save(existingEducation);
        } else {
            throw new Exception("Educación no encontrada");
        }
    }
}
