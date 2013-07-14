Ext.define('Example.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',
	store: 'UsersStore',
    title : 'All Users',
	enableColumnHide:true,
	columnLines: true,
	enableLocking: true,
	columns: [
      { text: 'ID #',  dataIndex: 'id' },
      { text: 'Name', dataIndex: 'name' },
      { text: 'Email', dataIndex: 'email' },
      { text: 'Address', dataIndex: 'address' },
      { text: 'Nationality', dataIndex: 'nationality' },
      { text: 'Age', dataIndex: 'age' }
    ],
    
    dockedItems: [{
      xtype: 'pagingtoolbar',
      store: 'UsersStore',
      dock: 'bottom',
      displayInfo: true
    }],

    initComponent: function() {
        this.callParent(arguments);
    }
});