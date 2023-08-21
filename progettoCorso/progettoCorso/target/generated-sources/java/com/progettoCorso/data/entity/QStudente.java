package com.progettoCorso.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudente is a Querydsl query type for Studente
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudente extends EntityPathBase<Studente> {

    private static final long serialVersionUID = -1653463666L;

    public static final QStudente studente = new QStudente("studente");

    public final StringPath cognome = createString("cognome");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath matricola = createString("matricola");

    public final StringPath nome = createString("nome");

    public QStudente(String variable) {
        super(Studente.class, forVariable(variable));
    }

    public QStudente(Path<? extends Studente> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudente(PathMetadata metadata) {
        super(Studente.class, metadata);
    }

}

