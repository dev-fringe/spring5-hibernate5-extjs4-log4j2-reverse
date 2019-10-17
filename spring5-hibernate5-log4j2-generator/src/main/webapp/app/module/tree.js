Ext.application({
	name : 'App',
	launch : function() {
		var MyTreeStore = Ext.create('Ext.data.TreeStore', {
			storeId : 'myTreeStoreDS',
			root : {
				text : 'My Application',
				expanded : true,
				children : [ {
					text : 'app',
					children : [ {
						leaf : true,
						text : 'Application.js'
					} ]
				}, {
					text : 'controller',
					expanded : true,
					children : []
				}, {
					text : 'model',
					expanded : true,
					children : [ {
						leaf : true,
						text : 'clients.js'
					}, {
						leaf : true,
						text : 'providers.js'
					}, {
						leaf : true,
						text : 'users.js'
					} ]
				}, {
					text : 'store',
					children : [ {
						leaf : true,
						text : 'clients.js'
					}, {
						leaf : true,
						text : 'providers.js'
					}, {
						leaf : true,
						text : 'users.js'
					} ]
				}, {
					text : 'view',
					children : [ {
						leaf : true,
						text : 'BasicTreePanel.js'
					}, {
						leaf : true,
						text : 'TreeStorePanel.js'
					} ]
				}, {
					text : 'resources',
					children : [ {
						text : 'images'
					}, {
						text : 'css',
						children : [ {
							leaf : true,
							text : 'main.css'
						}, {
							leaf : true,
							text : 'clients.css'
						} ]
					} ]
				} ]
			}
		});
		var MyTreePanel = Ext.create('Ext.tree.Panel',{
			title: 'My tree panel',
			width: 250,
			height: 350,
			frame: true,
			store: MyTreeStore,
			renderTo: document.body
		});
	}
});
