        Ext.onReady(function () {

            var comp1 = Ext.create('Ext.Component', {
                html: 'Component 1',
                padding:'5 5 5 5'
            });

            var comp2 = Ext.create('Ext.Component', {
                html: 'Component 2',
                padding: '5 5 5 5'
            });
            var comp3 = Ext.create('Ext.Component', {
                html: 'Component 3',
                padding: '5 5 5 5'
            });
            var comp4 = Ext.create('Ext.Component', {
                html: 'Component 4',
                padding: '5 5 5 5'
            });

            var container = Ext.create('Ext.container.Container', {
                layout: { type: 'vbox' },
                items: [comp3, comp4]
            });

            Ext.create('Ext.container.Container', {
                style: { borderColor: 'Red', borderStyle: 'solid', borderWidth: '1px' },
                renderTo: Ext.getBody(),
                padding: '5 5 5 5',
                layout: { type: 'hbox' },
                items: [comp1, comp2, container]

            });
           
        });