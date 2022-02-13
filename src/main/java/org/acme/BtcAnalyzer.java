/*
 * Copyright (C) 2022, operon.io
 * MIT LICENSE
 *
 */
package org.acme;

import io.operon.runner.node.type.*;
import io.operon.runner.model.exception.OperonGenericException;
import io.operon.runner.OperonFunction;
import io.operon.runner.statement.Statement;

public class BtcAnalyzer implements OperonFunction {
    public OperonValue execute(Statement stmt, OperonValue params) throws OperonGenericException {
        System.out.println("Analyzing...");
        NumberType num = (NumberType) params.evaluate();
        StringType result = null;
        if (num.getDoubleValue() < 10000) {
            result = StringType.create(stmt, "BUY");
        }
        else {
            result = StringType.create(stmt, "HOLD");
        }
        return result;
    }
}