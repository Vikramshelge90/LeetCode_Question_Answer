class RandomizedSet {
    private Map<Integer, Integer> d = new HashMap<>();
    private List<Integer> q = new ArrayList<>();
    private Random rnd = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (d.containsKey(val)) {
            return false;
        }
        d.put(val, q.size());
        q.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!d.containsKey(val)) {
            return false;
        }
        int i = d.get(val);
        d.put(q.get(q.size() - 1), i);
        q.set(i, q.get(q.size() - 1));
        q.remove(q.size() - 1);
        d.remove(val);
        return true;
    }

    public int getRandom() {
        return q.get(rnd.nextInt(q.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


/////////

public class Insert_Delete_GetRandom_O_1 {

    public static void main(String[] args) {

        Insert_Delete_GetRandom_O_1 out = new Insert_Delete_GetRandom_O_1();

        // Init an empty set.
        RandomizedSet randomSet = out.new RandomizedSet();

        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.insert(0));

        System.out.println(randomSet.getRandom());

        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));
    }

    class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> map; // val => its index in list
        Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            int pos = list.size();

            list.add(val);
            map.put(val, pos);

            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            // swap val to end of list, then remove it
            int pos = map.get(val);
            int lastVal = list.get(list.size() - 1);

            list.set(pos, lastVal);
            list.remove(list.size() - 1);

            map.put(lastVal, pos); // @note: missed this line
            map.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int randIndex = random.nextInt(list.size());
            return list.get(randIndex);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}