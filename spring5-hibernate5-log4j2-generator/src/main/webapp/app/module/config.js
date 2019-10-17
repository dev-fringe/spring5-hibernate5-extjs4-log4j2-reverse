Ext.define('Student', {
    config : 
    {
        name : 'unnamed',
        schoolName : 'Unknown'
    },
    constructor : function(config){
        this.initConfig(config);
    }
});

var newStudent = Ext.create('Student', { name: 'XYZ', schoolName: 'ABC School' });

newStudent.getName();//output: XYZ
newStudent.getSchoolName();//output: ABC School
console.log(newStudent);
console.log(newStudent.getName());
console.log(newStudent.getSchoolName());

newStudent.setName('John');
newStudent.setSchoolName('New School');

newStudent.getName();//output: John
newStudent.getSchoolName();//output: New School
console.log(newStudent.getName());
console.log(newStudent.getSchoolName());


Ext.define('Student',{
    config : 
    {
        name : 'unnamed',
        schoolName : 'Unknown'
    },

    constructor : function(config){
        this.initConfig(config);
    },
    
    applyName : function(name){
        return Ext.String.capitalize(name);
    },
   
    updateName : function(newValue, oldValue){
        alert('New value: ' + newValue + ', Old value: ' + oldValue);
    }
});

var newStudent = Ext.create('Student', {name : 'xyz', schoolName : 'ABC School'});
newStudent.setName('john');
console.log(newStudent.getName());