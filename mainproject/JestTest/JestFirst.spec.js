const functions = require('../JestTest/rout.po');

// toBe
test('Adds 2 + 2 to equal 4' , () => {
    expect(functions.add(2, 2)).toBe(4);
});

// NoT toBe
test('Adds 2 + 2 to NOT equal 5',() => {
    expect(functions.add(2,2)).not.toBe(5);
});

// toBeNull
test('Should be null',() =>{
    expect(functions.isNull()).toBeNull();
});

// toBeFalsy
test('should be falsy',() =>{
    expect(functions.checkVale(null)).toBeFalsy(); // 0 , undefined
});

// toEqual
test('User should be subha suki object',() =>{
    expect(functions.createuser()).toEqual({
    firstname:'subha', 
    lastname:'suki'
    });
});

// Less than and greater than
test('Should be under 1600',() =>{
    const loan1=800;
    const loan2=800;
    expect(loan1 + loan2).toBeLessThanOrEqual(1600);
});

// Regex & toMatch
test('There is no I in team',() =>{
    expect('suki').not.toMatch(/I/);
});

// Array & toContain
test('Admin sould be in Username',() =>{
    adminuser = ['subha','velu','raja','admin'];
    expect(adminuser).toContain('admin');
});

// Working with async data
//Promise
test('User fetch name should be John',() =>{
    expect.assertions(1);
    return functions.fetchUser().then(data => {
        expect(data.name).toEqual('John');
    });
});

//Async await
test('User fetched name should be John',() =>{
    expect.assertions(1);
    const data = await functions.fetchUser();
    expect(data.name).toEqual('John');
});