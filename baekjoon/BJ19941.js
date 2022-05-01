function solution(input) {
    let k = Number(input[0].split(" ")[1]);
    let arr = input[1];
    let hamburger = findHamburger(arr, 0);
    if(hamburger == -1) {
        console.log(0);
        return;
    }
    let cnt = 0;
    for(let person = 0; person < arr.length; person++) {
        if(arr[person] != 'P') continue;
        if(hamburger < person - k) {
            hamburger = findHamburger(arr, person - k);
            if(hamburger == -1) break;
        }
        if(hamburger <= person + k) {
            cnt++;
            hamburger = findHamburger(arr, hamburger+1);
            if(hamburger == -1) break;
        }
    }
    console.log(cnt);
}

function findHamburger(arr, idx) {
    while(idx < arr.length) {
        if(arr[idx] == 'H') return idx;
        idx++;
    }
    return -1;
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
