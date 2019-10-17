Ext.define('app.store.Https', {
    extend: 'Ext.data.Store',
    model: 'app.model.Http',
//    autoLoad: true,
    autoSync: true,
    pageSize:100,
    proxy: {
        type: 'ajax',
        limitParam: 'size',
        startParam: undefined,
        api: {
            read: 'http',
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