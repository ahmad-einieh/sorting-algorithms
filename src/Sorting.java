import java.util.LinkedList;
import java.util.List;

class test {
    int n;
    char l;

    public test(int i, char b) {
        n = i;
        l = b;
    }
}

public class Sorting {
    public static void main(String[] args) {
        test[] a =
                {new test(3, 'b'), new test(5, 'd'), new test(3, 'a'),
                        new test(2, 'e'), new test(7, 'e'), new test(5, 'b'),
                        new test(1, 'f')};
        int[] b = {10 , 1 , 4 , 33 , 5 , 9};

        // enter array and size of it
        //insersionSort();
        //selectionSort(b,b.length);
        //selectionSort1(a, a.length);
        //bubbleSort();
        //bubbleSort1(a, a.length);
        // enter array and star point and last point
        //mergeSort();
        quickSort(b,0,5);
        /*
        //entre array and size of it and number of bucket
        bucketSort();*/
        //enter array and size of it and size of new array
        //countSort();
        //radixSort();

      /*  for (int j = 0; j < a.length; j++)
            System.out.print("(" + a[j].n + "," + a[j].l + "),");
        System.out.println("");*/
        for (int j = 0; j < b.length; j++) System.out.print(b[j] + ", ");
    }

    // insertion sort //
    public static void insersionSort(int a[], int n) {
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && a[j - 1] > a[j]) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }
    }

    // selection sort //
    public static void selectionSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void selectionSort1(test a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].n < a[min].n) {
                    min = j;
                }
            }
            test temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    // bubble sort //
    public static void bubbleSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }
    }

    public static void bubbleSort1(test a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j].n > a[j + 1].n) {
                    test temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }
    }

    // merge sort //
    public static void mergeSort(int a[], int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    private static void merge(int[] a, int l, int m, int r) {
        int b[] = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r)
            if (a[i] <= a[j])
                b[k++] = a[i++];
            else
                b[k++] = a[j++];
        if (i > m)
            while (j <= r)
                b[k++] = a[i++];
        else
            while (i <= m)
                b[k++] = a[i++];
        for (k = 0; k < b.length; k++) {
            a[k + l] = b[k];
        }
    }

    // quick sort //
    public static void quickSort(int a[], int l, int r) {
        if (l < r) {
            int s = partition(a, l, r);
            quickSort(a, l, s - 1);
            quickSort(a, s + 1, r);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int p = a[l], i = l + 1, j = r;
        while (i < j) {
            while (a[i] <= p && i < j)
                i++;
            while (a[j] > p && i < j)
                j--;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int s;
        if (a[i] <= p) s = i;
        else s = i - 1;
        int temp = a[l];
        a[l] = a[s];
        a[s] = temp;
        return s;
    }

    // bucket sort //
    /*public static void bucketSort(int a[],int n,int k){
        List<Integer>[] buckets = new List[k];
        for (int b =0 ;b<k;b++)
            buckets[b] = new LinkedList<Integer>();
        int max = max(a,n);
        max++;
        for (int i =0 ;i<n;i++) buckets[k*a[i]/max].add(a[i]);
        int i = 0;
        for (int b = 0 ;b<k;b++) {
            int []B = sort(buckets[b]);
            for (int j = 0;j<B.length;j++)
                a[i++] = B[j];
        }
    }*/
    // counting sort //
    public static void countSort(int a[], int n, int m) {
        int count[] = new int[m];
        for (int j = 0; j < m; j++) count[j] = 0;
        for (int i = 0; i < n; i++) count[a[i]]++;
        for (int j = 1; j < m; j++) count[j] += count[j - 1];
        int b[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            b[count[a[i]] - 1] = a[i];
            count[a[i]]--;
        }
        for (int i = 0; i < n; i++) a[i] = b[i];
    }

    // radix sort //
    public static void radixSort(int a[], int n, int b) {
        int B[] = new int[n];
        int dv = 1;
        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                B[i] = (a[i] / dv) % b;
                if (B[i] != 0) done = false;
            }
            if (done) break;
            int index[] = countSortIndex(B, n, b);
            for (int i = 0; i < n; i++) B[index[i]] = a[i];
            for (int i = 0; i < n; i++) a[i] = B[i];
            //dv *= b;

        }
    }

    private static int[] countSortIndex(int[] a, int n, int m) {
        int count[] = new int[m];
        for (int j = 0; j < m; j++) count[j] = 0;
        for (int i = 0; i < n; i++) count[a[i]]++;
        for (int j = 1; j < m; j++) count[j] += count[j - 1];
        int index[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            index[i] = count[a[i]] - 1;
            count[a[i]]--;
        }
        return index;
    }
    /// /// /// /// /// all methods is done /// /// /// /// /// ///

}
