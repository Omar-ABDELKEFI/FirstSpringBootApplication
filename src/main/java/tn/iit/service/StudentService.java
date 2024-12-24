package tn.iit.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import tn.iit.dto.StudentDto;
import tn.iit.repository.StudentRepository;
import tn.iit.exception.CompteNotFoundException;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void save(StudentDto studentDto) {
        studentRepository.save(studentDto);
    }

    public List<StudentDto> findAll() {
        return studentRepository.findAll();
    }

    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    public void update(StudentDto studentDto) {
        studentRepository.save(studentDto);
    }

    public StudentDto findById(String id) {
        return studentRepository.findById(id)
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getGenre()))
                .orElseThrow(() -> new CompteNotFoundException("Student with id " + id + " not found"));
    }
}