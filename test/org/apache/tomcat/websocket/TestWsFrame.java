/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tomcat.websocket;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestWsFrame {

    @Test
    public void testByteArrayToLong() throws IOException {
        Assert.assertEquals(0L, WsFrameBase.byteArrayToLong(new byte[] { 0 }, 0, 1));
        Assert.assertEquals(1L, WsFrameBase.byteArrayToLong(new byte[] { 1 }, 0, 1));
        Assert.assertEquals(0xFF, WsFrameBase.byteArrayToLong(new byte[] { -1 }, 0, 1));
        Assert.assertEquals(0xFFFF, WsFrameBase.byteArrayToLong(new byte[] { -1, -1 }, 0, 2));
        Assert.assertEquals(0xFFFFFF, WsFrameBase.byteArrayToLong(new byte[] { -1, -1, -1 }, 0, 3));
        Assert.assertEquals(0xFFFFFFFFL, WsFrameBase.byteArrayToLong(new byte[] { -1, -1, -1, -1 }, 0, 4));
        Assert.assertEquals(0xFFFFFFFFFFL, WsFrameBase.byteArrayToLong(new byte[] { -1, -1, -1, -1, -1 }, 0, 5));
        Assert.assertEquals(0xFFFFFFFFFFFFL, WsFrameBase.byteArrayToLong(new byte[] { -1, -1, -1, -1, -1, -1 }, 0, 6));
        Assert.assertEquals(0xFFFFFFFFFFFFFFL,
                WsFrameBase.byteArrayToLong(new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 7));
        Assert.assertEquals(0x7FFFFFFFFFFFFFFFL,
                WsFrameBase.byteArrayToLong(new byte[] { 127, -1, -1, -1, -1, -1, -1, -1 }, 0, 8));
        Assert.assertEquals(-1,
                WsFrameBase.byteArrayToLong(new byte[] { -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8));
    }


    @Test
    public void testByteArrayToLongOffset() throws IOException {
        Assert.assertEquals(0L, WsFrameBase.byteArrayToLong(new byte[] { 20, 0 }, 1, 1));
        Assert.assertEquals(1L, WsFrameBase.byteArrayToLong(new byte[] { 20, 1 }, 1, 1));
        Assert.assertEquals(0xFF, WsFrameBase.byteArrayToLong(new byte[] { 20, -1 }, 1, 1));
        Assert.assertEquals(0xFFFF, WsFrameBase.byteArrayToLong(new byte[] { 20, -1, -1 }, 1, 2));
        Assert.assertEquals(0xFFFFFF, WsFrameBase.byteArrayToLong(new byte[] { 20, -1, -1, -1 }, 1, 3));
        Assert.assertEquals(0xFFFFFFFFL, WsFrameBase.byteArrayToLong(new byte[] { 20, -1, -1, -1, -1 }, 1, 4));
        Assert.assertEquals(0xFFFFFFFFFFL, WsFrameBase.byteArrayToLong(new byte[] { 20, -1, -1, -1, -1, -1 }, 1, 5));
        Assert.assertEquals(0xFFFFFFFFFFFFL,
                WsFrameBase.byteArrayToLong(new byte[] { 20, -1, -1, -1, -1, -1, -1 }, 1, 6));
        Assert.assertEquals(0xFFFFFFFFFFFFFFL,
                WsFrameBase.byteArrayToLong(new byte[] { 20, -1, -1, -1, -1, -1, -1, -1 }, 1, 7));
        Assert.assertEquals(0x7FFFFFFFFFFFFFFFL,
                WsFrameBase.byteArrayToLong(new byte[] { 20, 127, -1, -1, -1, -1, -1, -1, -1 }, 1, 8));
        Assert.assertEquals(-1,
                WsFrameBase.byteArrayToLong(new byte[] { 20, -1, -1, -1, -1, -1, -1, -1, -1 }, 1, 8));
    }
}
