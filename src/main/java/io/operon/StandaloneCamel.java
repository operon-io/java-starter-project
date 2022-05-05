/*
 * Example how to use Camel-operon -component with both Camel Java and YAML DSL
 * Copyright (C) 2021, operon.io
 * MIT LICENSE
 *
 */
package io.operon;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * This is an alternative example to show how you can use a public static void main class
 * to run Camel standalone (without help from its Main class). This is to demonstrate
 * what code you need to write to startup Camel without any help (or magic).
 * <p/>
 * Compare this example with {@link MyApplication} which uses Camel's main class to
 * run Camel standalone in a easier way.
 */
public final class StandaloneCamel {

    private StandaloneCamel() {
    }

    public static void main(String[] args) throws Exception {
        // create a new CamelContext
        CamelContext camelContext = new DefaultCamelContext();

        // configure where to load properties file in the properties component
        camelContext.getPropertiesComponent().setLocation("classpath:application.properties");
        // resolve property placeholder
        String hello = camelContext.resolvePropertyPlaceholders("{{hi}}");

        // and create bean with the placeholder
        MyBean myBean = new MyBean(hello, "Bye");
        // register bean to Camel
        camelContext.getRegistry().bind("myBean", myBean);

        // add routes to Camel
        camelContext.addRoutes(new MyRouteBuilder());

        // start Camel
        camelContext.start();

        // just run for 10 seconds and stop
        System.out.println("Running for 10 seconds and then stopping");
        Thread.sleep(10000);

        // stop and shutdown Camel
        camelContext.stop();
    }
}