package org.codebreaker.domain.graphql;

import java.util.List;
import java.util.function.Predicate;
import org.codebreaker.domain.entity.DomainEntity;
import org.codebreaker.domain.service.ServiceCrud;

/**
 * GraphQL CRUD service.
 *
 * @param <T> Entity type
 * @param <ID> Entity id type
 */
public interface GraphQLCrudService<T extends DomainEntity<ID>, ID> extends ServiceCrud<T, ID> {

  /**
   * Filter all with predicate.
   *
   * @param <P> Predicate type
   * @param predicate Predicate
   * @return {@link List} of entities matching the predicate
   */
  <P> List<T> filter(Predicate<P> predicate);
}
