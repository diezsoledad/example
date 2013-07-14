Ext.define('Example.store.UsersStore', {
    extend: 'Ext.data.Store',
    model: 'Example.model.User',
    autoLoad: true,
    pageSize: 10,

    proxy: {
		type: 'rest',
        url: 'users',
        timeout: 1200,
        noCache: false,
 
        reader:
        {
            type: 'json',
            root: 'elements'
        },
 
        writer:
        {
            type: 'json',
            writeAllFields: true
        }
	}
});