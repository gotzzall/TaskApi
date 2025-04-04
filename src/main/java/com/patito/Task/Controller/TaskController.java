package com.patito.Task.Controller;

import com.patito.Task.Model.Task;
import com.patito.Task.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class TaskController {
    @Autowired
    TaskRepository repository;

    @PostMapping("/add")
    public @ResponseBody String addNewTask(@RequestBody Task task){
        repository.save(task);
        return "Save it";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Task> getAllTask(){
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Optional<Task> getById(@PathVariable Integer id){
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteById(@PathVariable Integer id){
        repository.deleteById(id);
        return "Deleted";
    }

    @PutMapping("/update/{id}")
    public @ResponseBody String updateById(@PathVariable Integer id, @RequestBody Task updateTask){
        Task oldTask = repository.findById(id).get();
        if(updateTask.getTitle() != null){
            oldTask.setTitle(updateTask.getTitle());
        }
        if(updateTask.getDescription() != null){
            oldTask.setDescription(updateTask.getDescription());
        }

        repository.save(oldTask);
        return "updated ";
    }
}
