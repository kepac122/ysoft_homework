package cz.capek.web.repo;

import java.util.List;

import cz.capek.web.domain.Task;

public interface TaskDao
{
    public Task findById(Long id);

    public List<Task> findAllOrderedByDateAndPriority();

    public void create(Task newTask);
    
    public void delete(Long id);
    
    public void isDone(Long id, boolean done);
    
    public void increasePriority(Long id);
    
    public void decreasePriority(Long id);
    
}
