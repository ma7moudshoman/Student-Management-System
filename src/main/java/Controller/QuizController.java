package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Service.ServiceImpleImp.CourseService;
import com.Spring.Service.ServiceImpleImp.QuizService;
import com.Spring.model.Course;
import com.Spring.model.Quiz;


//http://localhost:8080/Quiz
@RestController
@RequestMapping("/api")
//http://localhost:8080/api
public class QuizController {

	private  QuizService quizService;

   

    
 public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

// http://localhost:8080/api/all

    @GetMapping("/all")
    public String getQuiz(Model model) {
        List<Quiz> Quizes = quizService.allQuiz();
        model.addAttribute("Quiz", Quizes);
        return "Home";
        }

 // http://localhost:8080/api/{id}

    @GetMapping("/{id}")
    public String getQuiz(@PathVariable int id, Model model) {
        Quiz c = quizService.getQuiz(id);
        model.addAttribute("quiz", c);
        return "Details";
    }
    
 // http://localhost:8080/Quiz/api/add


    @GetMapping("/add")
    public String addQuizForm(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "all"; 
        }
 // http://localhost:8080/Quiz/api/new
    @PostMapping("/new")
    public String addQuiz(@ModelAttribute Quiz quiz) {
    	quizService.addQuiz(quiz);
        return "redirect:/Home"; 
        }

    @GetMapping("/removequiz")
    public String deleteQuiz(@PathVariable int id) {
    	quizService.deleteQuiz(id);
        return "redirect:/all";   }
}

