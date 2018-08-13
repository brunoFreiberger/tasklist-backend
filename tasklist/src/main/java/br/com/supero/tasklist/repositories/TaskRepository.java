package br.com.supero.tasklist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.supero.tasklist.models.Task;

/**
 * @author Bruno Henrique
 * @since 12/08/2018
 * 
 * Interface with CRUD of task
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
	
	@Query("SELECT t FROM Task t order by t.completed, t.orderTask asc")
    public List<Task> getAllTasks();
	
}
