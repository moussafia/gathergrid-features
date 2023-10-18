package com.gathergrid.gathergridfeatures.controller;
import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.gathergrid.gathergridfeatures.controller.methodes.RegistrationValidation.hashPassword;
import static com.gathergrid.gathergridfeatures.controller.methodes.RegistrationValidation.registreValidation;

@WebServlet(value = "/registrationServlet")
public class registrationServlet extends HttpServlet {
    private UserService service ;

    @Override
    public void init() {
        service = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        List<String> resultValidation = registreValidation(firstName, lastName, email, password);
        if (!resultValidation.isEmpty()) {
            request.setAttribute("validationErrors", resultValidation);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        } else {
            String message = "";
            String hashed = hashPassword(password);
            Optional<User> save = service.save(new User(firstName, lastName, email, hashed));
            if (save.isPresent()) {
                message = "User successfully registered.";
            } else {
                message = "Email already exists. Please use a different email.";
            }

            request.setAttribute("registrationMessage", message);

            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
