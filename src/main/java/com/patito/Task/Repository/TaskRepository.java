package com.patito.Task.Repository;

import com.patito.Task.Model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
