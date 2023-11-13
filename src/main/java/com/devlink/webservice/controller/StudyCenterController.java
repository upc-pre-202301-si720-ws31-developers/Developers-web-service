package com.devlink.webservice.controller;
import com.devlink.webservice.entities.StudyCenter;
import com.devlink.webservice.service.IStudyCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/study-centers")
public class StudyCenterController {

    private final IStudyCenterService studyCenterService;

    public StudyCenterController(IStudyCenterService studyCenterService) {
        this.studyCenterService = studyCenterService;
    }

    @PostMapping
    public ResponseEntity<StudyCenter> createStudyCenter(@RequestBody StudyCenter studyCenter) {
        try {
            StudyCenter createdStudyCenter = studyCenterService.save(studyCenter);
            return new ResponseEntity<>(createdStudyCenter, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<StudyCenter>> getAllStudyCenters() {
        try {
            List<StudyCenter> studyCenters = studyCenterService.getAll();
            if (studyCenters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(studyCenters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyCenter> getStudyCenterById(@PathVariable Long id) {
        try {
            Optional<StudyCenter> studyCenter = studyCenterService.getById(id);
            return studyCenter.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyCenter> updateStudyCenter(@PathVariable Long id, @RequestBody StudyCenter updatedStudyCenter) {
        try {
            StudyCenter result = studyCenterService.updateStudyCenter(id, updatedStudyCenter);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyCenter(@PathVariable Long id) {
        try {
            studyCenterService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}