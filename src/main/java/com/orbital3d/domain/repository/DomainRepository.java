package com.orbital3d.domain.repository;

import com.orbital3d.domain.entity.DomainEntity;
import java.util.List;
import java.util.Optional;

/**
 * DomainRepository interface defining basic persistence operations for domain entities. This is a
 * generic interface that can be implemented by various persistence technologies (e.g., JPA,
 * MongoDB, etc.) to provide a consistent API for entity operations. Client provides the
 * implementation of this interface to perform persistence operations on domain keeping this
 * interface technology-agnostic.
 *
 * @param <T> Entity type
 * @param <ID> Entity identification type
 */
public interface DomainRepository<T extends DomainEntity<ID>, ID> {

  /**
   * Persist the entity.
   *
   * @param entity Entity to persist
   * @return Persisted entity
   */
  T save(T entity);

  /**
   * Find the entity by id.
   *
   * @param id Id of the entity to find
   * @return Found entity wrapped in {@link Optional}
   */
  Optional<T> findById(ID id);

  /**
   * Find all entities.
   *
   * @return List of all entities
   */
  List<T> findAll();

  /**
   * Delete the entity by id.
   *
   * @param id Id of the entity to delete
   */
  void deleteById(ID id);

  /**
   * Delete the entity.
   *
   * @param entity Entity to delete
   */
  void delete(T entity);
}
