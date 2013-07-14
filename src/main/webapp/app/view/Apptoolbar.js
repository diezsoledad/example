Ext.define('Example.view.Apptoolbar' ,{
    extend: 'Ext.Toolbar',
    alias : 'widget.apptoolbar',
    title : 'Toolbar',
    autoShow: true,

	items: [
		{
			xtype: 'button', 
			text: 'Add User',
            action: 'addUser'
		},
		{
			xtype: 'button', 
			text: 'Sync Users',
            action: 'syncUser'
		}
	]
});