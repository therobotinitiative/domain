package org.codebreaker.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.codebreaker.domain.entity.TestEntity;
import org.junit.jupiter.api.Test;

public class TestAbstractCrudServiceFind extends AbstractCrudServiceBase {
  /** Verify find entity null throws IllegalArgumentException. */
  @Test
  public void testFindThrowsIllegalArgumentEntityNull() {
    // Verify add(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> spyService1.find(null));
    verifySpyService1GetRepositoryNever();
  }

  /** Verify find entity id null throws IllegalArgumentException. */
  @Test
  public void testFindThrowsIllegalArgumentEntityIdNull() {
    assertThrows(IllegalArgumentException.class, () -> spyService1.find(new TestEntity(null)));
    verifySpyService1GetRepositoryNever();
  }
}
