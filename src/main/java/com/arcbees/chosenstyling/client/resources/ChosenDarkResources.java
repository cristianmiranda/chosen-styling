package com.arcbees.chosenstyling.client.resources;

import com.arcbees.chosen.client.resources.ChosenCss;
import com.arcbees.chosen.client.resources.Resources;

public interface ChosenDarkResources extends Resources {
    interface CustomChosenCss extends ChosenCss {
    }

    @Override
    @Source({"com/arcbees/gsss/mixin/client/mixins.gss",
            "com/arcbees/chosen/client/resources/icons/icons.gss",
            "css/chosenDarkColors.gss",
            "com/arcbees/chosen/client/resources/css/chosen.gss",
            "css/custom.gss",
            "com/arcbees/chosen/client/resources/css/mobile.gss"})
    CustomChosenCss css();
}
