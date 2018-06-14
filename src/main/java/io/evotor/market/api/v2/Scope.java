package io.evotor.market.api.v2;

/**
 * Marker for a required oauth scope
 */
public @interface Scope {

    String value() default "";

    String[] optional() default {};

}
