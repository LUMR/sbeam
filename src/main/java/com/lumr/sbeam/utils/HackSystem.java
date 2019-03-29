package com.lumr.sbeam.utils;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-03-29
 **/
public class HackSystem {

    private static PrintOut out;

    public HackSystem() {
    }

    private class PrintOut extends PrintStream {

        public PrintOut(OutputStream out) {
            super(out);
        }
    }
}
