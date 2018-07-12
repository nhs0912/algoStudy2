import java.util.*;

public class Problem4 {

    int[] testArr;
    ArrayList arrList;
    List linkedList;
    Vector vectorList;
    Queue queue = new LinkedList();
    TreeSet ts = new TreeSet();
    HashSet hs = new HashSet();
    LinkedHashSet linkedHashSet = new LinkedHashSet();
    TreeMap tm = new TreeMap();
    HashMap hm= new HashMap();
    LinkedHashMap linkedHashMap = new LinkedHashMap();
    IdentityHashMap identityHashMap = new IdentityHashMap();
    WeakHashMap weakHashMap = new WeakHashMap();
    Hashtable hashTable = new Hashtable<Integer,Integer>();
    public void makeArrData(int size) {
        testArr = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            testArr[i] = i;
        }
    }

    public void makeArrListData(int size) {
        arrList = new ArrayList(size);
        for (int i = 0; i <= size; i++) {
            arrList.add(i);
        }
    }

    public void makeLinkedListData(int size) {
        linkedList = new LinkedList();
        for (int i = 0; i <= size; i++) {
            linkedList.add(i);
        }

    }

    public void makeVectorData(int size) {
        vectorList = new Vector(size);
        for (int i = 0; i <= size; i++) {
            vectorList.add(i);
        }
    }

    public void makeQueueData(int size) {
        for (int i = 0; i <= size; i++) {
            queue.add(i);
        }
    }

//    public void iteratorDo(int size) {
//        int cnt = 0;
//        Iterator iterator = hm.iterator();
//        while (iterator.hasNext()) {
//
//            if (cnt == size) {
//                tm.add(999);
//                break;
//            }
//            cnt++;
//        }
//    }

    public void makeTreeSetData(int size) {
        for (int i = 0; i <= size; i++) {
            ts.add(i);
        }
    }

    public void makeHashSetData(int size) {
        for (int i = 0; i <= size; i++) {
            hs.add(i);
        }
    }

    public void makeLinkedHashSetData(int size)
    {
        for(int i=0; i<=size; i++) {
            linkedHashSet.add(size);
        }
    }

    public void makeTreeMapData(int size) {
        for(int i=0;i<=size;i++) {
            tm.put(i,i);
        }
    }

    public void makeHashMapData(int size) {
        for(int i=0;i<=size;i++) {
            hm.put(i,i);
        }
    }
    public void makeLinkedHashMapData(int size) {
        for(int i=0;i<=size;i++) {
            linkedHashMap.put(i,i);
        }
    }

    public void makeIdentityHashMapData(int size) {
        for(int i=0;i<=size;i++) {
            identityHashMap.put(i,i);
        }
    }
    public void makeWeakHashMapData(int size) {
        for(int i=0;i<=size;i++) {
            weakHashMap.put(i,i);
        }
    }


    public void makeHashTableData(int size) {
        for(int i=0;i<=size;i++) {
            hashTable.put(i,i);
        }
    }
    public void timeCheck() {
        //makeVectorData(10000);
        //makeArrData(10000);
        //  makeArrListData(10000);
        //   makeLinkedListData(10000);
//        iteratorDo();
        //makeQueueData(10000);
        // makeTreeSetData(10000);
        makeHashTableData(10000);

        int cnt = 0;
        int num = 10;
        while (cnt++ < 4) {

            long startTime = System.nanoTime();
            makeHashTableData(num);
            long endTime = System.nanoTime();

            System.out.println(num + ": " + (endTime - startTime) + " ms elapsed");
            num *= 10;
        }


        cnt=0;num = 10;
        while (cnt++ < 4) {

            long startTime = System.nanoTime();
            hashTable.get(num);

            long endTime = System.nanoTime();

            System.out.println(num + ": " + (endTime - startTime) + " ms elapsed");
            num *= 10;
        }

//        cnt=0;num = 10;
//        while (cnt++ < 4) {
//
//            long startTime = System.nanoTime();
//            iteratorDo(num);
//            long endTime = System.nanoTime();
//
//            System.out.println(num + ": " + (endTime - startTime) + " ms elapsed");
//            num *= 10;
//        }
    }


    public static void main(String[] args) {
        new Problem4().timeCheck();
    }


}
