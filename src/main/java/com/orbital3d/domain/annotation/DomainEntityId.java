package com.orbital3d.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Annotation to mark identification field. */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface DomainEntityId {
  /**
   * value is not used.
   *
   * @return value
   */
  String value() default "";
}
