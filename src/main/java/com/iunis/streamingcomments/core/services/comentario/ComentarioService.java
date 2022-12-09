package com.iunis.streamingcomments.core.services.comentario;

import com.iunis.streamingcomments.core.domain.Comentario;

import java.util.List;

public interface ComentarioService {
    public List<Comentario> comentarioList();
    public Comentario findComentarioById(Long id);
    public void createComentario(Comentario comentario);
    public void deleteComenatrio(Long idComentario);
}
