package com.elbertribeiro.feature;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum MyFeatures implements Feature {

    @Label("New description")
    DESCRIPTION_UPDATE
}

