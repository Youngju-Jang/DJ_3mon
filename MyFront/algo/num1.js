var data=[ 10,88,56, 68,99,88,45,50,58,39 ];

var getMax = function(){
    var max = Number.MIN_SAFE_INTEGER;
    var N = data.length;

    for (var i = 0; i < N; i++) {
        if (data[i] > max) {
            max = data[i];
        }
    }
    console.log("최댓값: " + max);
}

var getMin = function(){
    var min = Number.MAX_SAFE_INTEGER;
    var N = data.length;

    for (let i = 0; i < N; i++) {
        if (data[i] < min) {
            min = data[i];
        }
    }
    console.log("최솟값: " + min);
}

var getAvg = function(){
    var sum = 0;
    var count = 0;
    var N = data.length;

    for (var i = 0; i < N; i++) {
            sum += data[i];
            count++;
    }

    var avg = 0.0;
    if (sum != 0 && count != 0) {
        avg = sum / count;
    }
    return avg.toFixed(2);
}

var getBtAvg = function(){
    var N = data.length;
    var count = 0;
    var avg = getAvg();

    for(var i=0; i < N; i++){
        if(data[i] >= avg){
            count++;
        }
    }
    console.log("평균 이상 값: " + count);
}
getMin(); // 최솟값: 10
getMax(); // 최댓값: 99
console.log("평균값: " +getAvg()); // 평균값: 60.10
getBtAvg(); // 평균 이상 값: 4



