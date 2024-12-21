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

package com.yizlan.code.gen.common.exception;

import com.yizlan.gelato.canonical.exception.UnaryException;
import com.yizlan.gelato.canonical.panic.MetaException;

/**
 * Service exception
 *
 * @author Zen Gershon
 * @since 1.0
 */
public class ServiceException extends MetaException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getCode() {
        return (String) super.getCode();
    }

    /**
     * Constructs a new service exception with the specified code and detail message.
     * @param code error code
     * @param args reserved parameters
     */
    public ServiceException(String code, Object... args) {
        super(code, args);
    }

    /**
     * use unary generic interface as parameter
     *
     * @param exception unary generic interface
     * @param args      reserved parameters
     */
    public ServiceException(UnaryException<String> exception, Object... args) {
        super(exception, args);
    }
}
