Ext.define('app.view.user.List', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.userlist',
    title: 'All Users',
    store: 'Users',
    initComponent: function () {
    	id:'myContainer',
        this.tbar = [{
            text: 'Create User', action: 'create'
        },{
        	xtype : 'textfield',
        	id : 'KeyWord'
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
            { header: 'Email', dataIndex: 'email', flex: 1  },
            { header: 'Firstname', dataIndex: 'firstName', flex: 1 },
            { header: 'Lastname', dataIndex: 'lastName', flex: 1 }
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