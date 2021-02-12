

/**
***************************************************
var a = null;
console.log(typeof a);
a = true;
console.log(typeof a);
var a = 1.1;
console.log(typeof a);
a = "hello";
console.log(typeof a);

var b = 10;
var c = "10";
if (b == c) {
	console.log("b and c are equal;");
}

if (b === c) {
	console.log("b and c are equal;");
}
else {
	console.log("b and c are unequal;");
}

// a = undefined,   null,   O,   0/0; it is = false;
// all other cases; it is true;

if (a) {
	console.log("a is true;");
}
if (0) {
	console.log("a is true;");
}
if (null) {
	console.log("a is true;");
}
if (0/0) {
	console.log("a is true;");
}

******************************************************
var myObj = {};
console.log(myObj);
console.log(typeof myObj);

myObj.prop = "hello";
console.log(myObj);
console.log(typeof myObj);

myObj.name = "hello - name";
console.log("This is my obj: " + myObj.name);
console.log("This is my obj: " + myObj["name"]);
console.log("This is my obj: " + myObj[1]);
console.log(typeof myObj);

*********************************************************
var newObj = {
		"name" : "Hello",
		"addr" : 12,
		"true" : true,
		"1"	   : "one"
	};
console.log(newObj);
console.log(newObj["1"]);
console.log(newObj.check);
***************************************************

var newObj = {
		"name" : "Hello",
		"addr" : 12
	};

var property = "name";
console.log(newObj[property]);
*************************************

var newObj = {
		"name" : "Hello",
		"addr" : 12,
		"cell" : 12212
	};
console.log(newObj);
delete newObj.cell;
console.log(newObj);
**************************************

var myArray = [1,2,3,4,5];

console.log(myArray);
console.log(myArray[5]);
console.log(myArray[-1]);
console.log(typeof myArray);

myArray[5] = 6;
console.log(myArray);


myArray[100] = 6;
console.log(myArray.length);
console.log(myArray);

**********************************************************
function sayHello(name, timeOfDay, addr) {
	console.log("Hello " + name 
			+ "Time of day is " + timeOfDay, "Address: " + addr);
	
};

sayHello("Test", "afternoon", "12w");

// below function will completely replace the above function.
function sayHello(name, timeOfDay){
	console.log("Hello " + name 
			+ "Time of day is " + timeOfDay);
	
};

sayHello("Test", "afternoon", "12w");
sayHello("Test", "afternoon");
sayHello("Test");
sayHello();

******************************************************************

function sayHello(name, timeOfDay) {
	return console.log("Hello " + name 
			+ " Time of day is " + timeOfDay);
	
};

var returValue = sayHello("Test", "afternoon");
console.log(returValue);

***************************************************

var a = "hello";
var f = function foo(a) {
	console.log("hello " + a);
}

f("you");

********************************************

var f = function(name) {
	console.log("hello " + name);
};

var executor = function(fn, name) {
	fn(name);
};

executor(f, "Mac");

********************************************

var myObj = {
		"name" : "Pranay",
		"addr" : "1223"
}

myObj.func = function() {
	console.log("hello " + myObj.name);
}

myObj.func();

*********************************************

var person = {
		"firstName" : "Mac",
		"lastName" : "Lan",
		"myMethod" : function() {
			return this.firstName + " "+ this.lastName;
			}
		}

var fullName = person.myMethod();
console.log(fullName);

var person2 = person;

person = {};
console.log(person2.myMethod());

********************************************************

var person = {
		"firstName" : "Mac",
		"lastName" : "Lan",
		"myMethod" : function() {
			return this.firstName + " "+ this.lastName;
			},
		"addr" : {
			"city" : "JS",
			"state": "CA"
			},
			"inCity" : function (city) {
				return(this.addr.city === city);
		  }
		}

console.log(person.inCity("CA"));

var fullName = person.myMethod();
console.log(fullName);

var person2 = person;

person = {};
console.log(person2.myMethod());

*********************************************************

var add = function(a,b,c) {
	console.log(arguments);
	return ("result is: " + a+b+c);
};

console.log(add(1,2,3,4,5));

*************************************************


var add = function(a,b,c) {
	console.log(arguments);
	var i, sum = 0;
	for(i=0; i<arguments.length; i++) {
		sum = sum+arguments[i];
	}
	return ("result is: " + sum);
};

console.log(add(1,2,3,4,5));

**********************************************


var myArray = [1,2,3,4,"test", {}];
console.log(myArray);

myArray.push("Done");
console.log(myArray);

myArray.pop("1");
console.log(myArray);

myArray.unshift("abcd");
console.log(myArray);

******************************************

var myArray = [10 ,20, 33, 89, "test", {}];
console.log(myArray);

var myFunction = function(item, index) {
	console.log("For each element: " + item, index);
};

myArray.forEach(myFunction, 1, 2);

console.log(myArray);

*
*/