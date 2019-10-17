Ext.application({
	name : 'App',
	launch : function() {
		new Ext.Toolbar({
			renderTo : document.body,
			items : [ {
				text : 'Login',
				handler : function(btn) {
					console.log(btn.text);
				}
			}]
		});
	}
});
