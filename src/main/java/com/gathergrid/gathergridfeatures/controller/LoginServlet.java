package com.gathergrid.gathergridfeatures.controller;

import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/LoginServlet")
public class LoginServlet extends HelloServlet{
    private UserService service ;

    @Override
    public void init() {
        service = new UserService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<String> resultValidation = loginValidation(email, password);
        User user = new User();

        user.setEmail(email);
        user.setPassword(password);

        if(resultValidation.isEmpty()) {
            Optional<User> user1 = service.CheckEmail(user);

            if (user1.isPresent()) {
                request.getSession(true).setAttribute("user", user1.get());
                request.setAttribute("success", "You are logged in successfully");
                this.getServletContext().getRequestDispatcher("/Dashboard.jsp").forward(request, response);

                request.setAttribute("validationEmail", "Email Or Password Not exists Create account.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("validationEmail", "Email Or Password Not exists Create account.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
        else {
            request.setAttribute("validation", " Entre your Email and Password !!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
    public static List<String> loginValidation(String email , String password){

        List<String> validationErrors = new ArrayList<>();

        if (password == null || password.isBlank()) {
            validationErrors.add("Password is required.");
        }

        if (email != null && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            validationErrors.add("Invalid email format.");
        }

        return validationErrors;
    }
}
