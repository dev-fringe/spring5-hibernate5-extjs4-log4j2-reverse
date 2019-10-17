Ext.define('app.view.Viewport', {
	extend : 'Ext.container.Viewport',
	layout : 'border',
	items : [ {
		xtype: 'panel',
		region: 'north',
		height: 76,
		itemId: 'appHeader',
		bodyPadding: 0,
		cls: 'appheaderbg',
		title: '',
		header: false
		//html: '<div class="appheader appheaderbg"><img src="resources/images/myapp_logo.png"/></div>',
	}, {
		xtype : 'panel',
		region : 'west',
		split : true,
		width : 180,
		layout : 'fit',
		title : 'menu',
		items : [ {
			xtype : 'treepanel',
			itemId: 'accessPanel',
			rootVisible: false,
			listeners : {
				itemclick: function(treeModel, record, item, index, e, eOpts){
					if(record.isLeaf()){
						var zone = Ext.ComponentQuery.query("#myappzone")[0];
						var existModule= false;
						for (var i = 0 ; i < zone.items.items.length ; i++){
							if (zone.items.items[i].xtype==record.data.id){
								existModule= true;
								break;
							}
						}
						if(existModule){
							zone.setActiveTab(i);
							return ;
						}else{
							var mynewModule = Ext.widget(record.data.id);
							mynewModule.title = record.data.text;
							mynewModule.closable = true;
							zone.add(mynewModule);
							zone.setActiveTab((zone.items.items.length -1));
							return ;
						}
					}
				}
			},				
			store : {
				root : {
					text : 'My Application',
					expanded : false,
					children : [ {
						text : 'app',
						children : [ {
							leaf : true,
							text : 'Users',
							id : 'userlist'
						} ]
					}, {
						text : 'controller',
						expanded : false,
						children : [{
							leaf : true,
							text : 'Http',
							id : 'httplist'
						}]
					}, {
						text : 'testform',
						expanded : true,
						children : [ {
							leaf : true,
							text : 'Form',
							id : 'testform'
						} ]
					} ]
				}
			}
		} ]
	}, {
		region : 'center',
		xtype : 'tabpanel',
		activeTab : 0,
		itemId: 'myappzone',
		items : {
			title : 'Info'
			//,xtype : 'userlist'
		}
	} ]
});