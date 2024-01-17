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
import com.Spring.model.Course;

//     http://localhost:8080/Course

@Controller
@RequestMapping("/api")
// http://localhost:8080/Course/api
public class CourseController {
	
	
	    private  CourseService courseService;

	    @Autowired
	    public CourseController(CourseService courseService) {
	        this.courseService = courseService;
	    }

	    
	 // http://localhost:8080/Course/api/all

	    @GetMapping("/all")
	    public String getAllCourses(Model model) {
	        List<Course> courses = courseService.allCourses();
	        model.addAttribute("courses", courses);
	        return "Home";
	        }

	 // http://localhost:8080/Course/api/{id}

	    @GetMapping("/{id}")
	    public String getCourse(@PathVariable int id, Model model) {
	        Course course = courseService.getCourse(id);
	        model.addAttribute("course", course);
	        return "courseDetails";
	    }
	    
	 // http://localhost:8080/Course/api/add


	    @GetMapping("/add")
	    public String addCourseForm(Model model) {
	        model.addAttribute("course", new Course());
	        return "addCourse"; 
	        }
		 // http://localhost:8080/Course/api/new

	    @PostMapping("/new")
	    public String addCourse(@ModelAttribute Course course) {
	        courseService.addCourse(course);
	        return "redirect:/addCourse"; 
	        }
		 // http://localhost:8080/Course/api/delete/{id}

	    @GetMapping("/delete/{id}")
	    public String deleteCourse(@PathVariable int id) {
	        courseService.deleteCourse(id);
	        return "redirect:/Home";   }
	}

