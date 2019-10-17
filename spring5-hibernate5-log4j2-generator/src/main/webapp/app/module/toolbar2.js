Ext.application({
	name : 'App',
	launch : function() {
		new Ext.Toolbar({
			renderTo : document.body,
			items : [ {
				text : 'Login',
				handler : function(btn) {
					Ext.Msg.alert('Boo', 'Here I am');
					console.log(btn);
				}
			}, {
				text : 'Menu Button',
				menu : [ {
					text : 'Better'
				}, {
					text : 'Good'
				}, {
					text : 'Best'
				} ]
			}, {
				xtype : 'splitbutton',
				text : 'Split Button',
				menu : [ {
					text : 'Item One'
				}, {
					text : 'Item Two'
				}, {
					text : 'Item Three'
				} ]
			}, '->', {
				xtype : 'textfield',
				name : 'field1',
				emptyText : 'enter search term'
			}, '-', 'text 1', {
				xtype : 'tbspacer'
			}, 'text 2', {
				xtype : 'tbspacer',
				width : 50
			}, 'text 3' ]
		});
	}
});
