package com.iunis.streamingcomments.core.services.comentario;

import com.iunis.streamingcomments.core.domain.Comentario;
import com.iunis.streamingcomments.core.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Comentario> comentarioList() {
        return (List<Comentario>) comentarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Comentario findComentarioById(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void createComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void deleteComenatrio(Long idComentario) {
        comentarioRepository.deleteById(idComentario);
    }
}
