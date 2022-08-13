package com.ets.learn.netty;

import com.ets.learn.netty.handler.SimpleTCPChannelHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimpleTCPChannelHandlerTest {

    SimpleTCPChannelHandler simpleTCPChannelHandler;
    ChannelHandlerContext mockChannelHandlerContext;
    Channel mockChannel;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        simpleTCPChannelHandler = new SimpleTCPChannelHandler();
        mockChannelHandlerContext = mock(ChannelHandlerContext.class);
        mockChannel = mock(Channel.class);

        when(mockChannelHandlerContext.channel()).thenReturn(mockChannel);
        when(mockChannel.remoteAddress()).thenReturn(new InetSocketAddress(8080));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testChannelActive() {
        simpleTCPChannelHandler.channelActive(mockChannelHandlerContext);
        assertEquals("< 0.0.0.0/0.0.0.0:8080 > : Channel Active", outputStreamCaptor.toString().trim());
    }

    @Test
    void testChannelRead0() throws Exception {
        simpleTCPChannelHandler.channelRead0(mockChannelHandlerContext, "ets");
        assertEquals("id: 2 < 0.0.0.0/0.0.0.0:8080 > : ets", outputStreamCaptor.toString().trim());

    }

    @Test
    void testChannelInactive() {
        simpleTCPChannelHandler.channelInactive(mockChannelHandlerContext);
        assertEquals("< 0.0.0.0/0.0.0.0:8080 > : Channel Inactive", outputStreamCaptor.toString().trim());

    }
}