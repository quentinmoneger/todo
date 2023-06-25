package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Todo;
import com.mycompany.myapp.repository.TodoRepository;
import com.mycompany.myapp.service.TodoService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Todo}.
 */
@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final Logger log = LoggerFactory.getLogger(TodoServiceImpl.class);

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo save(Todo todo) {
        log.debug("Request to save Todo : {}", todo);
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        log.debug("Request to update Todo : {}", todo);
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> partialUpdate(Todo todo) {
        log.debug("Request to partially update Todo : {}", todo);

        return todoRepository
            .findById(todo.getId())
            .map(existingTodo -> {
                if (todo.getState() != null) {
                    existingTodo.setState(todo.getState());
                }
                if (todo.getTitle() != null) {
                    existingTodo.setTitle(todo.getTitle());
                }
                if (todo.getDescription() != null) {
                    existingTodo.setDescription(todo.getDescription());
                }

                return existingTodo;
            })
            .map(todoRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        log.debug("Request to get all Todos");
        return todoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Todo> findOne(Long id) {
        log.debug("Request to get Todo : {}", id);
        return todoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Todo : {}", id);
        todoRepository.deleteById(id);
    }
}
