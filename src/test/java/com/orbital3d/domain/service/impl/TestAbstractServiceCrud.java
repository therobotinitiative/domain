package com.orbital3d.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.jpa.repository.JpaRepository;

public class TestAbstractServiceCrud {
  /** Empty service instance returning no repository. */
  static class ShortService extends AbstractCrudService<TestEntity, Long> {
    @Override
    protected Optional<JpaRepository<TestEntity, Long>> getRepository() {
      return Optional.empty();
    }
  }

  /** Verify add(null) throws IllegalArgumentException. */
  @Test
  public void testAddThrowsIllegalArgumentEntityNull() {
    AbstractCrudService<TestEntity, Long> serviceCrud =
        Mockito.mock(ShortService.class, CALLS_REAL_METHODS);

    // Verify add(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> serviceCrud.add(null));
  }

  /** Verify add(entity with id set) throws IllegalArgumentException. */
  @Test
  public void testAddThrowsIllegalArgumentEntityIdNotNull() {
    var serviceCrud = new ShortService();

    // Verify add(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> serviceCrud.add(new TestEntity(1L)));
  }
}
