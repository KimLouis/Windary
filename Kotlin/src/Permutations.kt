/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * Accepted.
 */
class Permutations {

    fun permute(nums: IntArray): List<List<Int>> {
        val results = mutableListOf<List<Int>>()

        if (nums.isEmpty()) {
            return results
        }
        if (nums.size == 1) {
            return results.apply {
                add(mutableListOf(nums[0]))
            }
        }

        val ints = IntArray(nums.size - 1)
        System.arraycopy(nums, 0, ints, 0, nums.size - 1)

        for (list in permute(ints)) {
            for (i in 0..list.size) {
                val tmp = mutableListOf<Int>()
                tmp.addAll(list)
                tmp.add(i, nums[nums.size - 1])
                results.add(tmp)
            }
        }

        return results
    }

}
