Ext.define('app.controller.Tests', {
    extend: 'Ext.app.Controller',
    views: [
        'test.Form',
    ],
    init: function () {
        this.control({
            'testform': {
            },
        });
    }
});