package filter;

import beans.UserAccount;
import utils.DBUtils;
import utils.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * In case, the user logined and  remembered information in previous access (for example the day before).
 * And now the user return, this Filter will check the Cookie information stored by the browser and automatic Login.
 */
@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
    public CookieFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpSession session = req.getSession();

            UserAccount userInSession = MyUtils.getLoginedUser(session);
            //
            if (userInSession != null) {
                session.setAttribute("COOKIE_CHECKED", "CHECKED");
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            // Connection was created in JDBCFilter.
            Connection conn = MyUtils.getStoredConnection(servletRequest);

            // Flag check cookie
            String checked = (String) session.getAttribute("COOKIE_CHECKED");
            if (checked == null && conn != null) {
                String userName = MyUtils.getUserNameInCookie(req);
                try {
                    UserAccount user = DBUtils.findUser(conn, userName);
                    MyUtils.storeLoginedUser(session, user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // Mark checked Cookies.
                session.setAttribute("COOKIE_CHECKED", "CHECKED");
            }

            filterChain.doFilter(servletRequest, servletResponse);
        }

    public void destroy() {

    }
}
