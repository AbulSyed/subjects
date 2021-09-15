package com.sy.subjects.service;

import com.sy.subjects.entity.Subject;
import com.sy.subjects.exception.SubjectNotFoundException;

import java.util.List;

public interface SubjectService {

    Subject saveSubject(Subject subject);

    Subject getSubject(Long id) throws SubjectNotFoundException;

    Subject getSubjectByName(String name);

    List<Subject> getSubjects();

    void deleteSubject(Long id);

    Subject updateSubject(Long id, Subject subject);
}
