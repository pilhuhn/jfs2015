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
package de.pilhuhn.jfs2015.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.pilhuhn.jfs2015.annotations.Deprecated;

/**
 * Beispiel-Prozessor
 *
 * @author Heiko W. Rupp
 */
@SuppressWarnings("unused")
@SupportedOptions({JfsApt.VERBOSE})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({ "de.pilhuhn.jfs2015.*"})
public class JfsApt extends AbstractProcessor {

    public static final String VERBOSE = "verbose";
    private boolean verbose = false;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        Map<String,String> options = processingEnv.getOptions();
        if (options.containsKey(VERBOSE)) {
            String val = options.get(VERBOSE);
            verbose = Boolean.parseBoolean(val);
            System.out.println("verbose");
        }
    }

    @Override
    public boolean process(
            Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {

        if (verbose) {
            System.out.println("JFS-Prozessor aufgerufen.");
        }

        // Wir waren schon in der ersten Runde fertig
        if (roundEnv.processingOver()) {
            return false;
        }

        for (Element e : roundEnv.getRootElements()) {
            processClass((TypeElement) e);
        }

        return true;
    }

    private void processClass(TypeElement e) {
        String clazz = e.getQualifiedName().toString();
        if (verbose) {
            System.out.println("Klasse: " + clazz);
        }

        Deprecated deprecated = e.getAnnotation(Deprecated.class);
        if (deprecated !=null) {

            // Annotation gefunden
            System.err.println("Klasse " + clazz + " is deprecated seit "+
                    deprecated.seit() +". Bitte " +
                    deprecated.alternative() + " benutzen."
            );

        }

        // ALle Kind Elemente
        List<? extends Element> childElements = e.getEnclosedElements();
        // Wir wollen nur die Methoden
                List<ExecutableElement> exElements = ElementFilter.methodsIn(childElements);
                for (ExecutableElement ee : exElements) {
                    deprecated = ee.getAnnotation(Deprecated.class);
                    if (deprecated!=null) {
                        // Annotation gefunden
                        String name = clazz + "." +ee.getSimpleName().toString();
                        System.err.println("Methode " + name + "() is deprecated seit "+
                                deprecated.seit() +". Bitte " +
                                        deprecated.alternative() + "() benutzen."
                        );
                    }
                }
    }


}
