/*
 * Copyright (c) Alex Shvid. All Rights Reserved. 2011
 */

package com.shvid.klod.net;

import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;

public class Locator extends ManagedServer {

  private final static Logger log = Logger.getLogger(Locator.class);

  @Override
  protected MemberRole serverRole() {
    return MemberRole.LOCATOR;
  }
  
  @Override
  protected ChannelPipelineFactory createPipelineFactory(ThreadPoolExecutor pipelineExecutor, ClientSocketChannelFactory clientFactory) {
    return new LocatorPipelineFactory(pipelineExecutor, clientFactory);
  }

  public static void main(String[] args) {
    launch(new Locator(), args);
  }

}
