package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Todo;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Todo}.
 */
public interface TodoService {
    /**
     * Save a todo.
     *
     * @param todo the entity to save.
     * @return the persisted entity.
     */
    Todo save(Todo todo);

    /**
     * Updates a todo.
     *
     * @param todo the entity to update.
     * @return the persisted entity.
     */
    Todo update(Todo todo);

    /**
     * Partially updates a todo.
     *
     * @param todo the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Todo> partialUpdate(Todo todo);

    /**
     * Get all the todos.
     *
     * @return the list of entities.
     */
    List<Todo> findAll();

    /**
     * Get the "id" todo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Todo> findOne(Long id);

    /**
     * Delete the "id" todo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
