package com.orbital3d.domain.service.impl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.springframework.data.jpa.repository.JpaRepository;

public class TestAbstractServiceCrud {
  /** Empty service instance returning no repository. */
  static class ShortService extends AbstractServiceCrud<TestEntity, Long> {
    @Override
    protected Optional<JpaRepository<TestEntity, Long>> getRepository() {
      return Optional.empty();
    }
  }

  /** Verify add(null) throws IllegalArgumentException. */
  @Test
  public void testAddThrowsIllegalArgumentEntityNull() {
    AbstractServiceCrud<TestEntity, Long> serviceCrud =
        mock(ShortService.class, CALLS_REAL_METHODS);

    // Verify add(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> serviceCrud.add(null));
    verify(serviceCrud, never()).getRepository();
  }

  /** Verify add(entity with id set) throws IllegalArgumentException. */
  @Test
  public void testAddThrowsIllegalArgumentEntityIdNotNull() {
    var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

    // Verify add(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> serviceCrud.add(new TestEntity(1L)));
    verify(serviceCrud, never()).getRepository();
  }

  /** Verify find entity null throws IllegalArgumentException. */
  @Test
  public void testFindThrowsIllegalArgumentEntityNull() {
    var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

    // Verify add(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> serviceCrud.find(null));
    verify(serviceCrud, never()).getRepository();
  }

  /** Verify find entity id null throws IllegalArgumentException. */
  @Test
  public void testFindThrowsIllegalArgumentEntityIdNull() {
    var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

    // Verify add(null) throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> serviceCrud.find(new TestEntity(null)));
    verify(serviceCrud, never()).getRepository();
  }

  /** Verify find entity id null throws IllegalArgumentException. */
  @Test
  public void testFindByIdThrowsIllegalArgumentIdIdNull() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify add(null) throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.findById(null));
      verify(serviceCrud, never()).getRepository();
  }

  /** Verify findAll repository null throws IllegalArgumentException. */
  @Test
  public void testFindAllRepositoryNullThrowsIllegalArgumentIdIdNull() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify findAll() with null repository throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.findAll());
  }

  /** Verify update(null) throws IllegalArgumentException. */
  @Test
  public void testUpdateEntityNullThrowsIllegalArgument() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify update() with null entity throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.update(null));
      verify(serviceCrud, never()).getRepository();
  }

  /** Verify update() entity id null throws IllegalArgumentException. */
  @Test
  public void testUpdateEntityIdNullThrowsIllegalArgumentIdNull() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify update() with null id throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.update(new TestEntity(null)));
      verify(serviceCrud, never()).getRepository();
  }

  /** Verify update() repository null null throws IllegalArgumentException. */
  @Test
  public void testUpdateRepositoryNullThrowsIllegalArgument() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify update() with null repository throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.update(new TestEntity(1L)));
      verify(serviceCrud, atLeastOnce()).getRepository();
  }

  /** Verify delete(null) throws IllegalArgumentException. */
  @Test
  public void testDeleteEntityNullThrowsIllegalArgument() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify delete() with null entity throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.delete(null));
      verify(serviceCrud, never()).getRepository();
  }

  /** Verify delete id null throws IllegalArgumentException. */
  @Test
  public void testDeleteEntityIdNullThrowsIllegalArgument() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify delete() null id throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.delete(new TestEntity(null)));
      verify(serviceCrud, never()).getRepository();
  }

  /** Verify delete repository null throws IllegalArgumentException. */
  @Test
  public void testDeleteRepositoryNullThrowsIllegalArgument() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify delete() with null repository throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.delete(new TestEntity(1L)));
      verify(serviceCrud, atLeastOnce()).getRepository();
  }

  /** Verify deleteById id null throws IllegalArgumentException. */
  @Test
  public void testDeleteByIdIdNullThrowsIllegalArgument() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify delete() with null repository throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.deleteById(null));
      verify(serviceCrud, never()).getRepository();
  }

  /** Verify deleteById repository null throws IllegalArgumentException. */
  @Test
  public void testDeleteByIdRepositoryNullThrowsIllegalArgument() {
      var serviceCrud = mock(ShortService.class, CALLS_REAL_METHODS);

      // Verify delete() with null repository throws IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> serviceCrud.deleteById(1L));
      verify(serviceCrud, atLeastOnce()).getRepository();
  }
}
