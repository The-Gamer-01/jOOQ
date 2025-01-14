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

import org.jetbrains.annotations.NotNull;


/**
 * The final step in creating a case statement of the type <pre><code>
 * CASE WHEN x &lt; 1  THEN 'one'
 *      WHEN x &gt;= 2 THEN 'two'
 *      ELSE            'three'
 * END
 * </code></pre>
 *
 * @param <T> The type returned by this case statement
 * @author Lukas Eder
 * @see Case
 */
public interface CaseConditionStep<T> extends Field<T> {

    /**
     * Compare a condition to the already constructed case statement, return
     * result if the condition holds true
     *
     * @param condition The condition to add to the case statement
     * @param result The result value if the condition holds true
     * @return An intermediary step for case statement construction
     */
    @NotNull
    @Support
    CaseConditionStep<T> when(Condition condition, T result);

    /**
     * Compare a condition to the already constructed case statement, return
     * result if the condition holds true
     *
     * @param condition The condition to add to the case statement
     * @param result The result value if the condition holds true
     * @return An intermediary step for case statement construction
     */
    @NotNull
    @Support
    CaseConditionStep<T> when(Condition condition, Field<T> result);

    /**
     * Compare a condition to the already constructed case statement, return
     * result if the condition holds true
     *
     * @param condition The condition to add to the case statement
     * @param result The result value if the condition holds true
     * @return An intermediary step for case statement construction
     */
    @NotNull
    @Support
    CaseConditionStep<T> when(Condition condition, Select<? extends Record1<T>> result);

    /**
     * Compare a condition to the already constructed case statement, return
     * result if the condition holds true
     *
     * @param condition The condition to add to the case statement
     * @param result The result value if the condition holds true
     * @return An intermediary step for case statement construction
     */
    @NotNull
    @Support
    CaseConditionStep<T> when(Field<Boolean> condition, T result);

    /**
     * Compare a condition to the already constructed case statement, return
     * result if the condition holds true
     *
     * @param condition The condition to add to the case statement
     * @param result The result value if the condition holds true
     * @return An intermediary step for case statement construction
     */
    @NotNull
    @Support
    CaseConditionStep<T> when(Field<Boolean> condition, Field<T> result);

    /**
     * Compare a condition to the already constructed case statement, return
     * result if the condition holds true
     *
     * @param condition The condition to add to the case statement
     * @param result The result value if the condition holds true
     * @return An intermediary step for case statement construction
     */
    @NotNull
    @Support
    CaseConditionStep<T> when(Field<Boolean> condition, Select<? extends Record1<T>> result);

    /**
     * Add an else clause to the already constructed case statement
     *
     * @param result The result value if no other value matches the case
     * @return The resulting field from case statement construction
     */
    @NotNull
    @Support
    Field<T> otherwise(T result);

    /**
     * Add an else clause to the already constructed case statement
     *
     * @param result The result value if no other value matches the case
     * @return The resulting field from case statement construction
     */
    @NotNull
    @Support
    Field<T> otherwise(Field<T> result);

    /**
     * Add an else clause to the already constructed case statement
     *
     * @param result The result value if no other value matches the case
     * @return The resulting field from case statement construction
     */
    @NotNull
    @Support
    Field<T> otherwise(Select<? extends Record1<T>> result);

    /**
     * Add an else clause to the already constructed case statement
     *
     * @param result The result value if no other value matches the case
     * @return The resulting field from case statement construction
     */
    @NotNull
    @Support
    Field<T> else_(T result);

    /**
     * Add an else clause to the already constructed case statement
     *
     * @param result The result value if no other value matches the case
     * @return The resulting field from case statement construction
     */
    @NotNull
    @Support
    Field<T> else_(Field<T> result);

    /**
     * Add an else clause to the already constructed case statement
     *
     * @param result The result value if no other value matches the case
     * @return The resulting field from case statement construction
     */
    @NotNull
    @Support
    Field<T> else_(Select<? extends Record1<T>> result);
}
