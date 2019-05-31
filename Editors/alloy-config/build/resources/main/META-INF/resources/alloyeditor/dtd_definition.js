CKEDITOR.dtd.$removeEmpty = [];
CKEDITOR.dtd.a.div = 1;
CKEDITOR._.events.instanceReady.listeners.push(function( ev ) {
    var rules = {
        indent: true,
        breakBeforeOpen: true,
        breakAfterOpen: true,
        breakBeforeClose: true,
        breakAfterClose: false
    };
    if (this.instances.hasOwnProperty(ev.name)) {
        var writer = this.instances[ev.name].dataProcessor.writer;
        ['address', 'article', 'aside', 'blockquote', 'canvas', 'dd', 'div', 'dl', 'dt', 'fieldset', 'figcaption', 'figure', 'footer', 'form', 'h1', 'h2', 'h3', 'h4', 'h5', 'h6', 'header', 'hr', 'li', 'main', 'nav', 'noscript', 'ol', 'output', 'p', 'pre', 'section', 'table', 'tfoot', 'ul', 'video', 'a', 'svg', 'span', 'label', 'button', 'script', 'form', 'input', 'select', 'textarea'].forEach(function(nodeType) {
            writer.setRules(nodeType, rules);
        });

    }
});