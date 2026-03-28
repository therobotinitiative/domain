package com.orbital3d.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestAbstractCrudServiceDeleteById extends AbstractCrudServiceBase {
  @Test
  public void testDeleteByIdIdNullNoRepositoryThrowsIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> noRepository.deleteById(null));
    verifySpyService1GetRepositoryOnce();
    verifySpyService1DeleteByIdNever();
  }

  @Test
  public void testDeleteByIdIdNullThrowsIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> spyService1.deleteById(null));
    verifySpyService1GetRepositoryOnce();
    verifySpyService1DeleteByIdNever();
  }

  @Test
  public void testDeleteByIdNoRepositoryNullThrowsIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> noRepository.deleteById(1L));
    verifyNoRepositoryGetRepositoryOnce();
  }

  @Test
  public void testDeleteByIdOk() {
    spyService1.deleteById(1L);
    verifySpyService1GetRepositoryOnce();
    verifySpyService1DeleteByIdOnce(1L);
  }
}
