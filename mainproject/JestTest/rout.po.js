const axios = require('axios');

const functions = {
add:(num1,num2) => num1 + num2,
isNull:() => null,
checkVale: x =>  x,
createuser:() => {
    const user = { firstname :'subha'}
    user['lastname'] ='suki';
    return user;
},

fetchUser:() => axios.get('https://www.w3schools.com/js/tryit.asp?filename=tryjson_parse')
.then(res => res.data)
.catch(err => 'error')
};


module.exports = functions;