const merge = (arr,low,mid,high) => {
    const leftArr = [];
    const rightArr = [];
    for(let i = 0; i < mid-low + 1 ; i++){
        leftArr.push(arr[i+low]);
    }
    for(let i = 0 ; i < high- mid ; i++){
        rightArr.push(arr[i + mid + 1]);
    }
    let i = 0;
    let j = 0;
    let k = low;
    while(i<leftArr.length && j<rightArr.length){
        if(leftArr[i] <= rightArr[j]){
            arr[k] = leftArr[i++];
        }else{
            arr[k] = rightArr[j++];
        }
        k++;
    }
    while(i < leftArr.length){
        arr[k] = leftArr[i++];
        k++;
    }
    while(j < rightArr.length){
        arr[k] = rightArr[j++];
        k++;
    }
}   
const mergeSort = (arr,low,high) => {
    if(low >= high) return;
    const mid = Math.floor((low + high) / 2);
    mergeSort(arr,low,mid);
    mergeSort(arr,mid+1,high);
    merge(arr,low,mid,high)
}

let arr = [18,7,19,23,15,11];
mergeSort(arr,0,arr.length-1);
console.log(arr);