import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private static String filePath;

    public static void main(String[] args) {
        List<Integer> nums = setUpList();
        List<Integer> result = getSublistWithMaxProduct(nums, 9);
        int num = sumOfDiagonalsOfClockwiseMatrix(7);

        long num1 = fastExp(2, 5);
        long num2 = fastExp(2, 10);
    }



    private static List<Integer> setUpList() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            nums.add(1);
        }
        for (int i = 0; i < 10; i++) {
            nums.add(5);
        }
        for (int i = 0; i < 100; i++) {
            nums.add(1);
        }
        return nums;
    }


    //#8
    public static List<Integer> getSublistWithMaxProduct(List<Integer> nums, int lenOfSeq) {
        long product = getProductOfFirstNElements(nums, lenOfSeq);
        long max = product;
        int start = 0;
        for (int i = 1; i < nums.size() - lenOfSeq; i++) {
            int startingElement = nums.get(i - 1);
            if (subListContainsZero(nums, i, i + lenOfSeq)) {
                continue;
            }
            product /= nums.get(i - 1);
            product *= nums.get(i + lenOfSeq);
            if (product > max) {
                max = product;
                start = i;
            }
        }
        return getSubList(nums, start, start + lenOfSeq);
    }

    private static int getProductOfFirstNElements(List<Integer> nums, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == 0) {
                continue;
            }
            result *= nums.get(i);
        }
        return result;
    }

    private static List<Integer> getSubList(List<Integer> list, int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(list.get(i));
        }
        return result;
    }

    private static int getProduct(List<Integer> list) {
        int result = 1;
        for (int i = 0; i < list.size(); i++) {
            result *= list.get(i);
        }
        return result;
    }

    private static boolean subListContainsZero(List<Integer> nums, int start, int end) {
        for (int i = start; i < end; i++){
            if (nums.get(i) == 0) {
                return true;
            }
        }
        return false;
    }

    //incomplete #24
    public List<Integer> getNthPermutation(List<Integer> nums, int n) {
        List<Integer> result = new ArrayList<>();
        int numOfSlots = nums.size();
        for (int i = 0; i < numOfSlots; i++) {
            int numOfPermsOfRemainingElements = fact(numOfSlots - i);
            if (numOfPermsOfRemainingElements >= n) {
                result.add(nums.get(i));
            } else {

            }
        }
        return null;
    }

    private int fact(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * fact(num - 1);
        }
    }

    //#28
    public static int sumOfDiagonalsOfClockwiseMatrix(int n) {
        int acc = 0;
        int skip = 2;
        for (int i = 1; i <= n * n; i += skip) {
            acc += i;
            if (Math.sqrt(i) % 2 == 1 && Math.sqrt(i) >= 3) {
                skip += 2;
            }
        }
        return acc;
    }

    public static long fastExp(int num, int exp) {
        if (exp <= 1) {
            return num;
        } else {
            long half_result = fastExp(num, exp / 2);
            if (exp % 2 == 0) {
                return half_result * half_result;
            } else {
                return half_result * num * half_result;
            }
        }
    }


}
