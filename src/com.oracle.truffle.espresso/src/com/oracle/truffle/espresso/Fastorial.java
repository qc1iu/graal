/*
 * Copyright (c) 2018, 2018, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.espresso;

import java.math.BigInteger;

public class Fastorial {

    static BigInteger mul(int from, int to) {
        if (from == to) {
            return BigInteger.valueOf(to);
        }
        int mid = from + (to - from) / 2;
        return mul(from, mid).multiply(mul(mid + 1, to));
    }

    static BigInteger fastorial(int n) {
        assert n > 0;
        return mul(1, n);
    }

    static BigInteger bruteFactorial(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 2; i <= n; ++i) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    public static void main(String[] args) {
        long ticks = System.currentTimeMillis();
        int n = Integer.parseInt(args[0]);
        BigInteger f = fastorial(n);
        System.out.println(n + "! = " + f);
        System.out.println("Elapsed: " + (System.currentTimeMillis() - ticks) + " ms");
    }
}
