Ext.Loader.setConfig({enabled:true});

Ext.application({
    name: 'Example',
    appFolder: 'app',
    controllers: [
        'UsersController'
    ],
	requires:[
		'Example.view.Apptoolbar'
	],
 
	launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout:'border',
			defaults: {
				collapsible: true,
				split: true,
				bodyStyle: 'padding:15px'
			},
            items: [
			{
				xtype: 'apptoolbar',
				region: 'north'
			},			
			{
                xtype: 'userlist',	
				region: 'center',
				bodyStyle: 'padding:1px'
            },
			{
				xtype: 'panel',
				title: 'Example',
				html : '<div>This is just a partial CRUD example.</div><div>Developed using ExtJS, Spring, MyBatis and MySQL.</div><div>Tested under jUnit and EasyMock.</div>',
				region:'west',
				width: 175,
				minSize: 100,
				maxSize: 250
			}
			]
        });
    }
});