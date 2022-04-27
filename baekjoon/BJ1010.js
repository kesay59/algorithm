function solution(input) {
    const num = Number(input[0]);
    for(let i = 1; i <= num; i++) {
        let arr = input[i].split(" ");
        let a = 1;
        for(let k = 1; k <= arr[1]; k++) {
            a *= k;
        }
        let b = 1;
        for(let k = 1; k <= arr[1]-arr[0]; k++) {
            b *= k;
        }
        for(let k = 1; k <= arr[0]; k++) {
            b *= k;
        }
        console.log(Math.round(a/b));
    }
}

var readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
const input = [];
rl.on("line", function(line){
    input.push(line);
}).on("close", function(){
    solution(input);
    process.exit();
})
