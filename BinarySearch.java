public class BinarySearch {
    static public int search(int[] nums, int target) {
        int lowerIndex = 0;
        int upperIndex = nums.length;
        int currentIndex = upperIndex / 2;
        int currentValue = nums[upperIndex / 2];
        while (lowerIndex <= upperIndex) {
            currentIndex = (lowerIndex + upperIndex) / 2;
            currentValue = nums[currentIndex];

            if (currentValue == target) {
                break;
            } else {
                if (currentValue > target) {
                    upperIndex = currentIndex - 1;
                } else {
                    lowerIndex = currentIndex + 1;
                }
            }
        }
        return currentValue == target ? currentIndex : -1;
    }

    public static void main(String[] args) {
        search(new int[] { -1, 0, 3, 5, 9, 12 }, 2);
    }
}