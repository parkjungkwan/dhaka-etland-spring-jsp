function People(name,age,gender,job){
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.job = job;
}

People.prototype.setName =name=>{this.name = name;};
People.prototype.setAge =age=>{this.age = age;};
People.prototype.setGender =gender=>{this.gender = gender;};
People.prototype.setJob =job=>{this.job = job;};
People.prototype.getName =()=>{return this.name;};
People.prototype.getAge =()=>{return this.age;};
People.prototype.getGender =()=>{return this.gender;};
People.prototype.getJob =()=>{return this.job;};
	

function Customer(grade,custNo){
    People.apply(this,arguments);
    this.grade = grade;
    this.custNo = custNo;
}
Customer.prototype = new People();

People.prototype.setGrade =grade=>{this.grade = grade;};
People.prototype.setCustNo =custNo=>{this.custNo = custNo;};
People.prototype.getGrade =()=>{return this.grade;};
People.prototype.getCustNo =()=>{return this.custNo;};

var test = (()=>{
    
    let main = ()=>{
        let cust = new Customer();
        cust.setName('홍길동');
        cust.setAge('25세');
        cust.setGender('남');
        cust.setJob('개발자');
        cust.setGrade('3급');
        cust.setCustNo('123');
        alert('[고객정보] \n '+cust.getName()+'\n'
        		+cust.getAge()+'\n'
        		+cust.getGender()+'\n'
        		+cust.getJob()+'\n'
        		+cust.getGrade()+'\n'
        		+cust.getCustNo())
        /*alert('고객정보 : 홍길동,25세,남,개발자,3급,123')*/
    }
        return {main:main};
})();



function Person(){
	let _name,_age,_gender,_job;
	return {
		setName:(name)=>{this._name = name;},
		setAge : (age)=>{this._age = age;},
		setGender : (gender)=>{this._gender = gender;},
		setJob : (job)=>{this._job = job;},
		getName : ()=>{return this._name;},
		getAge : ()=>{return this._age;},
		getGender : ()=>{return this._gender;},
		getJob : ()=>{return this._job;},
		toString : ()=>{
		return this._name + ','+this._age + ','
			+this._gender + ','+this._job
		}
	}
}
var encap = (()=>{
	var main =()=>{
		let person = new Person();
		person.setName('도널드 트럼프');
		person.setAge('73');
		person.setGender('남');
		person.setJob('미국 대통령');
		alert('스펙: '+person.toString());
	}
	return {main:main};
})();








