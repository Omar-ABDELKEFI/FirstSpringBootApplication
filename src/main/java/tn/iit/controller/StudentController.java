package tn.iit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import tn.iit.dto.StudentDto;
import tn.iit.service.StudentService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	@GetMapping({ "/", "/all" })
	public String index(Model model) { // url: http://localhost:8080/students/all
		model.addAttribute("students", studentService.findAll());
		return "students"; // va à la page students.html
	}

	@PostMapping
	public String addStudent(@RequestBody StudentDto studentDto) {
		studentService.save(studentDto);
		return "redirect:/students/all";
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
		studentService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/check/{id}")
	public ResponseEntity<Boolean> checkId(@PathVariable String id) {
		boolean exists = studentService.findAll().stream().anyMatch(student -> student.getId().equals(id));
		return ResponseEntity.ok(exists);
	}

	@PostMapping("/delete/{id}")
	public String removeStudent(@PathVariable String id) {
		studentService.deleteById(id);
		return "redirect:/students/all";
	}

	@PostMapping("/update")
	public String updateStudent(@RequestParam String id, @RequestParam String name, @RequestParam String genre) {
		StudentDto studentDto = new StudentDto(id, name, genre);
		studentService.update(studentDto);
		return "redirect:/students/all";
	}
}