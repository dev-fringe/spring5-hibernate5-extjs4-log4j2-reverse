Ext.define('app.controller.Https', {
	extend : 'Ext.app.Controller',
	views : [ 'http.List', ],
	stores : [ 'Https' ],
	models : [ 'Http' ],
	init : function() {
		this.control({
			'httplist' : {},
            'httplist > toolbar > button[action=search]': {
                click: this.onSearchHttp
            }
		});
	},
	onSearchHttp: function(button){
	    var data = Ext.ComponentQuery.query('#searchId');
		console.log(data[0].value);
        store = this.getHttpsStore();
		store.clearFilter();
        store.load({actionMethods :{read:'POST'},"id":data[0].value});
    },
});