<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/html/taglib/ui/quick_access/init.jsp" %>

<%
String randomNamespace = StringUtil.randomId() + StringPool.UNDERLINE;
%>

<c:if test="<%= ((quickAccessEntries != null) && !quickAccessEntries.isEmpty()) || Validator.isNotNull(contentId) %>">
	<nav class="quick-access-nav" id="<%= randomNamespace + "quickAccessNav" %>">
		<span class="hide-accessible"><liferay-ui:message key="navigation" /></span>

		<ul>
			<c:if test="<%= Validator.isNotNull(contentId) %>">
				<li><a href="<%= contentId %>"><liferay-ui:message key="skip-to-content" /></a></li>
			</c:if>

			<%
			if ((quickAccessEntries != null) && !quickAccessEntries.isEmpty()) {
				for (QuickAccessEntry quickAccessEntry : quickAccessEntries) {
			%>

					<li>
						<a href="<%= quickAccessEntry.getURL() %>" id="<%= randomNamespace + quickAccessEntry.getId() %>"><%= quickAccessEntry.getContent() %></a>
					</li>

			<%
				}
			}
			%>

		</ul>
	</nav>

	<c:if test="<%= (quickAccessEntries != null) && !quickAccessEntries.isEmpty() %>">
		<aui:script sandbox="<%= true %>">
			var callbacks = {};

			<%
			for (QuickAccessEntry quickAccessEntry : quickAccessEntries) {
				String onClick = quickAccessEntry.getOnClick();

				if (Validator.isNotNull(onClick)) {
			%>

					callbacks['<%= randomNamespace + quickAccessEntry.getId() %>'] = function() {
						<%= onClick %>
					};

			<%
				}
			}
			%>

			$('#<%= randomNamespace %>quickAccessNav').on(
				'click',
				'li a',
				function(event) {
					var callbackFn = callbacks[$(event.currentTarget).attr('id')];

					if (_.isFunction(callbackFn)) {
						callbackFn();
					}
				}
			);
		</aui:script>
	</c:if>
</c:if>