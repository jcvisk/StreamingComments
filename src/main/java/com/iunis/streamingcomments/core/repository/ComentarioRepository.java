package com.iunis.streamingcomments.core.repository;

import com.iunis.streamingcomments.core.domain.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
}
