Ext.define('Example.view.user.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.useredit',
 
    title : 'Edit User',
    layout: 'fit',
    autoShow: true,
 
    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                items: [
                    {
                        xtype: 'textfield',
                        name : 'name',
                        fieldLabel: 'Name'
                    },
                    {
                        xtype: 'textfield',
                        name : 'email',
                        fieldLabel: 'Email'
                    },
                    {
                        xtype: 'textfield',
                        name : 'address',
                        fieldLabel: 'Direccion'
                    },
                    {
                        xtype: 'textfield',
                        name : 'nationality',
                        fieldLabel: 'Nacionalidad'
                    },
                    {
                        xtype: 'textfield',
                        name : 'age',
                        fieldLabel: 'Edad'
                    }
                ]
            }
        ];
 
        this.buttons = [
            {
                text: 'Save',
                action: 'saveUser'
            },
			{
                text: 'Delete',
                action: 'deleteUser'
            },
            {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }
        ];
 
        this.callParent(arguments);
    }
});