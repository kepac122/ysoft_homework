package cz.capek.web.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.capek.web.domain.Task;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao
{
    @Autowired
    private EntityManager em;
    
    private CriteriaBuilder cb;
    private CriteriaQuery<Task> criteria;
    private Root<Task> task;
    
    private void setUpCriteria(){
		cb = em.getCriteriaBuilder();
        criteria = cb.createQuery(Task.class);
        task = criteria.from(Task.class);
    }

    @Override
    public Task findById(Long id)
    {
        return em.find(Task.class, id);
    }

	@Override
	public List<Task> findAllOrderedByDateAndPriority() {
		setUpCriteria();
		
        criteria.select(task).orderBy(cb.asc(task.get("date"))).orderBy(cb.asc(task.get("priority")));        
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void create(Task newTask) {				
		em.persist(newTask);
	}

	@Override
	public void delete(Long id) {
		Task task = findById(id);
		em.remove(task);		
	}

	@Override
	public void isDone(Long id, boolean done) {
		Task task = findById(id);
		task.setDone(done);
		em.merge(task);
	}

	@Override
	public void increasePriority(Long id) {
		Task task = findById(id);
		// max 5
		task.setPriority((task.getPriority() + 1) == 6 ? 5 : task.getPriority() + 1 );
		em.merge(task);		
	}
	
	@Override
	public void decreasePriority(Long id) {
		Task task = findById(id);
		// min 1
		task.setPriority((task.getPriority() - 1) == 0 ? 1 : task.getPriority() - 1 );
		em.merge(task);		
	} 
}
