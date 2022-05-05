/*
 * Example how to use Camel-operon -component with both Camel Java and YAML DSL
 * Copyright (C) 2021, operon.io
 * MIT LICENSE
 *
 */
package io.operon;

public class MyBean {

    private String hi;
    private String bye;

    public MyBean(String hi, String bye) {
        this.hi = hi;
        this.bye = bye;
    }

    public String hello() {
        return hi + " how are you?";
    }

    public String bye() {
        return bye + " World";
    }
}