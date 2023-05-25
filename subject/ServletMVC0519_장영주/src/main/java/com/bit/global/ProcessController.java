package com.bit.global;

import com.bit.global.ForWardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface ProcessController {
     public ForWardController execute(HttpServletRequest request,
                                      HttpServletResponse response) throws UnsupportedEncodingException;
}
