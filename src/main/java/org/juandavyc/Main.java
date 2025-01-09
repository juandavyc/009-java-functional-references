package org.juandavyc;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.function.Predicate;
public class Main {
    public static void main(String[] args) {

        /*
         Formato--> referencia :: nombre del metodo
                Tipos->{
                    nombre de la clase:: metodo static
                    nombre de la clase:: metodo
                    nombre de la clase:: new
                    objeto:: metodo
                }
        */

        var value = "Esternocleidomastoideo";
        var instance = new Main();

        Supplier<String> instanceMethod = value::toUpperCase;
        Supplier<String> instanceMethod2 = instance::getAnything;
        Supplier<String> instanceMethod3 = instance::getReferencedMethod;

        Supplier<Main> constructorReference = Main::new;

        Predicate<String> staticMethod = Objects::isNull;

        System.out.println("instanceMethod: "+instanceMethod.get());
        System.out.println("instanceMethod2: "+instanceMethod2.get());
        System.out.println("instanceMethod3: "+instanceMethod3.get());
        System.out.println("constructorReference: "+constructorReference.get().toString());
        System.out.println("staticMethod: "+staticMethod.test(null));

    }

    public String getReferencedMethod(){
        Supplier<String> supplier = this::getAnything;
        return supplier.get().concat("--> called with this");
    }
    public String getAnything() {
        return "Anything";
    }

    @Override
    public String toString() {
        return "Referencia de :"+super.toString();
    }
}