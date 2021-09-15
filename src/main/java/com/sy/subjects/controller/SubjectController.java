package com.sy.subjects.controller;

import com.sy.subjects.entity.Subject;
import com.sy.subjects.exception.SubjectNotFoundException;
import com.sy.subjects.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    private final Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @PostMapping
    public Subject saveSubject(@Valid @RequestBody Subject subject) {
        logger.info("inside post req");
        return subjectService.saveSubject(subject);
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Long id) throws SubjectNotFoundException {
        return subjectService.getSubject(id);
    }

    @GetMapping("/name/{name}")
    public Subject getSubjectByName(@PathVariable String name) {
        return subjectService.getSubjectByName(name);
    }

    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.getSubjects();
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable  Long id) {
        subjectService.deleteSubject(id);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id,
                                 @RequestBody Subject subject) {
        return subjectService.updateSubject(id, subject);
    }
}
