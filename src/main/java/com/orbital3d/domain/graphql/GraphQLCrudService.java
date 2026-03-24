package com.orbital3d.domain.graphql;

import com.orbital3d.domain.entity.DomainEntity;
import com.orbital3d.domain.service.ServiceCrud;
import java.util.List;
import java.util.function.Predicate;

/**
 * GraphQL CRUD service.
 *
 * @param <T> Entity type
 * @param <I> Entity id type
 */
public interface GraphQLCrudService<T extends DomainEntity<I>, I extends Number>
    extends ServiceCrud<T, I> {

  /**
   * Filter all with predicate.
   *
   * @param <P> Predicate type
   * @param predicate Predicate
   * @return {@link List} of entities matching the predicate
   */
  <P> List<T> filter(Predicate<P> predicate);
}
