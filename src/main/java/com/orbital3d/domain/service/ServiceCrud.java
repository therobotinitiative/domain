package com.orbital3d.domain.service;

import com.orbital3d.domain.entity.DomainEntity;
import java.util.List;
import java.util.Optional;

/**
 * ServiceCrud interface defining basic CRUD operations for persisted entities.
 *
 * @param <ID> Entity id type
 * @param <T> Entity type
 */
public interface ServiceCrud<T extends DomainEntity<ID>, ID extends Number> {
  /**
   * Persist entity.
   *
   * @param entity Entity to persist.
   * @return Persisted entity with updated id
   * @throws IllegalArgumentException If entity is null or id is set
   */
  T add(T entity);

  /**
   * Find entity.
   *
   * @param entity Entity to find
   * @return Entity wrapped in {@link Optional}
   */
  Optional<T> find(T entity);

  /**
   * Find entity by id.
   *
   * @param id Entity id
   * @return Entity wrapped in {@link Optional}
   */
  Optional<T> findById(ID id);

  /**
   * Finf all entities.
   *
   * @return {@link List} of all entities
   */
  List<T> findAll();

  /**
   * Update existing entity. The id must be set.
   *
   * @param entity Entity to update
   * @return Updated entity
   */
  T update(T entity);

  /**
   * Delete entity.
   *
   * @param entity Entity to delete
   * @return true if success; false otherwise
   */
  boolean delete(T entity);

  /**
   * Delete entity by id.
   *
   * @param id Entity id
   * @return true if success; false otherwise
   */
  boolean deleteById(ID id);
}
