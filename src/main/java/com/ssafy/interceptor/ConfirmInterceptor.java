
package com.ssafy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.member.model.MemberDto;

@SuppressWarnings("deprecation")
 //	spring 5.3
//	부터는 HandlerInterceptor implements

public class ConfirmInterceptor implements HandlerInterceptor {
  
  @Override public boolean preHandle(HttpServletRequest request,
  HttpServletResponse response, Object handler) throws Exception { HttpSession
  session = request.getSession(); MemberDto memberDto = (MemberDto)
  session.getAttribute("userinfo"); if(memberDto == null) {
  response.sendRedirect(request.getContextPath() + "/user/login"); return
  false; } return true; }
  
  }
