/*
 * Copyright (c) 2004, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package nsk.jvmti.scenarios.events.EM07;

import java.io.PrintStream;

import nsk.share.*;
import nsk.share.jvmti.*;

public class em07t001 extends DebugeeClass {

    // load native library if required
    static {
        System.loadLibrary("em07t001");
    }

    // run test from command line
    public static void main(String argv[]) {
        argv = nsk.share.jvmti.JVMTITest.commonInit(argv);

        // JCK-compatible exit
        System.exit(run(argv, System.out) + Consts.JCK_STATUS_BASE);
    }

    // run test from JCK-compatible environment
    public static int run(String argv[], PrintStream out) {
        return new em07t001().runIt(argv, out);
    }

    /* =================================================================== */

    // scaffold objects
    ArgumentHandler argHandler = null;
    static Log log = null;
    Log.Logger logger;
    long timeout = 0;
    int status = Consts.TEST_PASSED;

    // run debuggee
    public int runIt(String argv[], PrintStream out) {
        argHandler = new ArgumentHandler(argv);
        log = new Log(out, argHandler);
        logger = new Log.Logger(log,"debuggee> ");
        timeout = argHandler.getWaitTime() * 60000; // milliseconds
        logger.display("Timeout = " + timeout + " msc.");

        status = em07t001.checkStatus(Consts.TEST_PASSED);
        if (status != Consts.TEST_PASSED) {
            logger.complain("Test FAILED");
        } else {
            logger.display("Test PASSED");
        }

        return status;
    }

}
