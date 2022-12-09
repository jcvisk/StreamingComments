package com.iunis.streamingcomments.controller;

import com.iunis.streamingcomments.core.domain.Comentario;
import com.iunis.streamingcomments.core.services.comentario.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/display")
    public String display(){
        return "displayComments";
    }

    @GetMapping("/getComentario")
    @ResponseBody
    public Comentario getComentario(){
        return comentarioService.findComentarioById(1L);
    }
}
