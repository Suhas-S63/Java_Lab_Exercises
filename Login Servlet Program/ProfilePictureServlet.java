import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfilePictureServlet")
public class ProfilePictureServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the username from the session
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");

            // Fetch the profile picture path from the database based on the username
            String profilePicturePath = getProfilePicturePathFromDatabase(username);

            // Setting the content type 
            response.setContentType("image/*");

            // Read the profile picture file and write it to the response output stream
            try (InputStream inputStream = new FileInputStream(profilePicturePath);
                 OutputStream outputStream = response.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        } else {
            // Redirect to login page if the user is not logged in
            response.sendRedirect("index.html"); // Change to the appropriate page
        }
    }

    // You need to implement this method based on your system's logic for fetching profile picture paths
    private String getProfilePicturePathFromDatabase(String username) {
        return "D:/Wallpapers/8.jpg";
    }
}
