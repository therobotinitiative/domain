package com.orbital3d.domain.entity;

/**
 * Type interface.
 * @param <ID> Entity id type
 */
public interface Entity<ID extends Number> {
    /**
     * Get entity id.
     * @return id of the entity
     */
    ID getId();
}
