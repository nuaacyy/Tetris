/*
 * Copyright (c) 2009-2018, b3log.org & hacpai.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.b3log.latke.servlet.advice;

import org.b3log.latke.ioc.Singleton;
import org.b3log.latke.servlet.HTTPRequestContext;

/**
 * BeforeRequestProcessAdvice.
 *
 * @author <a href="mailto:wmainlove@gmail.com">Love Yao</a>
 * @version 1.0.0.2, Sep 29, 2018
 */
@Singleton
public class AfterRequestProcessAdvice implements RequestProcessAdvice {

    /**
     * Do advice.
     *
     * @param context {@link HTTPRequestContext}
     * @param ret     the invoke ret
     */
    public void doAdvice(final HTTPRequestContext context, final Object ret) {
    }
}
