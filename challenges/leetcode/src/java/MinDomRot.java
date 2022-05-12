package java;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * <p>
 * <p>
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * <p>
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 * <p>
 * Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
 * <p>
 * If it cannot be done, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tops = 	[2, 1, 2, 4, 2,	2],
 * bottoms = 		[5, 2, 6, 2, 3,	2]
 * <p>
 * <p>
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * <p>
 * Example 2:
 * <p>
 * Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= tops.length <= 2 * 104
 * bottoms.length == tops.length
 * 1 <= tops[i], bottoms[i] <= 6
 * <p>
 * <p>
 * *************************************************************************************************************************************
 * <p>
 * <p>
 * Diagram
 * <p>
 * tops = 		[2, 1, 2, 4, 2,	2],
 * bottoms = 	[5, 2, 6, 2, 3,	2]
 * <p>
 * Check 2 or 5 in either top or bottom for each title
 * <p>
 * Target here can be 2 or 5
 * <p>
 * [ [2, 5], [1, 2], [2, 6], [4, 2], [2, 3], [2, 2] ]
 * <p>
 * <p>
 * target = 2
 * <p>
 * missingTop = 2
 * missingBottom = 3
 * <p>
 * min(missingTop, missingBottom) = 2
 * <p>
 * <p>
 * <p>
 * tops = 		[3, 5, 1, 2, 3],
 * bottoms = 	[3, 6, 3, 3, 4]
 * <p>
 * Check 3 or 3 in either top or bottom for each title
 * <p>
 * Target here can be 3
 * <p>
 * missingTop = 0
 * missingBottom = 0
 * <p>
 * min(missingTop, missingBottom) = 0
 * <p>
 * <p>
 * Pseudocoding
 * <p>
 * for target in first domino's top or bottom:
 * init missTopCount
 * init missBottomCount
 * <p>
 * for i in top.length
 * if top[i] != target and bottom[i] != target: return -1
 * else if top == target or bottom == target: break
 * else if top != target: missTopCount++
 * else if bottom != target: missBottomCount++
 * <p>
 * return min(missingTop, missingBottom)
 */

public class MinDomRot { //1007. Minimum Domino Rotations For Equal
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int missingTopCount = 0, missingBottomCount = 0;
        for (int target = 0; target < tops.length; target++) {
            missingTopCount = 0;
            missingBottomCount = 0;

            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != target && bottoms[i] != target) return -1;
                else if (tops[i] == target && bottoms[i] == target) break;
                else if (tops[i] != target) missingTopCount++;
                else if (bottoms[i] != target) missingBottomCount++;
            }
        }
        return Math.min(missingBottomCount, missingTopCount);
    }

    public static void main(String[] args) {
        System.out.println(new MinDomRot().minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
    }
}