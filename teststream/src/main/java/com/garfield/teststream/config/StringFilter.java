package com.garfield.teststream.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Jingly
 * @create: 2019-07-26 15:26
 **/
@Slf4j
public class StringFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    log.info("执行StringFilter.....");
    filterChain.doFilter(servletRequest,servletResponse);
  }

  @Override
  public void destroy() {

  }
}
