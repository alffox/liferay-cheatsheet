package com.liferay.poc.editor.alloy;


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
            "editor.name=alloyeditor",
            "javax.portlet.name=com_liferay_blogs_web_portlet_BlogsPortlet",
            "javax.portlet.name=com_liferay_blogs_web_portlet_BlogsAdminPortlet",
            "javax.portlet.name=com_liferay_journal_web_portlet_JournalPortlet",
            "service.ranking:Integer=100"
        },
        service = EditorConfigContributor.class
)
public class PoCAlloyEditorConfigContributor extends BaseEditorConfigContributor {

    @Override
    public void populateConfigJSONObject(
            JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
            ThemeDisplay themeDisplay,
            RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

        _alloyEditorConfigContributor.populateConfigJSONObject(
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

        _log.info("Alloy editor config:\n" + jsonObject.toString());
    }

    @Reference(
            target = "(&(component.name=com.liferay.frontend.editor.alloyeditor.web.internal.editor.configuration.AlloyEditorConfigContributor))",
            unbind = "-"
    )
    public void setTemplateManager(EditorConfigContributor alloyEditorConfigContributor) {
        _alloyEditorConfigContributor = alloyEditorConfigContributor;
    }

    private EditorConfigContributor _alloyEditorConfigContributor;

    private static final Log _log = LogFactoryUtil.getLog(PoCAlloyEditorConfigContributor.class);

}
