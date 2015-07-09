package de.pilhuhn.jfs2015.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Eine Nur-Source Annotation.
 * Bessere Version von java.lang.Deprecated
 *
 * @author Heiko W. Rupp
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Deprecated {

    String seit();
    String alternative();
}
