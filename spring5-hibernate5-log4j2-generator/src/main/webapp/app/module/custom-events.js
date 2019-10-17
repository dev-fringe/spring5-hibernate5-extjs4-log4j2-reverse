Ext.define('Student', {
    config : {
        name : ''
    },
    mixins : 
    {
        observable : 'Ext.util.Observable'
    },
    constructor : function(config){
        this.mixins.observable.constructor.call(this, config);
    },
    updateName : function(newValue, oldValue){
        this.fireEvent('studentNameChanged', newValue);
    }
});

var newStudent = Ext.create('Student', { name: 'xyz' });

newStudent.on('studentNameChanged', function(name){
    alert('student Name ' + name + 'has been Chaged.');
});

newStudent.setName('John');