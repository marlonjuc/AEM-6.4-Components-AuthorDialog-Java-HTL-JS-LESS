package edu.devry.dvu_marketing.core.utils;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = { Resource.class, SlingHttpServletRequest.class })
public class HtlUtils {
    @PostConstruct
    public void activate() {
    }
    
    public String getRandomUuid() {
        return UUID.randomUUID().toString();
    }
}
