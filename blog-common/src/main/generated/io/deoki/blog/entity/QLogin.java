package io.deoki.blog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLogin is a Querydsl query type for Login
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLogin extends EntityPathBase<Login> {

    private static final long serialVersionUID = 75069440L;

    public static final QLogin login = new QLogin("login");

    public final DateTimePath<java.util.Date> created = createDateTime("created", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ip = createString("ip");

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final StringPath userAgent = createString("userAgent");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QLogin(String variable) {
        super(Login.class, forVariable(variable));
    }

    public QLogin(Path<? extends Login> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLogin(PathMetadata metadata) {
        super(Login.class, metadata);
    }

}

