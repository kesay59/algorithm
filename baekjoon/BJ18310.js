function solution(input) {
    const num = Number(input[0]);
    const house = input[1].split(' ');
    for(let i = 0; i < num; i++) {
        house[i] = Number(house[i]);
    }
    house.sort((a, b) => {
        return a-b;
    });
    console.log(house[Math.floor((num-1)/2)]);
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
