package de.pilhuhn.jfs2015.runtime;

/**
 * Dummy
 *
 * @author Heiko W. Rupp
 */
public class Main {


    public static void main(String[] args) throws Exception {

        Class<UseHello> myClass = UseHello.class;

        AnnotationRuntimeReader arr = new AnnotationRuntimeReader(myClass);

        System.out.println("Greet:  " + arr.getHelloValue("greet"));
        System.out.println("Greet2: " + arr.getHelloValue("greet2"));
    }
}
