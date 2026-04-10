package org.codebreaker.domain.entity;

/**
 * Type interface.
 *
 * @param <ID> Entity id type
 */
public interface DomainEntity<ID> {
  /**
   * Get entity id.
   *
   * @return id of the entity
   */
  ID getId();
}
