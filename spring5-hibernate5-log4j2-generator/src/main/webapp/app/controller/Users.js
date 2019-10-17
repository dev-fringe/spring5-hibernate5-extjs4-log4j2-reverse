Ext.define('app.controller.Users', {
    extend: 'Ext.app.Controller',
    stores: [
        'Users'
    ],
    models: [
        'User'
    ],
    views: [
        'user.List',
        'user.Add',
        'user.Edit'
    ],
    init: function () {
        this.control({
            'userlist': {
                itemdblclick: this.editUser,
                removeitem: this.removeUser
            },
            'userlist > toolbar > button[action=create]': {
                click: this.onCreateUser
            },
            'userlist > toolbar > button[action=search]': {
                click: this.onSearchUser
            },
            'useradd button[action=save]': {
                click: this.doCreateUser
            },
            'useredit button[action=save]': {
                click: this.updateUser
            }
            
        });
    },
    editUser: function (grid, record) {
        var view = Ext.widget('useredit');
        view.down('form').loadRecord(record);
    },
    removeUser: function (user) {
        Ext.Msg.confirm('Remove User', 'Are you sure?', function (button) {
            if (button == 'yes') {
                this.getUsersStore().remove(user);
            }
        }, this);
    },
    onCreateUser: function () {
        var view = Ext.widget('useradd');
    },
    doCreateUser: function (button) {
        var win = button.up('window'),
            form = win.down('form'),
            values = form.getValues(),
            store = this.getUsersStore();
        if (form.getForm().isValid()) {
            store.add(values);
            win.close();
        }
    },
    onSearchUser: function(button){
	    var emailInMyContainer = Ext.ComponentQuery.query('#KeyWord');
		console.log(emailInMyContainer[0].value);
        store = this.getUsersStore();
//        store.load();
		  //var grid = Ext.getCmp('userlist');
		    store.clearFilter();
            store.load({actionMethods :{read:'POST'},"email":emailInMyContainer[0].value});
//                {name: emailInMyContainer[0].value}
//            ]); 
    },
    updateUser: function (button) {
        var win = button.up('window'),
            form = win.down('form'),
            record = form.getRecord(),
            values = form.getValues(),
            store = this.getUsersStore();
        if (form.getForm().isValid()) {
            record.set(values);
            win.close();
        }
    }
});