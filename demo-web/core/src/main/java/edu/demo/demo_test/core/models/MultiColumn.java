package edu.demo.demo_web.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiColumn {
    @Inject
    private String backgroundColorTab1;
    @Inject
    private String backgroundColorTab2;
    @Inject
    private String backgroundColorTab3;
    @Inject
    private String backgroundColorTab4;

    @Inject
    private String topPaddingCol1;
    @Inject
    private String topPaddingCol2;
    @Inject
    private String topPaddingCol3;
    @Inject
    private String topPaddingCol4;

    private String additionalColumnClasses;
    private String inlineStylesCol1 = StringUtils.EMPTY;
    private String inlineStylesCol2 = StringUtils.EMPTY;
    private String inlineStylesCol3 = StringUtils.EMPTY;
    private String inlineStylesCol4 = StringUtils.EMPTY;

    @PostConstruct
    public void initModel() {
        //check that model fields are initialized
        if(backgroundColorTab1 != null) {
            //set padding classes
            if (backgroundColorTab1.contains("backgroundPadding") || backgroundColorTab2.contains("backgroundPadding")
                    ||backgroundColorTab3.contains("backgroundPadding") || backgroundColorTab4.contains("backgroundPadding")) {
                additionalColumnClasses = "backgroundPaddingAdjacent";
            }
        }

        generateColumnInlineStyles();
    }

    private void generateColumnInlineStyles() {
        inlineStylesCol1 = setColumnStyles(topPaddingCol1);
        inlineStylesCol2 = setColumnStyles(topPaddingCol2);
        inlineStylesCol3 = setColumnStyles(topPaddingCol3);
        inlineStylesCol4 = setColumnStyles(topPaddingCol4);
    }

    private String setColumnStyles (String topPadding) {
        if (topPadding != null) {
            return "padding-top: " + topPadding + ";";
        }
        return null;
    }

    public String getAdditionalColumnClasses() {
        return additionalColumnClasses;
    }

    public String getInlineStylesCol1() {
        return inlineStylesCol1;
    }

    public String getInlineStylesCol2() {
        return inlineStylesCol2;
    }

    public String getInlineStylesCol3() {
        return inlineStylesCol3;
    }

    public String getInlineStylesCol4() {
        return inlineStylesCol4;
    }
}
