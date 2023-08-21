package com.progettoCorso.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAula is a Querydsl query type for Aula
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAula extends EntityPathBase<Aula> {

    private static final long serialVersionUID = -1780031827L;

    public static final QAula aula = new QAula("aula");

    public final StringPath descrizione = createString("descrizione");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> numeroPosti = createNumber("numeroPosti", Integer.class);

    public QAula(String variable) {
        super(Aula.class, forVariable(variable));
    }

    public QAula(Path<? extends Aula> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAula(PathMetadata metadata) {
        super(Aula.class, metadata);
    }

}

