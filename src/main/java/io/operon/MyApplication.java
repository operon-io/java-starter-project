/*
 * Example how to use Camel-operon -component with both Camel Java and YAML DSL
 * Copyright (C) 2021, operon.io
 * MIT LICENSE
 *
 */
package io.operon;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

/**
 * Main class that boot the Camel application
 */
public final class MyApplication {

    private MyApplication() {
    }

    public static void main(String[] args) throws Exception {
        // use Camels Main class
        Main main = new Main();
        // let's use a configuration class (you can specify multiple classes)
        // (properties are automatic loaded from application.properties)
        
        main.configure().addConfiguration(MyConfiguration.class);
        // and add the routes (you can specify multiple classes)
        main.configure().addRoutesBuilder(MyRouteBuilder.class);
        // now keep the application running until the JVM is terminated (ctrl + c or sigterm)
        main.run(args);
    }

}