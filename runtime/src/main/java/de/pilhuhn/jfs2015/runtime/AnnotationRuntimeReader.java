/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.pilhuhn.jfs2015.runtime;

import java.lang.reflect.Method;

import de.pilhuhn.jfs2015.annotations.Hello;

/**
 * Helfer zum Annotationen auslesen
 *
 * @author Heiko W. Rupp
 */
public class AnnotationRuntimeReader {

    private Class annotationClazz;

    public AnnotationRuntimeReader(Class annotationClazz) {
        this.annotationClazz = annotationClazz;
    }

    public String getHelloValue(String methodenName) {


        Method[] methods = annotationClazz.getDeclaredMethods();
        for (Method m: methods) {
            if (m.getName().equals(methodenName)) {
                Hello annotation = m.getAnnotation(Hello.class);
                return annotation.value();
            }
        }
        return "- not found -";
    }
}
