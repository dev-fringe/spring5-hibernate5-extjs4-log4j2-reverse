Ext.define('Person', {
	name : 'Unknown',

	constructor : function(name) {
		if (name) {
			this.name = name;
		}
	},

	getName : function() {
		alert("My name is " + this.name);
	}
});

Ext.define('Student', {
	extend : 'Person',
	schoolName : 'Unknown',

	constructor : function(name, schoolName) {
		this.schoolName = schoolName || 'Unknown';

		// call parent class constructor
		this.callParent(arguments);
	},

	getSchoolName : function() {
		alert("My school name is " + this.schoolName);
	}
});

var newStudent = new Student('XYZ', 'ABC School');
newStudent.getName(); // output: XYZ
newStudent.getSchoolName(); // output: ABC School
