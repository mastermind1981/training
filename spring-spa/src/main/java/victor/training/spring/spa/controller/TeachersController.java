package victor.training.spring.spa.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import victor.training.spring.spa.controller.dto.TeacherDto;
import victor.training.spring.spa.dao.TeacherRepository;
import victor.training.spring.spa.domain.Teacher;

@RestController
@RequestMapping("/rest/teachers")
public class TeachersController {
	
	private final static Logger log = LoggerFactory.getLogger(TeachersController.class);

	@Autowired
	private TeacherRepository teacherRepo;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<TeacherDto> getAllTeachers() {
		List<TeacherDto> dtos = new ArrayList<TeacherDto>();
		for (Teacher t : teacherRepo.getAll()) {
			dtos.add(new TeacherDto(t.getId(), t.getName()));
		}
		return dtos;
	}
	

}
