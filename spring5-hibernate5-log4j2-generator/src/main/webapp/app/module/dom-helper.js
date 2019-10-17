Ext.onReady(function() {
	var dh = Ext.DomHelper; // ExtJS DomHelper Utility Class
	var listItems = {
		id : 'dhlist',
		tag : 'ul',
		children : [{
			tag : 'li',
			html : 'item 1'
		},{
			tag : 'li',
			html : 'item 2'
		},{
			tag : 'li',
			html : 'item 3'
		}]
	}
	dh.append("div1", listItems);
});