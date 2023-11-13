package com.devlink.webservice.service.impl;
import com.devlink.webservice.entities.StudyCenter;
import com.devlink.webservice.repository.IStudyCenterRepository;
import com.devlink.webservice.service.IStudyCenterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class StudyCenterServiceImpl implements IStudyCenterService {

    private final IStudyCenterRepository studyCenterRepository;

    public StudyCenterServiceImpl(IStudyCenterRepository studyCenterRepository) {
        this.studyCenterRepository = studyCenterRepository;
    }

    @Override
    @Transactional
    public StudyCenter save(StudyCenter studyCenter) throws Exception {
        return studyCenterRepository.save(studyCenter);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        studyCenterRepository.deleteById(id);
    }

    @Override
    public List<StudyCenter> getAll() throws Exception {
        return studyCenterRepository.findAll();
    }

    @Override
    public Optional<StudyCenter> getById(Long id) throws Exception {
        return studyCenterRepository.findById(id);
    }

    @Override
    public List<StudyCenter> getByLocation(String location) throws Exception {
        return studyCenterRepository.findByLocation(location);
    }

    @Override
    @Transactional
    public StudyCenter updateStudyCenter(Long id, StudyCenter updatedStudyCenter) throws Exception {
        StudyCenter existingStudyCenter = studyCenterRepository.findById(id).orElse(null);
        if (existingStudyCenter != null) {
            // Actualiza los campos que desees permitir que se actualicen
            existingStudyCenter.setName(updatedStudyCenter.getName());
            existingStudyCenter.setLocation(updatedStudyCenter.getLocation());
            // ... Otros campos

            return studyCenterRepository.save(existingStudyCenter);
        } else {
            throw new Exception("Centro de estudio no encontrado");
        }
    }
}