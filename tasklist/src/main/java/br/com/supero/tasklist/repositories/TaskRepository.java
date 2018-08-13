package br.com.supero.tasklist.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.supero.tasklist.models.Task;

/**
 * @author Bruno Henrique
 * @since 12/08/2018
 * 
 * Interface with CRUD of task
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
	
}
