Ext.define('Example.model.User', {
    extend: 'Ext.data.Model',
    alias : 'widget.usermodel',
    
	fields: [
	  {name: 'id', type: 'auto'},
	  {name: 'name', type: 'string'},
	  {name: 'email', type: 'string'},
	  {name: 'address', type: 'string'},
	  {name: 'nationality', type: 'string'},
	  {name: 'age', type: 'int'}
	]
});