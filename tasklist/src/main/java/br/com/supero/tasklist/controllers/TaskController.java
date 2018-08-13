package br.com.supero.tasklist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.supero.tasklist.models.Task;
import br.com.supero.tasklist.repositories.TaskRepository;

/**
 * @author Bruno Henrique
 * @since 12/08/2018
 */
@Controller
@RequestMapping(path = "task")
public class TaskController {

	@Autowired // This means to get the bean called taskRepository
	private TaskRepository taskRepository;

	/**
	 * Save the tasks
	 * 
	 * @param task that we are saving
	 * @return HttpStatus
	 */
	@PostMapping(path = "/save")
	public @ResponseBody Task save(@RequestBody Task task) {
		return this.taskRepository.save(task);
	}

	/**
	 * Return all tasks (todo and completed)
	 * 
	 * @return all tasks in database
	 */
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Task> getAllTasks() {
		// This returns a JSON or XML with the tasks
		return this.taskRepository.getAllTasks();
	}
	
	/**
	 * Change the order of tasks
	 * 
	 * @param tasks 
	 * @return HttpStatus
	 */
	@PostMapping(path = "/saveOrder")
	public @ResponseBody HttpStatus saveOrder(@RequestBody List<Task> tasks) {
		Integer order = 0;
		for(Task task : tasks) {
			task.setOrderTask(order++);
		}
		this.taskRepository.saveAll(tasks);
		return HttpStatus.OK;
	}
	
	/**
	 * Delete the tasks
	 * 
	 * @param id
	 * @return HttpStatus
	 */
	@PostMapping(path = "/delete/{id}")
	public @ResponseBody HttpStatus remove(@PathVariable Long id) {
		this.taskRepository.deleteById(id);
		return HttpStatus.OK;
	}

}
