/*
 * Copyright (C) 2022, operon.io
 * MIT LICENSE
 *
 */
package org.acme;

import io.operon.runner.node.type.*;
import io.operon.runner.model.OperonConfigs;
import io.operon.runner.model.exception.OperonGenericException;
import io.operon.runner.OperonContext;
import io.operon.runner.OperonContextManager;
import io.operon.runner.OperonRunner;
import io.operon.runner.OperonFunction;
import io.operon.runner.statement.Statement;

/**
 * A basic example running as public static void main.
 */
public final class JavaApp {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Select: ");
        sb.append("  -> http:{url: \"https://api.coindesk.com/v1/bpi/currentprice.json\"}");
        sb.append("  .body                                                               ");
        sb.append("  ..EUR[1]                                                            ");
        sb.append("  .rate_float                                                         ");
        sb.append("  -> call:{id: \"analyze\", params: @}                                ");

        BtcAnalyzer analyzer = new BtcAnalyzer();
        OperonRunner.registerFunction("analyze", analyzer);

        OperonConfigs configs = new OperonConfigs();
        configs.setOutputResult(false);
        OperonValue result = OperonRunner.doQuery(sb.toString(), configs);
        
        System.out.println("Result: " + result.toString());
    }

}
