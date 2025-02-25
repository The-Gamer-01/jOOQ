/*
 * This file is generated by jOOQ.
 */
package org.jooq.example.flyway.ddl.db.h2.tables;


import java.time.LocalDate;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.example.flyway.ddl.db.h2.FlywayTest;
import org.jooq.example.flyway.ddl.db.h2.Keys;
import org.jooq.example.flyway.ddl.db.h2.tables.records.AuthorRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Author extends TableImpl<AuthorRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>FLYWAY_TEST.AUTHOR</code>
     */
    public static final Author AUTHOR = new Author();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorRecord> getRecordType() {
        return AuthorRecord.class;
    }

    /**
     * The column <code>FLYWAY_TEST.AUTHOR.ID</code>.
     */
    public final TableField<AuthorRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>FLYWAY_TEST.AUTHOR.FIRST_NAME</code>.
     */
    public final TableField<AuthorRecord, String> FIRST_NAME = createField(DSL.name("FIRST_NAME"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>FLYWAY_TEST.AUTHOR.LAST_NAME</code>.
     */
    public final TableField<AuthorRecord, String> LAST_NAME = createField(DSL.name("LAST_NAME"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>FLYWAY_TEST.AUTHOR.DATE_OF_BIRTH</code>.
     */
    public final TableField<AuthorRecord, LocalDate> DATE_OF_BIRTH = createField(DSL.name("DATE_OF_BIRTH"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>FLYWAY_TEST.AUTHOR.YEAR_OF_BIRTH</code>.
     */
    public final TableField<AuthorRecord, Integer> YEAR_OF_BIRTH = createField(DSL.name("YEAR_OF_BIRTH"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>FLYWAY_TEST.AUTHOR.ADDRESS</code>.
     */
    public final TableField<AuthorRecord, String> ADDRESS = createField(DSL.name("ADDRESS"), SQLDataType.VARCHAR(50), this, "");

    private Author(Name alias, Table<AuthorRecord> aliased) {
        this(alias, aliased, null);
    }

    private Author(Name alias, Table<AuthorRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>FLYWAY_TEST.AUTHOR</code> table reference
     */
    public Author(String alias) {
        this(DSL.name(alias), AUTHOR);
    }

    /**
     * Create an aliased <code>FLYWAY_TEST.AUTHOR</code> table reference
     */
    public Author(Name alias) {
        this(alias, AUTHOR);
    }

    /**
     * Create a <code>FLYWAY_TEST.AUTHOR</code> table reference
     */
    public Author() {
        this(DSL.name("AUTHOR"), null);
    }

    public <O extends Record> Author(Table<O> child, ForeignKey<O, AuthorRecord> key) {
        super(child, key, AUTHOR);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : FlywayTest.FLYWAY_TEST;
    }

    @Override
    public UniqueKey<AuthorRecord> getPrimaryKey() {
        return Keys.PK_T_AUTHOR;
    }

    @Override
    public Author as(String alias) {
        return new Author(DSL.name(alias), this);
    }

    @Override
    public Author as(Name alias) {
        return new Author(alias, this);
    }

    @Override
    public Author as(Table alias) {
        return new Author(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(String name) {
        return new Author(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(Name name) {
        return new Author(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(Table name) {
        return new Author(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, LocalDate, Integer, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link #convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Integer, ? super String, ? super String, ? super LocalDate, ? super Integer, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link #convertFrom(Class, Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Integer, ? super String, ? super String, ? super LocalDate, ? super Integer, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
