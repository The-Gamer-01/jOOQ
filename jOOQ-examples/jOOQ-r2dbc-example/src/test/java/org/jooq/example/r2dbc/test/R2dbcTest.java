package org.jooq.example.r2dbc.test;

import static org.jooq.example.r2dbc.db.Tables.AUTHOR;
import static org.jooq.example.r2dbc.db.Tables.BOOK;

import org.jooq.DSLContext;
import org.jooq.RowCountQuery;
import org.jooq.Source;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import reactor.core.publisher.Flux;

public class R2dbcTest {

    DSLContext ctx;
    
    @Before
    public void setup() {
        ConnectionFactory connectionFactory = ConnectionFactories.get(
            ConnectionFactoryOptions
                .parse("r2dbc:h2:file://localhost/~/jooq-r2dbc-example")
                .mutate()
                .option(ConnectionFactoryOptions.USER, "sa")
                .option(ConnectionFactoryOptions.PASSWORD, "")
                .build()
        );
        
        ctx = DSL.using(connectionFactory);
        
        try {
            Flux.fromIterable(ctx.parser().parse(Source.of(R2dbcTest.class.getResourceAsStream("/db.sql")).readString()))
                .ofType(RowCountQuery.class)
                .flatMap(q -> q)
                .collectList()
                .block();
            
            Assert.fail("The fix for https://github.com/r2dbc/r2dbc-h2/issues/203 has been released");
        }
        
        // A fix for https://github.com/r2dbc/r2dbc-h2/issues/203 has been implemented but not yet released
        catch (NoSuchMethodError expected) {}
    }

    @Test
    public void test() {
        try {
            Flux.from(ctx
                    .insertInto(AUTHOR)
                    .columns(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                    .values("John", "Doe")
                    .returningResult(AUTHOR.ID))
                .flatMap(id -> ctx
                    .insertInto(BOOK)
                    .columns(BOOK.AUTHOR_ID, BOOK.TITLE)
                    .values(id.value1(), "Fancy Book"))
                .thenMany(ctx
                    .select(BOOK.author().FIRST_NAME, BOOK.author().LAST_NAME, BOOK.TITLE)
                    .from(BOOK))
                .doOnNext(System.out::println)
                .subscribe();
        
            Assert.fail("The fix for https://github.com/r2dbc/r2dbc-h2/issues/203 has been released");
        }
        // A fix for https://github.com/r2dbc/r2dbc-h2/issues/203 has been implemented but not yet released
        catch (NoSuchMethodError expected) {}
    }
}