package com.sy.subjects.service;

import com.sy.subjects.entity.Subject;
import com.sy.subjects.exception.SubjectNotFoundException;
import com.sy.subjects.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubject(Long id) throws SubjectNotFoundException {
        // return subjectRepository.findById(id).get();
        Optional<Subject> subject = subjectRepository.findById(id);

        if(!subject.isPresent()) {
            throw new SubjectNotFoundException("Subject is unavailable");
        }

        return subject.get();
    }

    @Override
    public Subject getSubjectByName(String name) {
        return subjectRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject updateSubject(Long id, Subject subject) {
        Subject updatedSubject = subjectRepository.findById(id).get();

        if(Objects.nonNull(subject.getName()) && !"".equalsIgnoreCase(subject.getName())){
            updatedSubject.setName(subject.getName());
        }

        if(Objects.nonNull(subject.getCode()) && !"".equalsIgnoreCase(subject.getCode())){
            updatedSubject.setCode(subject.getCode());
        }

        return subjectRepository.save(updatedSubject);
    }
}
