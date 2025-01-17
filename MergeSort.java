public class MergeSort {

        int[] arr = {122, 58, 47, 56, 45, 32, 121};

        int[] b;

        MergeSort() {
            b = new int[arr.length];
        }

        void merge(int low, int mid, int high) {
            int i = low;
            int j = mid + 1;
            int k = low;

            while (i <= mid && j <= high) {
                if (arr[i] <= arr[j]) {
                    b[k++] = arr[i++];
                } else {
                    b[k++] = arr[j++];
                }
            }

            while (i <= mid) {
                b[k++] = arr[i++];
            }

            while (j <= high) {
                b[k++] = arr[j++];
            }

            for (i = low; i <= high; i++) {
                arr[i] = b[i];
            }
        }

        void sort(int low, int high) {
            if (low < high) {
                int mid = (low + high) / 2;

                sort(low, mid);
                sort(mid + 1, high);

                merge(low, mid, high);
            }
        }

        public static void main(String[] args) {
            MergeSort obj = new MergeSort();

            System.out.println("Array before sorting:");
            for (int i = 0; i < obj.arr.length; i++) {
                System.out.print(obj.arr[i] + " ");
            }

            obj.sort(0, obj.arr.length - 1);

            System.out.println("\nArray after sorting:");
            for (int i = 0; i < obj.arr.length; i++) {
                System.out.print(obj.arr[i] + " ");
            }
        }
    }

