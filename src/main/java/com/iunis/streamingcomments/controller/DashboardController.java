package com.iunis.streamingcomments.controller;

import com.iunis.streamingcomments.core.domain.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import java.util.Date;

@Controller
public class DashboardController {
    @Autowired
    private ServletContext context;

    @GetMapping("/dashboard")
    public String dashboardAdmin(Comentario comentario, Model model){
        //Mandando a la vista contextPath, date y comentarioObjet
        model.addAttribute("contextPath", context.getContextPath());
        model.addAttribute("date", new Date().getTime());
        model.addAttribute("comentarioObjet", comentario);
        return "dashboard";
    }

    @GetMapping("/personalizacion")
    public String test(){
        return "configComments";
    }
}
