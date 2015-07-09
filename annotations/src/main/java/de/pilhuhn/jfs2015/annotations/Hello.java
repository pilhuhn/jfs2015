
package de.pilhuhn.jfs2015.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Eine Gruß-Annotation
 *
 * @author Heiko W. Rupp
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Hello {
    String value() default "World";
}
