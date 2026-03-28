package com.orbital3d.domain.service.impl;

import com.orbital3d.domain.entity.DomainEntity;
import com.orbital3d.domain.service.ServiceCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Abstract JPA implementation of the {@link ServiceCrud}.
 *
 * @param <T> Entity type
 * @param <ID> Entity id type
 */
public abstract class AbstractServiceCrud<T extends DomainEntity<ID>, ID extends Number>
    implements ServiceCrud<T, ID> {

  /** Default construtor. */
  public AbstractServiceCrud() {
    // Nothing
  }

  /**
   * Return {@link JpaRepository} to perform entity operations.
   *
   * @return {@link JpaRepository} wrapped in {@link Optional}
   */
  protected abstract Optional<JpaRepository<T, ID>> getRepository();

  /**
   * Acquires repository. Invokes {@link #getRepository()} and throws exception if not provided.
   *
   * @return Repository instance
   * @throws IllegalArgumentException
   */
  private JpaRepository<T, ID> acquireRepository() {
    return getRepository()
        .orElseThrow(() -> new IllegalArgumentException("Repository not provided"));
  }

  /**
   * Verify the entity instance.
   *
   * @param entity Entity to check
   * @throws IllegalArgumentException If entity is null
   */
  protected final void checkEntity(final T entity) {
    validateNotNull(entity, "entity cannot be null");
  }

  /**
   * Check the entity id for persisting. Id must be null when persisting entity.
   *
   * @param entity Entity to check its id
   * @throws IllegalArgumentException If the id is not null; If entity is null
   */
  protected final void checkEntityIdNull(final T entity) {
    checkEntity(entity);
    if (entity.getId() != null) {
      throw new IllegalArgumentException("ID cannot be set when persisting entity");
    }
  }

  /**
   * Check the entity id is not null.
   *
   * @param entity Entity to check its id
   * @throws IllegalArgumentException If the id is null; If entity is null
   */
  protected final void checkEntityIdNotNull(final T entity) {
    checkEntity(entity);
    validateNotNull(entity.getId(), "ID cannot be null");
  }

  /**
   * Check the value is not null.
   *
   * @param value Value to check
   * @throws IllegalArgumentException If the value is null
   */
  protected final void validateNotNull(final Object value) {
    if (value == null) {
      throw new IllegalArgumentException("Value is null");
    }
  }

  /**
   * Check the value is not null.
   *
   * @param value Value to check
   * @param message Message in the exception
   * @throws IllegalArgumentException If the value is null
   */
  protected final void validateNotNull(final Object value, final String message) {
    if (value == null) {
      throw new IllegalArgumentException(message);
    }
  }

  // Null checked
  @SuppressWarnings("null")
  @Override
  public final T add(final T entity) {
    checkEntityIdNull(entity);
    return acquireRepository().save(entity);
  }

  // Null checked
  @SuppressWarnings("null")
  @Override
  public final Optional<T> find(final T entity) {
    checkEntityIdNotNull(entity);
    return acquireRepository().findById(entity.getId());
  }

  // Null checked
  @SuppressWarnings("null")
  @Override
  public final Optional<T> findById(final ID id) {
    validateNotNull(id);
    return acquireRepository().findById(id);
  }

  @Override
  public final List<T> findAll() {
    var repo = getRepository().orElseThrow(() -> new IllegalArgumentException("Repository null"));
    return repo.findAll();
  }

  // Null checked
  @SuppressWarnings("null")
  @Override
  public final T update(final T entity) {
    checkEntityIdNotNull(entity);
    var repo = getRepository().orElseThrow(() -> new IllegalArgumentException("Repository null"));
    return repo.save(entity);
  }

  // Null checked
  @SuppressWarnings("null")
  @Override
  public final boolean delete(final T entity) {
    checkEntityIdNotNull(entity);
    var repo = getRepository().orElseThrow(() -> new IllegalArgumentException("Repository null"));
    repo.deleteById(entity.getId());
    return true;
  }

  // Null checked
  @SuppressWarnings("null")
  @Override
  public final boolean deleteById(final ID id) {
    validateNotNull(id);
    var repo = getRepository().orElseThrow(() -> new IllegalArgumentException("Repository null"));
    repo.deleteById(id);
    return true;
  }
}
