function singleNumber(nums: number[]): number {
    let result:number = 0;
    nums.forEach(num => {
        result = num ^ result;
    })

    return result;
};