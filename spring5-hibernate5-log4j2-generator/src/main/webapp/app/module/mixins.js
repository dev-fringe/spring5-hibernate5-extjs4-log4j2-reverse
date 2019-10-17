Ext.define('Person', {
    name: 'Unknown',

    constructor: function(name) {
        if (name) {
            this.name = name;
        }
    },

    getName: function() {
        alert("My name is " + this.name);
    },

    eat: function(foodType) {
        alert("I'm eating " + foodType);
    }

});

Ext.define('Student', {
    schoolName: '',

    constructor: function(schoolName) {
        this.schoolName = schoolName || 'Unknown'
    },

    mixins: {
        eat: 'Person'
    },

    getSchoolName: function() {
        alert("I am a student of " + this.schoolName);
    }

});

var studentObj = new Ext.create('Student', 'XYZ');
studentObj.eat('Sandwich');
