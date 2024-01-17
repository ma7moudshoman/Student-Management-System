package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.Service.ServiceImpleImp.CourseService;
import com.Spring.Service.ServiceImpleImp.StudentService;
import com.Spring.model.Course;
import com.Spring.model.Student;


//http://localhost:8080/Studen

@Controller
@RequestMapping("/api")
//http://localhost:8080/Studen/api
public class StudentController {
	
    private  StudentService studentService;
   
    
 public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

// http://localhost:8080/Studen/api/all

    @GetMapping("/all")
    public String getAllstudents(Model model) {
        List<Student> students = studentService.allStudent();
        model.addAttribute("students", students);
        return "Home";
        }

 // http://localhost:8080/student/api/{id}

    @GetMapping("/{id}")
    public String getstudent(@PathVariable int id, Model model) {
    	Student studen = studentService.getStudent(id);
        model.addAttribute("studen", studen);
        return "Details";
    }
    
 // http://localhost:8080/student/api/add


    @GetMapping("/add")
    public String addstudentForm(Model model) {
        model.addAttribute("course", new Student());
        return "addstuden"; 
        }
	 // http://localhost:8080/student/api/new

    @PostMapping("/new")
    public String addStuden(@ModelAttribute Student student) {
    	studentService.addStudent(student);
        return "redirect:/new/all"; 
        }
	 // http://localhost:8080/student/api/delete/{id}

    @GetMapping("/delete/{id}")
    public String deletestudent(@PathVariable int id) {
    	studentService.deleteStudent(id);
        return "deleteStuden";   
        
    }

	
	
}
