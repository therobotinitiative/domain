package com.orbital3d.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestAbstractCrudServiceFindById extends AbstractCrudServiceBase {
  /** Verify findById(null) throws IllegalArgumentException. */
  @Test
  public void testFindByIdThrowsIllegalArgumentIdIdNull() {
    // Verify findById(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> spyService1.findById(null));
    verifySpyService1GetRepositoryNever();
    verifySpyService1RepositoryFindByIdNever();
  }

  /** Verify findById(null) doesn't throw IllegalArgumentException. */
  @Test
  public void testFindById() {
    Long id = 1L;
    spyService1.findById(id);
    verifySpyService1GetRepositoryOnce();
    verifySpyService1RepositoryFindByIdOnce(id);
  }
}
