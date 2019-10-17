Ext.application({
	name : 'App',
	launch : function() {
//		Ext.define('app.view.form.LoginForm', {
			Ext.create('Ext.form.FormPanel', {			
			extend : 'Ext.form.Panel',
			xtype : 'login-form',
			title : 'Login',

		    renderTo: 'login',
			frame : true,
			width : 320,
			bodyPadding : 10,
			defaultType : 'textfield',
			defaults : {
				anchor : '100%'
			},
            style: { marginLeft : 'auto', marginRight : 'auto', height: '100px'},
			items : [ {
				allowBlank : false,
				fieldLabel : 'User ID',
				name : 'user',
				emptyText : 'user id'
			}, {
				allowBlank : false,
				fieldLabel : 'Password',
				name : 'pass',
				emptyText : 'password',
				inputType : 'password'
			}, {
				xtype : 'checkbox',
				fieldLabel : 'Remember me',
				name : 'remember'
			} ],

			buttons : [ {
				text : 'Register',
				onClick : function(){
				}
			}, {
				text : 'Login',
				handler: function(button) {
					var form = button.up('form').getForm();
			        Ext.Ajax.request({
			            url: 'contact/login',
			            method: 'POST',
			            params : Ext.JSON.encode(form.getValues()),   
			            headers: { 'Content-Type': 'application/json' },
			            success: function(conn, response, options, eOpts) {
//			                var result = Packt.util.Util.decodeJSON(conn.responseText);
//			                if (result.success) {
//			                    Packt.util.Alert.msg('Success!', 'Stock was saved.');
//			                    store.load();
//			                    win.close();                      
//			                } else {
//			                    Packt.util.Util.showErrorMsg(result.msg);
			            	  var redirect = 'combo'; //here need to redirect to another url on the controller side 
	                          window.location = redirect;
//			                }
			            },
			            failure: function(conn, response, options, eOpts) {
//			                Packt.util.Util.showErrorMsg(conn.responseText);
			            }
			        });
				}				
			} ]
		});
	}
});
