package com.progettoCorso.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCorso is a Querydsl query type for Corso
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCorso extends EntityPathBase<Corso> {

    private static final long serialVersionUID = 655262942L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCorso corso1 = new QCorso("corso1");

    public final StringPath corso = createString("corso");

    public final DatePath<java.sql.Date> dataInizio = createDate("dataInizio", java.sql.Date.class);

    public final StringPath durata = createString("durata");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QAula oAula;

    public final QDocente oDocente;

    public final ListPath<Studente, QStudente> partecipanti = this.<Studente, QStudente>createList("partecipanti", Studente.class, QStudente.class, PathInits.DIRECT2);

    public QCorso(String variable) {
        this(Corso.class, forVariable(variable), INITS);
    }

    public QCorso(Path<? extends Corso> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCorso(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCorso(PathMetadata metadata, PathInits inits) {
        this(Corso.class, metadata, inits);
    }

    public QCorso(Class<? extends Corso> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.oAula = inits.isInitialized("oAula") ? new QAula(forProperty("oAula")) : null;
        this.oDocente = inits.isInitialized("oDocente") ? new QDocente(forProperty("oDocente")) : null;
    }

}

