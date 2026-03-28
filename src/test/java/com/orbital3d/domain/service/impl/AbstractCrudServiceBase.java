package com.orbital3d.domain.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.orbital3d.domain.entity.TestEntity;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.data.jpa.repository.JpaRepository;

/** Abstract base class for testing {@link AbstractServiceCrud}. */
public abstract class AbstractCrudServiceBase {
  @Spy protected JpaRepository<TestEntity, Long> mockRepository1;

  @Spy protected JpaRepository<TestEntity, Long> mockRepository2;

  @Spy protected AbstractServiceCrud<TestEntity, Long> spyService1;

  @Spy protected AbstractServiceCrud<TestEntity, Long> spyService2;

  @Spy protected AbstractServiceCrud<TestEntity, Long> noRepository;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
    when(noRepository.getRepository()).thenReturn(Optional.empty());
    when(spyService1.getRepository()).thenReturn(Optional.of(mockRepository1));
    when(spyService2.getRepository()).thenReturn(Optional.of(mockRepository2));
  }

  protected void verifyNoRepositoryGetRepositoryNever() {
    verify(noRepository, never()).getRepository();
  }

  protected void verifyNoRepositoryGetRepositoryOnce() {
    verify(noRepository, atMost(1)).getRepository();
  }

  protected void verifyNoRepositoryDeleteNever() {
    verify(noRepository, never()).delete(any());
  }

  protected void verifyNoRepositoryDeleteNever(TestEntity te) {
    verify(noRepository, never()).delete(eq(te));
  }

  protected void verifyNoRepositoryDeleteByIdNever() {
    verify(noRepository, never()).deleteById(any());
  }

  protected void verifyNoRepositoryDeleteByIdNever(Long id) {
    verify(noRepository, never()).deleteById(eq(id));
  }

  protected void verifySpyService1GetRepositoryNever() {
    verify(spyService1, never()).getRepository();
  }

  protected void verifySpyService1GetRepositoryOnce() {
    verify(spyService1, atMost(1)).getRepository();
  }

  protected void verifySpyService1AddOnce() {
    verify(mockRepository1, atMost(1)).save(any());
  }

  protected void verifySpyService1AddOnce(TestEntity te) {
    verify(mockRepository1, atMost(1)).save(eq(te));
  }

  protected void verifySpyService1RepositoryFindByIdNever() {
    verify(mockRepository1, never()).findById(any());
  }

  protected void verifySpyService1RepositoryFindByIdOnce() {
    verify(mockRepository1, atMost(1)).findById(any());
  }

  protected void verifySpyService1RepositoryFindByIdOnce(Long id) {
    verify(mockRepository1, atMost(1)).findById(eq(id));
  }

  protected void verifySpyService1FindAllOnce() {
    verify(mockRepository1, atMost(1)).findAll();
  }

  protected void verifySpyService1FindAllNever() {
    verify(mockRepository1, never()).findAll();
  }

  protected void verifySpyService1DeleteNever() {
    verify(mockRepository1, never()).delete(any());
  }

  protected void verifySpyService1DeleteNever(TestEntity te) {
    verify(mockRepository1, never()).delete(eq(te));
  }

  protected void verifySpyService1DeleteOnce() {
    verify(mockRepository1, atMost(1)).delete(any());
  }

  protected void verifySpyService1DeleteOnce(TestEntity te) {
    verify(mockRepository1, atMost(1)).delete(eq(te));
  }

  protected void verifySpyService1DeleteByIdNever() {
    verify(mockRepository1, never()).deleteById(any());
  }

  protected void verifySpyService1DeleteByIdOnce() {
    verify(mockRepository1, atMost(1)).deleteById(any());
  }

  protected void verifySpyService1DeleteByIdOnce(Long id) {
    verify(mockRepository1, atMost(1)).deleteById(eq(id));
  }

  protected void verifySpyService2GetRepositoryNever() {
    verify(spyService2, never()).getRepository();
  }

  protected void verifySpyService2GetRepositoryOnce() {
    verify(spyService2, atLeastOnce()).getRepository();
  }

  protected void verifySpyService2RepositorySaveOnce() {
    verify(mockRepository2, atMost(1)).save(any());
  }

  protected void verifySpyService2RepositorySaveOnce(TestEntity testEntity) {
    verify(mockRepository2, atMost(1)).save(eq(testEntity));
  }

  protected void verifySpyService2RepositorySaveNever() {
    verify(mockRepository2, never()).save(any());
  }
}
