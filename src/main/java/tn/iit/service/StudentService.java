package tn.iit.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import tn.iit.dto.StudentDto;
import tn.iit.repository.StudentRepository;

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
}