/*
Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/
var sums = mutableListOf<Int>()

fun dailyCodingProblem1(nums: Collection<Int>, num: Int): Boolean {
    val head = nums.first()
    val tail = nums.drop(1)

    return with(tail) {
        if (isNotEmpty()) {
            tail.forEach {
                if (head + it == num) return true//sums.add(head + it)
            }
            //if (sums.contains(num)) return true
            dailyCodingProblem1(tail, num)
        } else return false
    }
    return false
}

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/

fun dailyCodingProblem2(nums: List<Int>): List<Int> {
    val list = mutableListOf<Int>()
    val tempIndex = -1
    nums.asSequence().forEachIndexed { index, value -> list.add(nums.fold(value) { acc: Int, i: Int -> (acc * i) } / nums[index] ) }
    return list
}