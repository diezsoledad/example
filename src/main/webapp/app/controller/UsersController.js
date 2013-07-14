Ext.define('Example.controller.UsersController', {
	extend: 'Ext.app.Controller',
 	requires:[
		'Example.view.user.Add',
		'Example.view.user.Edit',
		'Example.view.user.List'
	],
	
    views: [
        'Apptoolbar',
        'user.List',
        'user.Edit'
    ],
    stores: ['UsersStore'],
    models: ['User'],
 
    init: function() {
        this.control({
            'userlist': {
                itemdblclick: this.editUser
            },
			'useredit button[action=saveUser]': {
                click: this.saveUser
            },
			'useredit button[action=deleteUser]': {
                click: this.deleteUser
            },
			'apptoolbar button[action=addUser]': {
				click: this.addUser
			},
			'apptoolbar button[action=syncUser]': {
				click: this.syncUser
			},
			'useradd button[action=saveUser]': {
				click: this.saveNewUser
			}
        });
    },
    
	syncUser: function() {
		this.getUsersStoreStore().sync();
    },
    
    editUser: function(grid, record) {
        var view = Ext.widget('useredit');
 
        view.down('form').loadRecord(record);
    },
    
	saveUser: function(button) {
		var win    = button.up('window'),                                                             
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();  
			
		record.set(values);

		win.close();
		this.getUsersStoreStore().sync();
    },
    
	saveNewUser: function(button) {
		var win    = button.up('window'),                                                             
            form   = win.down('form'),
            values = form.getValues(),
			record = Ext.create('Example.model.User');
			
        record.set(values);
        this.getUsersStoreStore().add(record);

		win.close();
		this.getUsersStoreStore().sync();
    },
    
	deleteUser: function(button) {
		var win    = button.up('window'),                                                             
            form   = win.down('form'),
            record = form.getRecord();
			
        this.getUsersStoreStore().remove(record);

		win.close();
		this.getUsersStoreStore().sync();
    },
    
	addUser: function(button) {
        var view = Ext.widget('useradd');
    }
});