package com.iunis.streamingcomments.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table (name = "comentarios")
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column (name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name="comentario")
    private String comment;

    @Column(name = "urlimage")
    private String urlImage;

    @Column(name = "autor")
    private String autor;

    @Column(name = "plataforma")
    private String plataforma;

    @Column(name = "background")
    private String background;

}
