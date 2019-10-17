Ext.onReady(function () {
    var txtFirst = Ext.get("txtFirstName");
    txtFirst.set({ 'value': 'Steve' });

    Ext.fly('txtLastName').set({ 'value': 'Jobs' });

    console.log(txtFirst.$className);
});