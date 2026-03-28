package com.orbital3d.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.orbital3d.domain.entity.TestEntity;
import org.junit.jupiter.api.Test;

public class TestAbstractCrudServiceDelete extends AbstractCrudServiceBase {
  @Test
  public void testDeleteEntityNullThrowsIllegalArgument() {
    // Verify delete(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> spyService1.delete(null));
    verifySpyService1GetRepositoryNever();
    verifySpyService1DeleteNever();
  }

  @Test
  public void testDeleteEntityIdNullThrowsIllegalArgument() {
    // Verify delete() entity null id throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> spyService1.delete(new TestEntity(null)));
    verifySpyService1DeleteOnce();
  }

  @Test
  public void testDeleteRepositoryNullThrowsIllegalArgument() {
    TestEntity te = new TestEntity(1L);
    // Verify delete() with null repository throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> noRepository.delete(te));
    verifyNoRepositoryGetRepositoryOnce();
  }

  @Test
  public void testDeleteOk() {
    TestEntity te = new TestEntity(1L);
    spyService1.delete(te);
    verifySpyService1GetRepositoryOnce();
    verifySpyService1DeleteOnce(te);
  }
}
