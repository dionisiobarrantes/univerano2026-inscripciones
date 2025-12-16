/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.awt.font.TextAttribute;
 
/**
 *
 * @author dionisio.barrantes
 */


public class MyCaptcha extends HttpServlet {
 
    private int height = 0;
    private int width = 0;
    public static final String CAPTCHA_KEY = "captcha_key_name";
 
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        height = Integer.parseInt(getServletConfig().getInitParameter("height"));
        width = Integer.parseInt(getServletConfig().getInitParameter("width"));
    }
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        //Expire response
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Max-Age", 0);
 
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
        Random r = new Random();
        String token = Long.toString(Math.abs(r.nextLong()), 36);
        String ch = token.substring(0, 6);
        Color c = new Color(0.6662f, 0.4569f, 0.3232f);
        GradientPaint gp = new GradientPaint(30, 30, c, 15, 25, Color.white, true);
        graphics2D.setPaint(gp);
        Font font = new Font("Verdana", Font.CENTER_BASELINE, 26);
        graphics2D.setFont(font);
        graphics2D.drawString(ch, 2, 20);
        graphics2D.dispose();
 
        HttpSession session = req.getSession(true);
        session.setAttribute(CAPTCHA_KEY, ch);
 
        try (OutputStream outputStream = response.getOutputStream()) {
            ImageIO.write(image, "jpeg", outputStream);
        }
    }
}
