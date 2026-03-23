package com.orbital3d.domain.graphql;

import java.util.List;
import java.util.function.Predicate;

import com.orbital3d.domain.entity.Entity;
import com.orbital3d.domain.service.ServiceCrud;

/**
 * GraphQL CRUD service.
 * @param <ID> Entity id type
 * @param <T>  Entity type
 */
public interface GraphQLCrudService<T extends Entity<ID>, ID extends Number>
    extends ServiceCrud<T, ID> {
    /**
     * Filter all with predicate.
     * @param <P> Predicate type
     * @param predicate Predicate
     * @return {@link List} of entities matching the predicate
     */
    <P> List<T> filter(Predicate<P> predicate);
}
