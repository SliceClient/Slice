package com.sliceclient.client.module.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.sliceclient.client.module.enums.ModuleCategory;

/**
 * An {@code Annotation} used for module info.
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModuleData {

    String name();

    String description() default "Default description :(";

    ModuleCategory category();

    int defaultKeyBind() default 0;

}
