package com.orbital3d.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.orbital3d.domain.entity.TestEntity;
import org.junit.jupiter.api.Test;

public class TestAbstractCrudServiceAdd extends AbstractCrudServiceBase {
  @Test
  public void testAddThrowsIllegalArgumentEntityNull() {
    assertThrows(IllegalArgumentException.class, () -> spyService1.add(null));
    verifySpyService1GetRepositoryNever();
  }

  @Test
  public void testAddThrowsIllegalArgumentEntityIdNotNull() {
    assertThrows(IllegalArgumentException.class, () -> spyService1.add(new TestEntity(1L)));
    verifySpyService1GetRepositoryNever();
  }

  @Test
  public void testRepositorySave() {
    TestEntity te = new TestEntity();
    spyService2.add(te);
    verifySpyService2GetRepositoryOnce();
    verifySpyService2RepositorySaveOnce(te);
  }

  @Test
  public void testRepositorySaveNever() {
    assertThrows(IllegalArgumentException.class, () -> spyService2.add(new TestEntity(1L)));
    verifySpyService2GetRepositoryNever();
    verifySpyService2RepositorySaveNever();
  }

  @Test
  public void testAddEntityOk() {
    TestEntity te = new TestEntity(null);
    spyService1.add(te);
    verifySpyService1GetRepositoryOnce();
    verifySpyService1AddOnce(te);
  }
}
