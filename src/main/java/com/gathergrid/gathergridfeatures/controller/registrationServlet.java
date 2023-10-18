package com.gathergrid.gathergridfeatures.controller;
import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public static  List<String> registreValidation(String firstName ,String lastName , String email , String password){

        List<String> validationErrors = new ArrayList<>();

        if (firstName == null || firstName.isBlank()) {
            validationErrors.add("First name is required.");
        }

        if (lastName == null || lastName.isBlank()) {
            validationErrors.add("Last name is required.");
        }

        if (email == null || email.isBlank()) {
            validationErrors.add("Email is required.");
        }

        if (password == null || password.isBlank()) {
            validationErrors.add("Password is required.");
        }

        if (email != null && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            validationErrors.add("Invalid email format.");
        }

        return validationErrors;
    }

    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
}
