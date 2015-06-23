package cz.capek.web.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.capek.web.domain.Task;
import cz.capek.web.repo.TaskDao;

@Controller
@RequestMapping("/rest/tasks")
public class TaskRestController
{
    @Autowired
    private TaskDao taskDao;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Task> listAllTasks()
    {
        return taskDao.findAllOrderedByDateAndPriority();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Task lookupTaskById(@PathVariable("id") Long id)
    {
        return taskDao.findById(id);
    }
}
