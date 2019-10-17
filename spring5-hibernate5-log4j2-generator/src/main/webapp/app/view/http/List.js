Ext.define('app.view.http.List', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.httplist',
    title: 'All Https',
    store: 'Https',
    initComponent: function () {
    	id:'myContainer',
        this.tbar = [{
        	xtype : 'textfield',
        	id : 'searchId'
        },{
            text: 'Search', action: 'search'
        }];
		this.bbar = {
		    xtype: 'pagingtoolbar',
		    pageSize: 10,
		    displayInfo: true,
		    store: this.store,
		};
        this.columns = [
            { header: 'Id', dataIndex: 'id', width: 50 },
            { header: 'BODY', dataIndex: 'body', flex: 1 },
            { header: 'URI', dataIndex: 'uri', flex: 1 }
        ];
        this.addEvents('removeitem');
        this.actions = {
            removeitem: Ext.create('Ext.Action', {
                text: 'Remove User',
                handler: function () { this.fireEvent('removeitem', this.getSelected()) },
                scope: this
            })
        };
        var contextMenu = Ext.create('Ext.menu.Menu', {
            items: [
                this.actions.removeitem
            ]
        });
        this.on({
            itemcontextmenu: function (view, rec, node, index, e) {
                e.stopEvent();
                contextMenu.showAt(e.getXY());
                return false;
            }
        });
        this.callParent(arguments);
    },
    getSelected: function () {
        var sm = this.getSelectionModel();
        var rs = sm.getSelection();
        if (rs.length) {
            return rs[0];
        }
        return null;
    }
});