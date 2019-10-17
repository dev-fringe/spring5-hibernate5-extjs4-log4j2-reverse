Ext.define('app.store.Users', {
    extend: 'Ext.data.Store',
    model: 'app.model.User',
//    autoLoad: true,
    autoSync: true,
    pageSize:100,
    constructor: function(){
        this.callParent(arguments);
        this.model.prototype.idProperty = 'email';
    },    
    proxy: {
        type: 'ajax',
        limitParam: 'size',
        startParam: undefined,
        api: {
            create: 'user/create',
            read: 'user',
            update: 'user/update',
            destroy: 'user/delete'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: false
        }
    }
});