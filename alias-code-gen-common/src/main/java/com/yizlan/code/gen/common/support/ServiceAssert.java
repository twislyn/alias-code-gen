/*
 * Copyright (C) 2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yizlan.code.gen.common.support;

import com.yizlan.code.gen.common.exception.ServiceException;
import com.yizlan.gelato.canonical.exception.UnaryException;
import com.yizlan.gelato.canonical.fluent.factory.ExceptionFactory;
import com.yizlan.gelato.canonical.support.MetaAssert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Service assert
 *
 * @author Zen Gershon
 * @since 1.0
 */
public class ServiceAssert extends MetaAssert {

    static {
        registerFactory(ServiceException.class, new ExceptionFactory<String, ServiceException>() {

            @Override
            public ServiceException create(String code, Object... args) {
                return new ServiceException(code, args);
            }

        });
    }

    /**
     * Assert a boolean expression, throwing an {@code ServiceException}
     * if the condition evaluates to {@code false}.
     * <pre class="code">ServiceAssert.isTrue(i &gt; 0, "0001", ....);</pre>
     *
     * @param condition a boolean expression
     * @param code      error code
     * @param args      reserved parameters
     * @throws ServiceException if {@code condition} is {@code false}
     */
    public static void isTrue(boolean condition, String code, Object... args) {
        codeAssert(!condition).throwException(ServiceException.class, code, args);
    }

    /**
     * Assert a boolean expression, throwing an {@exception ServiceException}
     * if the condition evaluates to {@code false}.
     * <pre class="code">ServiceAssert.isTrue(i &gt; 0, ENUM.ILLEGAL_ARGUMENT_TYPE, ....);</pre>
     *
     * @param condition a boolean expression
     * @param exception error enum
     * @param args      reserved parameters
     * @throws ServiceException if {@code condition} is {@code false}
     */
    public static void isTrue(boolean condition, UnaryException<String> exception, Object... args) {
        funcAssert(!condition).throwException(ServiceException.class, exception, args);
    }

    /**
     * Assert a boolean expression, throwing an {@code ServiceException}
     * if the condition evaluates to {@code true}.
     * <pre class="code">ServiceAssert.isFalse(i &lt; 0, "0001", ....);</pre>
     *
     * @param condition a boolean expression
     * @param code      error code
     * @param args      reserved parameters
     * @throws ServiceException if {@code condition} is {@code true}
     */
    public static void isFalse(boolean condition, String code, Object... args) {
        codeAssert(condition).throwException(ServiceException.class, code, args);
    }

    /**
     * Assert a boolean expression, throwing an {@exception ServiceException}
     * if the condition evaluates to {@code true}.
     * <pre class="code">ServiceAssert.isFalse(i &lt; 0, ENUM.ILLEGAL_ARGUMENT_TYPE, ....);</pre>
     *
     * @param condition a boolean expression
     * @param exception error enum
     * @param args      reserved parameters
     * @throws ServiceException if {@code condition} is {@code true}
     */
    public static void isFalse(boolean condition, UnaryException<String> exception, Object... args) {
        funcAssert(condition).throwException(ServiceException.class, exception, args);
    }

    /**
     * Assert that an object is {@code null}.
     * <pre class="code">ServiceAssert.isNull(value, "0001", ....);</pre>
     *
     * @param target the object to check
     * @param code   error code
     * @param args   reserved parameters
     * @throws ServiceException if the target object is {@code not null}
     */
    public static void isNull(Object target, String code, Object... args) {
        codeAssert(Objects.nonNull(target)).throwException(ServiceException.class, code, args);
    }

    /**
     * Assert that an object is {@code null}.
     * <pre class="code">ServiceAssert.isNull(value, ENUM.ILLEGAL_ARGUMENT_TYPE, ....);</pre>
     *
     * @param target    the object to check
     * @param exception error enum
     * @param args      reserved parameters
     * @throws ServiceException if the target object is {@code not null}
     */
    public static void isNull(Object target, UnaryException<String> exception, Object... args) {
        funcAssert(Objects.nonNull(target)).throwException(ServiceException.class, exception, args);
    }

    /**
     * Assert that an object is {@code not null}.
     * <pre class="code">ServiceAssert.notNull(value, "0001", ....);</pre>
     *
     * @param target the object to check
     * @param code   error code
     * @param args   reserved parameters
     * @throws ServiceException if the target object is {@code null}
     */
    public static void notNull(Object target, String code, Object... args) {
        codeAssert(Objects.isNull(target)).throwException(ServiceException.class, code, args);
    }

