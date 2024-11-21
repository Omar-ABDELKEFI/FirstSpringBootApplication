package tn.iit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.iit.dto.StudentDto;

@Service
public class StudentService {
	private List<StudentDto> students = new ArrayList<>();

	public StudentService() {

	}

	public void save(StudentDto studentDto) {
		students.add(studentDto);
	}

	public List<StudentDto> findAll() {
		return students;
	}

	public void deleteById(String id) {

		students.removeIf(student -> student.getId().equals(id));
	}

	public void update(StudentDto studentDto) {
		for (StudentDto student : students) {
			if (student.getId().equals(studentDto.getId())) {
				student.setName(studentDto.getName());
				student.setGenre(studentDto.getGenre());
				break;
			}
		}
	}
}