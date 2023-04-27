package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProcessController {
     public ForwardController execute(HttpServletRequest request,
                                      HttpServletResponse response);
}
