package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.dto.StudentDto;

public interface StudentRepository extends JpaRepository<StudentDto, String> {
}