    /**
     * Assert that an object is {@code not null}.
     * <pre class="code">ServiceAssert.notNull(value, ENUM.ILLEGAL_ARGUMENT_TYPE, ....);</pre>
     *
     * @param target    the object to check
     * @param exception error enum
     * @param args      reserved parameters
     * @throws ServiceException if the target object is {@code null}
     */
    public static void notNull(Object target, UnaryException<String> exception, Object... args) {
        funcAssert(Objects.isNull(target)).throwException(ServiceException.class, exception, args);
    }

    /**
     * Assert that an object is {@code positive}.
     * <pre class="code">ServiceAssert.isPositive(value, "0001", ....);</pre>
     *
     * @param target the number to check
     * @param code   error code
     * @param args   reserved parameters
     */
    public static void isPositive(Number target, String code, Object... args) {
        codeAssert(Objects.isNull(target) || target.doubleValue() <= 0)
                .throwException(ServiceException.class, code, args);
    }

    /**
     * Assert the target object, throwing an {@exception ServiceException}
     * if {@code target} is not null or not empty.
     * <pre class="code">ServiceAssert.isEmpty(value, "code", ...);</pre>
     *
     * @param target the object to check
     * @param code   error code
     * @param args   reserved parameters
     */
    public static void isEmpty(Object target, String code, Object... args) {
        if (target instanceof String) {
            String string = (String) target;
            if (StringUtils.hasText(string)) {
                ServiceAssert.throwException(code, args);
            }
        }

        if (!ObjectUtils.isEmpty(target)) {
            ServiceAssert.throwException(code, args);
        }
    }

    /**
     * Assert the target object, throwing an {@exception ServiceException}
     * if {@code target} is not null or not empty.
     * <pre class="code">ServiceAssert.isEmpty(value, ENUM.ILLEGAL_ARGUMENT_TYPE, ...);</pre>
     *
     * @param target    the object to check
     * @param exception error enum
     * @param args      reserved parameters
     */
    public static void isEmpty(Object target, UnaryException<String> exception, Object... args) {
        if (target instanceof String) {
            String string = (String) target;
            if (StringUtils.hasText(string)) {
                throwException(exception, args);
            }
        }

        if (!ObjectUtils.isEmpty(target)) {
            throwException(exception, args);
        }
    }

    /**
     * Assert the target object, throwing an {@exception ServiceException}
     * if {@code target} is null or empty.
     * <pre class="code">ServiceAssert.isNotEmpty(clazz, "code", ...);</pre>
     *
     * @param target the object to check
     * @param code   error code
     * @param args   reserved parameters
     */
    public static void notEmpty(Object target, String code, Object... args) {
        if (target instanceof String) {
            String string = (String) target;
            if (!StringUtils.hasText(string)) {
                ServiceAssert.throwException(code, args);
            }
        }

        if (ObjectUtils.isEmpty(target)) {
            ServiceAssert.throwException(code, args);
        }
    }

    /**
     * Assert the target object, throwing an {@exception ServiceException}
     * if {@code target} is null or empty.
     * <pre class="code">ServiceAssert.isNotEmpty(clazz, ENUM.ILLEGAL_ARGUMENT_TYPE, ...);</pre>
     *
     * @param target    the object to check
     * @param exception error enum
     * @param args      reserved parameters
     */
    public static void notEmpty(Object target, UnaryException<String> exception, Object... args) {
        if (target instanceof String) {
            String string = (String) target;
            if (!StringUtils.hasText(string)) {
                throwException(exception, args);
            }
        }

        if (ObjectUtils.isEmpty(target)) {
            throwException(exception, args);
        }
    }

    /**
     * throw {@link ServiceException}
     *
     * @param code error code
     * @param args placeholder parameters
     */
    public static void throwException(final String code, final Object... args) {
        throw createException(ServiceException.class, code, args);
    }

    /**
     * throw {@link ServiceException} that supports i18n
     *
     * @param exception error enum
     * @param args      placeholder parameters
     */
    public static void throwException(final UnaryException<String> exception, final Object... args) {
        throw createException(ServiceException.class, exception, args);
    }

}
