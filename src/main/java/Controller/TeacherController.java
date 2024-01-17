package Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.Service.ServiceImpleImp.TeacherService;
import com.Spring.model.Student;
import com.Spring.model.Teacher;


//http://localhost:8080/Teacher

@Controller
@RequestMapping("/api")
// http://localhost:8080/Teacher/api
public class TeacherController {

	
	private TeacherService teacherService;
	
	    public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

	    
	 // http://localhost:8080/Teacher/api/all
		@GetMapping("/all")
	    public String allteachers(Model model) {
	        List<Teacher> teachers = teacherService.allTeacher();
	        model.addAttribute("teachers", teachers);
	        return "Home";
	        }

	 // http://localhost:8080/Teacher/api/{id}

	    @GetMapping("/{id}")
	    public String getteacher(@PathVariable int id, Model model) {
	    	Teacher teacher = teacherService.getTeacher(id);
	        model.addAttribute("teacher", teacher);
	        return "Detail";
	    }
	    
	 // http://localhost:8080/Teacher/api/add


	    @GetMapping("/add")
	    public String addTeacherForm(Model model) {
	        model.addAttribute("teacher", new Student());
	        return "addteacher"; 
	        }
		 // http://localhost:8080/Teacher/api/new

	    @PostMapping("/new")
	    public String addTeacher(@ModelAttribute Teacher teacher) {
	    	teacherService.addTeacher(teacher);
	        return "redirect:/Home"; 
	        }
		 // http://localhost:8080/Teacher/api/delete/{id}

	    @GetMapping("/delete/{id}")
	    public String deleteteacher(@PathVariable int id) {
	    	teacherService.deleteTeacher(id);
	        return "deleteteacher";   
	        
	    }

	
	
}
