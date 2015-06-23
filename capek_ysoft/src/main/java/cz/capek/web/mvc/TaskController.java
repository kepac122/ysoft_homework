package cz.capek.web.mvc;

 import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.capek.web.domain.Task;
import cz.capek.web.repo.TaskDao;

@Controller
@RequestMapping(value="/")
public class TaskController
{
    @Autowired
    private TaskDao taskDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displayCreateTasks(Model model) {
        model.addAttribute("newTask", new Task());        
        return "index";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String createNewTask(@Valid @ModelAttribute("newTask") Task newTask, BindingResult result, Model model) {
        if (!result.hasErrors()) {
        	taskDao.create(newTask);
            return "redirect:/list";
        }
        else {            
            return "index";
        }
    }    
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String displaySortedTasks(Model model) {        
        model.addAttribute("tasks", taskDao.findAllOrderedByDateAndPriority());
        return "list";
    }
    
    @RequestMapping(value="/list/delete/{id}", method=RequestMethod.POST)
    public String deleteTask(@PathVariable("id") Long id, Model model) {        
    	taskDao.delete(id);       
        model.addAttribute("tasks", taskDao.findAllOrderedByDateAndPriority());
        return "redirect:/list";        
    }
    
    @RequestMapping(value="/list/done/{id}", method=RequestMethod.POST)
    public String markAsDoneTask(@PathVariable("id") Long id, Model model) {        
    	taskDao.isDone(id, true);       
        model.addAttribute("tasks", taskDao.findAllOrderedByDateAndPriority());
        return "redirect:/list";        
    }
    
    @RequestMapping(value="/list/notdone/{id}", method=RequestMethod.POST)
    public String markAsNotDoneTask(@PathVariable("id") Long id, Model model) {        
    	taskDao.isDone(id, false);       
        model.addAttribute("tasks", taskDao.findAllOrderedByDateAndPriority());
        return "redirect:/list";        
    }
    
    @RequestMapping(value="/list/inc_priority/{id}", method=RequestMethod.POST)
    public String increasePriorityTask(@PathVariable("id") Long id, Model model) {        
    	taskDao.increasePriority(id);
        model.addAttribute("tasks", taskDao.findAllOrderedByDateAndPriority());
        return "redirect:/list";        
    }
    
    @RequestMapping(value="/list/dec_priority/{id}", method=RequestMethod.POST)
    public String decreasePriorityTask(@PathVariable("id") Long id, Model model) {        
    	taskDao.decreasePriority(id);
        model.addAttribute("tasks", taskDao.findAllOrderedByDateAndPriority());
        return "redirect:/list";        
    }
}
