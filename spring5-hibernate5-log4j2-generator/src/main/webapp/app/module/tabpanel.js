Ext.application({
	name : 'App',
	launch : function() {
		var objPanel = Ext.create('Ext.panel.Panel',{
			title : 'Object Panel',
			itemId : 'objPanel'
		})
		var tabPanel = Ext.create('Ext.tab.Panel',{
			width: 400,
			height: 400,
			items : [{
				title : 'Foo'
			}]
		})
		var parentPanel = Ext.create('Ext.panel.Panel',{
			renderTo: document.body,
			tbar:[
				{
					text: 'Add Panel',
					handler : function(){
						if(tabPanel.down('#objPanel')){
							tabPanel.setActiveTab(tabPanel.down('#objPanel'));
						}else{
							tabPanel.add(objPanel);
						}
					}
				}
			],
			items: [tabPanel]
		})
	}
});
