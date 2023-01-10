package setPackage;

public class Set {
    private Integer[] set;
    public Set(Integer[] set){
        this.set = new Integer[set.length];
        this.set = set;
    }
    public Set(int N){
        this.set = new Integer[N];
    }
    public Integer[] sort(Integer[] set){
        for (int i = 0; i < set.length; ++i) {
            for (int j = 0; j < set.length - 1; ++j) {
                if (set[j] > set[j + 1]){
                    Integer temp = set[j];
                    set[j] = set[j + 1];
                    set[j + 1] = temp;
                }
            }
        }
        return set;
    }
    public Set mergeSets(Set set2){
        Set mergedSet = new Set(this.set.length);
        for(int i = 0; i < this.set.length; ++i){
            mergedSet.set[i] = set[i];
        }
        for(int i = 0; i < set2.set.length; ++i){
            mergedSet.addElement(set2.set[i]);
        }
        mergedSet.set = sort(mergedSet.set);
        for(int i = 0; i < mergedSet.set.length; ++i){
            System.out.print(mergedSet.set[i]+" ");
        }
        System.out.println();
        return mergedSet;
    }
    public boolean isPartOfSet(int x){
        for(int i = 0; i < this.set.length; ++i){
            if(this.set[i].equals(x)) {
                return true;
            }
        }
        return false;
    }
    public void printSet(){
        System.out.println("Set:");
        for(int i = 0; i < this.set.length; ++i){
            System.out.print(this.set[i]+" ");
        }
        System.out.println();
    }
    public boolean addElement(int el){
        if (!this.isPartOfSet(el)){
            Integer[] newSet = new Integer[this.set.length + 1];

            for(int i = 0; i < this.set.length; ++i){
                newSet[i] = this.set[i];
            }
            newSet[this.set.length] = el;
            this.set = sort(newSet);
            return true;
        }
        return false;
    }
    public boolean deleteElement(int el){
        boolean isDeleted = this.isPartOfSet(el);
        Integer[] newSet = new Integer[this.set.length - 1];
        for(int i = 0, j = 0; i < this.set.length; ++i, ++j){
            if(this.set[i].equals(el)){
                ++i;
            }
            newSet[j] = this.set[i];
        }
        this.set = newSet;
        return isDeleted;
    }
    public boolean equals(Set set2){
        if(this.set.length != set2.set.length){
            return false;
        }
        for(int i = 0; i < this.set.length; ++i){
            if(!set2.set[i].equals(this.set[i])){
                return false;
            }
        }
        return true;
    }
    public String toString(){
        String result = new String();
        for(int i = 0; i < this.set.length; ++i){
            result += Integer.toString(this.set[i]);
        }
        return result;
    }
}
