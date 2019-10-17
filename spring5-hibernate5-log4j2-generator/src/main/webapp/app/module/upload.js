Ext.application({
	name : 'Fiddle',
	launch : function() {
		Ext.create('Ext.form.Panel', {
			title : 'Upload a Photo',
			width : 400,
			bodyPadding : 10,
			frame : true,
			renderTo : Ext.getBody(),
			items : [ {
				xtype : 'filefield',
				name : 'file',
				fieldLabel : 'Photo',
				labelWidth : 50,
				msgTarget : 'side',
				allowBlank : false,
				anchor : '100%',
				buttonText : 'Select Photo...'
			},{
				xtype :'hiddenfield',
				name : 'folder',
				value : 'test'
				
			} ],

			buttons : [ {
				text : 'Upload',
				handler : function() {
					var form = this.up('form').getForm();
					if (form.isValid()) {
						form.submit({
							url : 'upload',
							waitMsg : 'Uploading your photo...',
							success : function(fp, o) {
								Ext.Msg.alert('Success', 'Your photo "'+ o.result.resultFile + '" has been uploaded.');
							}
						});
					}
				}
			} ]
		});
	}
});
