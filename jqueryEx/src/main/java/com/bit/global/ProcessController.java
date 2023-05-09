package com.bit.global;

import com.bit.global.ForWardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProcessController {
     public ForWardController execute(HttpServletRequest request,
                                      HttpServletResponse response);
}
