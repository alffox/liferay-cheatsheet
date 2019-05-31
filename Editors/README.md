# CK-Alloy-Config-allow-HTML5

This folder contains configuration to override AlloyEditor and CKEditor used in Liferay 7.0+ versions.

Related documentation:

- https://dev.liferay.com/en/develop/tutorials/-/knowledge_base/7-0/modifying-an-editors-configuration
- https://ckeditor.com/docs/ckeditor4/latest/guide/dev_allowed_content_rules.html

## Allow <h1> inside <a> tags

See commit 

Resources:

- https://ckeditor.com/old/forums/Support/CKEditor-wont-allow-inside
- https://ckeditor.com/old/forums/Support/What-is-the-syntax-to-allow-all-content-html-a-h1-p-in-the-config.js-page.


**Note**: CKEditor and Alloy Editor are provided as WYSIWYG Content Editors and are not intended to be HTML Editors. These editors' Source Modes are provided for convenience and are only intended for minor markup adjustments. Any markup entered into Source Mode is not guaranteed to remain unmodified nor intact.