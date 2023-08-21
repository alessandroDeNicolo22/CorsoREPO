package com.progettoCorso.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDocente is a Querydsl query type for Docente
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDocente extends EntityPathBase<Docente> {

    private static final long serialVersionUID = -779268722L;

    public static final QDocente docente = new QDocente("docente");

    public final StringPath cognome = createString("cognome");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nome = createString("nome");

    public QDocente(String variable) {
        super(Docente.class, forVariable(variable));
    }

    public QDocente(Path<? extends Docente> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDocente(PathMetadata metadata) {
        super(Docente.class, metadata);
    }

}

