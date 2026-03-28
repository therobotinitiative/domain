package com.orbital3d.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.orbital3d.domain.entity.TestEntity;
import org.junit.jupiter.api.Test;

public class TestAbstractCrudServiceUpdate extends AbstractCrudServiceBase {

  /** Verify update(null) throws IllegalArgumentException. */
  @Test
  public void testUpdateEntityNullThrowsIllegalArgument() {
    // Verify update() with null entity throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> spyService2.update(null));
    verifySpyService2GetRepositoryNever();
    verifySpyService2RepositorySaveNever();
  }

  /** Verify update() entity id null throws IllegalArgumentException. */
  @Test
  public void testUpdateEntityIdNullThrowsIllegalArgumentIdNull() {
    // Verify update() with null id throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> spyService2.update(new TestEntity(null)));
    verifySpyService2GetRepositoryNever();
    verifySpyService2RepositorySaveNever();
  }

  /** Verify update() repository null null throws IllegalArgumentException. */
  @Test
  public void testUpdateSaveOnce() {
    TestEntity te = new TestEntity(1L);
    spyService2.update(te);
    verifySpyService2RepositorySaveOnce(te);
    verifySpyService2GetRepositoryOnce();
  }
}
