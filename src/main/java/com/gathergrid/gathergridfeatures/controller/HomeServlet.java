//package com.gathergrid.gathergridfeatures.controller;
//
//import jakarta.inject.Inject;
//import jakarta.security.enterprise.SecurityContext;
//import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
//import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.HttpConstraint;
//import jakarta.servlet.annotation.ServletSecurity;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/home")
//@FormAuthenticationMechanismDefinition(
//        loginToContinue = @LoginToContinue(errorPage = "/error.html",
//                                           loginPage = "/welcome.html")
//)
//@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "user", "admin" },
//    transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL))
//public class HomeServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Inject
//    private SecurityContext securityContext;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (securityContext.isCallerInRole("user")) {
//            resp.sendRedirect("/admin.jsp");
//        } else if (securityContext.isCallerInRole("user")) {
//            resp.sendRedirect("/user.jsp");
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
