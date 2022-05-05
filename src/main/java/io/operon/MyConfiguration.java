/*
 * Example how to use Camel-operon -component with both Camel Java and YAML DSL
 * Copyright (C) 2021, operon.io
 * MIT LICENSE
 *
 */
package io.operon;

import org.apache.camel.BindToRegistry;
import org.apache.camel.PropertyInject;
import org.apache.camel.CamelConfiguration;

/**
 * Class to configure the Camel application.
 */
public class MyConfiguration implements CamelConfiguration{

    @BindToRegistry
    public MyBean myBean(@PropertyInject("hi") String hi, @PropertyInject("bye") String bye) {
        // this will create an instance of this bean with the name of the method (eg myBean)
        return new MyBean(hi, bye);
    }

    public void configure() {
        // this method is optional and can be removed if no additional configuration is needed.
    }

}