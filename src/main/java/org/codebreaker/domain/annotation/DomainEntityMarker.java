package org.codebreaker.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Annotation to mark a class as a domain entity class. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DomainEntityMarker {
  /** No values needed for this annotation, it serves as a marker for domain entity classes. */
}
