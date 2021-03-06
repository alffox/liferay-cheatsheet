package com.liferay.poc.editor.ck;


import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;

@Component(
        property = {
            "editor.name=ckeditor",
            "javax.portlet.name=com_liferay_blogs_web_portlet_BlogsPortlet",
            "javax.portlet.name=com_liferay_blogs_web_portlet_BlogsAdminPortlet",
            "javax.portlet.name=com_liferay_journal_web_portlet_JournalPortlet",
            "service.ranking:Integer=100"
        },
        service = EditorConfigContributor.class
)
public class PoCCKEditorConfigContributor extends BaseEditorConfigContributor {

    @Override
    public void populateConfigJSONObject(
            JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
            ThemeDisplay themeDisplay,
            RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

        _CKEditorConfigContributor.populateConfigJSONObject(
                jsonObject, inputEditorTaglibAttributes, themeDisplay,
                requestBackedPortletURLFactory);

        String removePlugins = jsonObject.getString("removePlugins");

        if (Validator.isNotNull(removePlugins)) {
            removePlugins += ",htmldataprocessor";
        }
        else {
            removePlugins = "htmldataprocessor";
        }

        jsonObject.put("removePlugins", removePlugins);

        jsonObject.put("allowedContent", true);
        jsonObject.put("autoParagraph", false);

        _log.info("CKeditor config:\n" + jsonObject.toString());
    }

    @Reference(
            target = "(&(component.name=com.liferay.frontend.editor.ckeditor.web.internal.editor.configuration.CKEditorConfigContributor))",
            unbind = "-"
    )
    public void setTemplateManager(EditorConfigContributor CKEditorConfigContributor) {
        _CKEditorConfigContributor = CKEditorConfigContributor;
    }

    private EditorConfigContributor _CKEditorConfigContributor;

    private static final Log _log = LogFactoryUtil.getLog(PoCCKEditorConfigContributor.class);

}
