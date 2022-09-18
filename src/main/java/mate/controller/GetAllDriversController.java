package mate.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Driver;
import mate.service.DriverService;

@WebServlet (urlPatterns = "/all_drivers")
public class GetAllDriversController extends HttpServlet {
    private DriverService driverService;

    @Override
    public void init() throws ServletException {
        Injector injector = Injector.getInstance("mate");
        driverService = (DriverService) injector.getInstance(DriverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Driver> allDrivers = driverService.getAll();
        req.setAttribute("drivers", allDrivers);
        req.getRequestDispatcher("WEB-INF/views/get_all_drivers.jsp").forward(req, resp);
    }
}
