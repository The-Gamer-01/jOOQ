/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq;

import org.jetbrains.annotations.*;


import java.util.Collection;

import org.jooq.impl.DSL;

/**
 * This type is used for the {@link Update}'s DSL API.
 * <p>
 * Example: <pre><code>
 * DSLContext create = DSL.using(configuration);
 *
 * create.update(table)
 *       .set(field1, value1)
 *       .set(field2, value2)
 *       .where(field1.greaterThan(100))
 *       .execute();
 * </code></pre>
 * <p>
 * <h3>Referencing <code>XYZ*Step</code> types directly from client code</h3>
 * <p>
 * It is usually not recommended to reference any <code>XYZ*Step</code> types
 * directly from client code, or assign them to local variables. When writing
 * dynamic SQL, creating a statement's components dynamically, and passing them
 * to the DSL API statically is usually a better choice. See the manual's
 * section about dynamic SQL for details: <a href=
 * "https://www.jooq.org/doc/latest/manual/sql-building/dynamic-sql">https://www.jooq.org/doc/latest/manual/sql-building/dynamic-sql</a>.
 * <p>
 * Drawbacks of referencing the <code>XYZ*Step</code> types directly:
 * <ul>
 * <li>They're operating on mutable implementations (as of jOOQ 3.x)</li>
 * <li>They're less composable and not easy to get right when dynamic SQL gets
 * complex</li>
 * <li>They're less readable</li>
 * <li>They might have binary incompatible changes between minor releases</li>
 * </ul>
 *
 * @author Lukas Eder
 */
public interface UpdateWhereStep<R extends Record> extends UpdateOrderByStep<R> {

    /**
     * Add conditions to the query, connecting them with each other with
     * {@link Operator#AND}.
     */
    @NotNull @CheckReturnValue
    @Support
    UpdateConditionStep<R> where(Condition condition);

    /**
     * Add conditions to the query, connecting them with each other with
     * {@link Operator#AND}.
     */
    @NotNull @CheckReturnValue
    @Support
    UpdateConditionStep<R> where(Condition... conditions);

    /**
     * Add conditions to the query, connecting them with each other with
     * {@link Operator#AND}.
     */
    @NotNull @CheckReturnValue
    @Support
    UpdateConditionStep<R> where(Collection<? extends Condition> conditions);

    /**
     * Add conditions to the query
     */
    @NotNull @CheckReturnValue
    @Support
    UpdateConditionStep<R> where(Field<Boolean> condition);

    /**
     * Add conditions to the query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(SQL)
     * @see SQL
     */
    @NotNull @CheckReturnValue
    @Support
    @PlainSQL
    UpdateConditionStep<R> where(SQL sql);

    /**
     * Add conditions to the query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String)
     * @see SQL
     */
    @NotNull @CheckReturnValue
    @Support
    @PlainSQL
    UpdateConditionStep<R> where(String sql);

    /**
     * Add conditions to the query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, Object...)
     * @see DSL#sql(String, Object...)
     * @see SQL
     */
    @NotNull @CheckReturnValue
    @Support
    @PlainSQL
    UpdateConditionStep<R> where(String sql, Object... bindings);

    /**
     * Add conditions to the query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, QueryPart...)
     * @see DSL#sql(String, QueryPart...)
     * @see SQL
     */
    @NotNull @CheckReturnValue
    @Support
    @PlainSQL
    UpdateConditionStep<R> where(String sql, QueryPart... parts);

    /**
     * Add an EXISTS clause to the query
     */
    @NotNull @CheckReturnValue
    @Support
    UpdateConditionStep<R> whereExists(Select<?> select);

    /**
     * Add a NOT EXISTS clause to the query
     */
    @NotNull @CheckReturnValue
    @Support
    UpdateConditionStep<R> whereNotExists(Select<?> select);
}
