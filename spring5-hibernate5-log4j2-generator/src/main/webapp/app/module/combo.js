Ext.application({
	name : 'App',
	launch : function() {
		var states = Ext.create('Ext.data.Store', {
		    fields: ['abbr', 'name'],
		    data : [
		        {"abbr":"AL", "name":"Alabama"},
		        {"abbr":"AK", "name":"Alaska"},
		        {"abbr":"AZ", "name":"Arizona"}
		    ]
		});
		Ext.create('Ext.form.ComboBox', {
		    fieldLabel: 'Choose State',
		    store: states,
		    queryMode: 'local',
		    displayField: 'name',
		    valueField: 'abbr',
		    listeners: {
		        change: function (field, newValue, oldValue) {
		            console.log(field + newValue + oldValue);
		        }
		    },
		    renderTo: Ext.getBody()
		});
	}
});
