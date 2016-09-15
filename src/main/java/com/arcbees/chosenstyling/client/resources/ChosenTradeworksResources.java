package com.arcbees.chosenstyling.client.resources;

import com.google.gwt.resources.client.CssResource;
import com.watopi.chosen.client.resources.ChozenCss;
import com.watopi.chosen.client.resources.Resources;

public interface ChosenTradeworksResources extends Resources {
    interface CustomChosenCss extends ChozenCss {
    }
    @CssResource.NotStrict
    @Override
    @Source({"css/chosenTradeworksColors.gss",
            "css/mixins.gss",
            "css/tradeworks.gss",
            "css/mobile.gss",
            "css/chosen.gss"})
    CustomChosenCss css();
}
