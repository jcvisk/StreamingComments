package com.iunis.streamingcomments.controller;

import com.iunis.streamingcomments.core.domain.Comentario;
import com.iunis.streamingcomments.core.services.comentario.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComentarioRestController {

    @Autowired
    ComentarioService comentarioService;

    @RequestMapping(value = "/comentarioCreate/", method = RequestMethod.POST)
    public ResponseEntity<Void> createComment(@RequestBody Comentario comentario){
        comentarioService.createComentario(comentario);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/comentarioDelete/", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteComment(@RequestBody Long idComment){
        comentarioService.deleteComenatrio(1L);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}