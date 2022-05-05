/*
 * Example how to use Camel-operon -component with both Camel Java and YAML DSL
 * Copyright (C) 2022, operon.io
 * MIT LICENSE
 *
 */
package io.operon;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("quartz:foo?cron={{myCron}}")
            .bean("myBean", "hello")
            .log("${body}")
            .bean("myBean", "bye")
            .log("${body}");
    }
}