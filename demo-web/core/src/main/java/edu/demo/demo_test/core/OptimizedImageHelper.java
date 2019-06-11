package edu.devry.dvu_marketing.core.utils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class)
public final class OptimizedImageHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(OptimizedImageHelper.class);

    @Inject
    @Optional
    private String imageProperty;

    @Inject
    @Optional
    private String width;
    
    private String srcPath;

    @PostConstruct
    public void activate() {
        if (imageProperty != null) {
            String fileExtension = FilenameUtils.getExtension(imageProperty);
    
            srcPath = imageProperty + ".dvu.opt-image";
            if (width != null) { 
                srcPath += "." + width + ".";
            }
            srcPath += "." + fileExtension;
        } else {
            srcPath = StringUtils.EMPTY;
        }
    }

    public String getSrcPath() {
        return srcPath;
    }
}
