Ext.application({
    name: 'Fiddle',

    launch: function () {
        var states = Ext.create('Ext.data.Store', {
            fields: ['abbr', 'name'],
            data: [{
                    "abbr": "A",
                    "name": "AAAA"
                }, {
                    "abbr": "B",
                    "name": "BBBB"
                }, {
                    "abbr": "C",
                    "name": "CCCC"
                }
            ]
        });
        Ext.create('Ext.form.ComboBox', {
            fieldLabel: 'Choose State',
            store: states,
            multiSelect: true,
            queryMode: 'local',
            displayField: 'name',
            valueField: 'abbr',
            listeners: {
                change: function(combo, newValue, oldValue){
                    this.setValue(newValue.sort());
                    //console.log(this.getValue())
                    //console.log(this.getRawValue())
                }
            },
            renderTo: Ext.getBody()
        });
    }
});
