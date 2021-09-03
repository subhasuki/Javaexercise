const reverseString = require('../JestTest/reversestring.po');

test('ReverseString function exits',() => {
    expect(reverseString).toBeDefined();
});

test('String Reverses with Uppercase',() => {
    expect(reverseString('suki')).toEqual('ikus');
}); 