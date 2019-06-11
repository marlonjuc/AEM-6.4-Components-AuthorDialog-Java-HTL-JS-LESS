package edu.demo.demo_web.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import edu.demo.demo_test.core.utils.OptimizedImageHelper;

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeroImageModel {
    @SlingObject
    private Resource resource;

    @Inject
    private ValueMap pageProperties;

    @ValueMapValue
    private String backgroundImage;

    private String heroImageSrc;

    @PostConstruct
    private void initModel() {
        heroImageSrc = pageProperties.get("locationImage", null);
        if (backgroundImage != null) {
            heroImageSrc = backgroundImage;
        }
    }

    public String getHeroImageSrc() {
        return heroImageSrc;
    }
}
