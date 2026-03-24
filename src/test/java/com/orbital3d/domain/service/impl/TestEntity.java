package com.orbital3d.domain.service.impl;

import com.orbital3d.domain.entity.DomainEntity;

/** Simple test entity implementing {@link DomainEntity}&lt;Long&gt; to ease testing. */
public final class TestEntity implements DomainEntity<Long> {
  /** Entity id. */
  private Long id;

  /** No-arg constructor for tests. */
  public TestEntity() {}

  /**
   * Create test entity with id.
   *
   * @param newId initial id
   */
  public TestEntity(final Long newId) {
    this.id = newId;
  }

  /** {@inheritDoc} */
  @Override
  public Long getId() {
    return id;
  }

  /**
   * Set entity id.
   *
   * @param newId new id
   */
  public void setId(final Long newId) {
    this.id = newId;
  }
}
