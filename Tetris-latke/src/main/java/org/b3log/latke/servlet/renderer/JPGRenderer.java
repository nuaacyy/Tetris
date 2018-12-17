/*
 * Copyright (c) 2009-2017, b3log.org & hacpai.com
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
package org.b3log.latke.servlet.renderer;


import org.b3log.latke.image.Image;
import org.b3log.latke.logging.Level;
import org.b3log.latke.logging.Logger;
import org.b3log.latke.servlet.HTTPRequestContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


/**
 * JPEG HTTP response renderer.
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.0.0.0, Sep 18, 2012
 */
public final class JPGRenderer extends AbstractHTTPResponseRenderer {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(JPGRenderer.class);

    /**
     * Image to render.
     */
    private Image image;

    /**
     * Sets the image with the specified image.
     * 
     * @param image the specified image
     */
    public void setImage(final Image image) {
        this.image = image;
    }

    @Override
    public void render(final HTTPRequestContext context) {
        try {
            final HttpServletResponse response = context.getResponse();

            response.setContentType("image/jpeg");

            final OutputStream outputStream = response.getOutputStream();

            outputStream.write(image.getData());
            outputStream.close();
        } catch (final IOException e) {
            LOGGER.log(Level.ERROR, "Render failed", e);
        }
    }
}
