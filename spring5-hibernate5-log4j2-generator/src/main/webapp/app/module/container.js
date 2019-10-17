Ext.onReady(function () {
    var comp1 = Ext.create('Ext.Component', {
        html:'Component 1'
    });
          
    var comp2 = Ext.create('Ext.Component', {
        html: 'Component 2'
    });

    var comp3 = Ext.create('Ext.Component', {
        html: 'Component 3'
    });

    var comp4 = Ext.create('Ext.Component', {
        html: 'Component 4'
    });

    var container1 = Ext.create('Ext.container.Container', {
        style: { borderColor: 'Red', borderStyle: 'solid', borderWidth: '1px' },
        width: '50%',
        padding: '5 5 5 5',
        items: [comp3, comp4]
    });

    // adding compoents into container using items config
    var container2 = Ext.create('Ext.container.Container', {
        renderTo: Ext.getBody(),
        title: 'Container',
        border: 1,
        width: '50%',
        padding:'5 5 5 5',
        style: { borderColor: '#000000', borderStyle: 'solid', borderWidth: '1px' },
        items: [comp1, comp2]
    });

    // adding container into container 
    container2.add(container1);
});