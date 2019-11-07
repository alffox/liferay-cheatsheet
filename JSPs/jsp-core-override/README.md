# JSP-core override for 7.1 using Custom JSP Bag

This folder illustrates how to override a core jsp file: https://github.com/liferay/liferay-portal/blob/master/portal-web/docroot/html/taglib/ui/quick_access/page.jsp

Into specific, this line:

```
<h1 class="hide-accessible"><liferay-ui:message key="navigation" /></h1>
```

is replaced with:

```
<span class="hide-accessible"><liferay-ui:message key="navigation" /></span>
```

The change might be at times desirable for SEO purposes: if not done, Liferay pages will show `<h1>` tag multiple times.

**Important:**

- Overriding core jsps is deprecated as of 7.1: please see the Liferay docs: https://portal.liferay.dev/docs/7-1/tutorials/-/knowledge_base/t/jsp-overrides-using-custom-jsp-bag
- Overriding the `hide-accessible` `h1` tag may have unwanted effects on Liferay accessibility: https://liferay.dev/blogs/-/blogs/new-feature-for-liferay-7-quick-access
- Liferay will change the current `h1` markup in future versions: https://issues.liferay.com/browse/LPS-97102

## How to build

From the root folder of the project, run `gradle build`
