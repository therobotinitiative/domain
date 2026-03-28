package com.orbital3d.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class testAbstractCrudServiceFindAll extends AbstractCrudServiceBase {
  /** Verify findAll repository null throws IllegalArgumentException. */
  @Test
  public void testFindAllRepositoryNullThrowsIllegalArgument() {
    // Verify findAll() with null repository throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> noRepository.findAll());
    verifyNoRepositoryGetRepositoryOnce();
  }

  @Test
  public void testFindAllOk() {
    // Verify findAll() doesn't throw IllegalArgumentException
    spyService1.findAll();
    verifySpyService1GetRepositoryOnce();
    verifySpyService1FindAllOnce();
  }
}
