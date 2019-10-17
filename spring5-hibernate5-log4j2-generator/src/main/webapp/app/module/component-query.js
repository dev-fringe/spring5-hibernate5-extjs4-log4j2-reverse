Ext.onReady(function () {

    Ext.create('Ext.container.Container', {
        id:'myContainer',
        renderTo: Ext.getBody(),
        padding: '5 5 5 5',
        layout: { type: 'vbox' },
        items: [
            {
                xtype: 'textfield',
                fieldLabel:'First Name'
            },
            {
                xtype: 'textfield',
                fieldLabel: 'Last Name'
            },
            {
                xtype: 'panel',
                layout:'vbox',
                items: [
                    {
                        xtype: 'datefield',
                        fieldLabel: 'Date of Birth'
                    },
                    {
                        xtype: 'container',
                        items: [
                            {
                                xtype: 'textfield',
                                fieldLabel: 'email',
                                itemId:'email'
                            }
                        ]
                    }
                ]
            }
                    
        ]

    });
            
    var dateFields = Ext.ComponentQuery.query('container datefield');
    console.log('DateField in Containers: ');
    console.log(dateFields);

    var dateFieldsInPanels = Ext.ComponentQuery.query('panel > datefield');
    console.log('Child DateField in Panel: ' );
    console.log(dateFieldsInPanels);

    var emailInMyContainer = Ext.ComponentQuery.query('#myContainer > #email');
    console.log('#email inside #myContainer');
    console.log(emailInMyContainer);
});