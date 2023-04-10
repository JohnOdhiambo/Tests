//Compute sum of all numbers in an array divisible by 4
function sol(A){
    let sum = 0;
    for(let i= 0; i <A.length; i++){
        if(A[i] % 4 === 0){
            sum += A[i]
        }
    }
    return sum;
}

const list = [0, 2, 4, 7, 8, 15];
const result = sol(list);
console.log(result);