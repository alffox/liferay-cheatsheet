package com.liferay.poc.editor.ck;


import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.util.StreamUtil;

import java.io.IOException;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = DynamicInclude.class)
public class PoCCKEditorOnEditorCreatedDynamicInclude implements DynamicInclude {

    @Override
    public void include(
            HttpServletRequest request, HttpServletResponse response,
            String key)
            throws IOException {

        Bundle bundle = _bundleContext.getBundle();

        URL entryURL = bundle.getEntry(
                "/META-INF/resources/ckeditor/dtd_definition.js");

        StreamUtil.transfer(
                entryURL.openStream(), response.getOutputStream(), false);
    }

    @Override
    public void register(
            DynamicInclude.DynamicIncludeRegistry dynamicIncludeRegistry) {
        dynamicIncludeRegistry.register(
                "com.liferay.frontend.editor.ckeditor.web#ckeditor#onEditorCreate");
    }

    @Activate
    protected void activate(BundleContext bundleContext) {
        _bundleContext = bundleContext;
    }

    private BundleContext _bundleContext;

}
