package net.codejava.spring.config;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {
	 /**
	  * Construct a wrapper for this request
	  * @param request
	  */
	 public HeaderMapRequestWrapper(HttpServletRequest request) {
	  super(request);
	 }

	 private Map<String, String> headerMap = new HashMap<>();

	 /**
	  * Get header
	  *
	  * @param name
	  * @return
	     */
	 @Override
	 public String getHeader(String name) {
	  String headerValue = super.getHeader(name);
	  if (headerMap.containsKey(name)) {
	   headerValue = headerMap.get(name);
	  }
	  return headerValue;
	 }

	 /**
	  * Get the Header names
	  */
	 @Override
	 public Enumeration<String> getHeaderNames() {
	  List<String> names = Collections.list(super.getHeaderNames());
	  for (String name : headerMap.keySet()) {
	   names.add(name);
	  }
	  return Collections.enumeration(names);
	 }

	 /**
	  * Get header
	  * @param name
	  * @return
	     */
	 @Override
	 public Enumeration<String> getHeaders(String name) {
	  List<String> values = Collections.list(super.getHeaders(name));
	  if (headerMap.containsKey(name)) {
	   values.add(headerMap.get(name));
	  }
	  return Collections.enumeration(values);
	 }

	}
