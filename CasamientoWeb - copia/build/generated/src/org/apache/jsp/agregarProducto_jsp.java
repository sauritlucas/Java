package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class agregarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container padding\">\n");
      out.write("            <main role=\"main\" class=\"col-12\">\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <h2>Agregar Productos</h2> \n");
      out.write("                    <a href=\"indexAdmin.jsp\" class=\"btn btn-outline-primary\" type=\"button\" style=\"margin-left: 950px;\">Volver  <svg width=\"1em\" height=\"1em\" viewBox=\"0 0 16 16\" class=\"bi bi-arrow-return-left\" fill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg%22%3E\n");
      out.write("                        <path fill-rule=\"evenodd\" d=\"M14.5 1.5a.5.5 0 0 1 .5.5v4.8a2.5 2.5 0 0 1-2.5 2.5H2.707l3.347 3.346a.5.5 0 0 1-.708.708l-4.2-4.2a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 8.3H12.5A1.5 1.5 0 0 0 14 6.8V2a.5.5 0 0 1 .5-.5z\"/>\n");
      out.write("                        </svg></a>\n");
      out.write("                </div><hr>\n");
      out.write("                <div class=\"col-6\">\n");
      out.write("                    <form id=\"formAltaRegalo\" method=\"POST\" action=\"ABMRegaloServlet\"  onsubmit=\"return validar();\" >\n");
      out.write("                        <div class=\"form-group mt-6\">\n");
      out.write("                            <label for=\"descripcionRegalo\">Descripcion</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"descripcionRegalo\" name=\"txtDescripcion\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group mt-6\">\n");
      out.write("                            <label for=\"descripcionRegalo\">Precio</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"precio\" name=\"txtPrecio\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\" name=\"opcion\" value=\"crear\">Agregar Regalo</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div><hr>\n");
      out.write("            </main>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
