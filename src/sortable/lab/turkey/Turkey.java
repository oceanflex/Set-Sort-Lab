package sortable.lab.turkey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 *
 * @author zsummers
 */
public class Turkey implements Comparable{
    private String breed;
    private String tag;
    private boolean cooked;
    private double weight;

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCooked(boolean cooked) {
        this.cooked = cooked;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Turkey(String breed, String tag, double weight) {
        this.breed = breed;
        this.tag = tag;
        this.cooked = false;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Turkey{" + "breed=" + breed + ", tag=" + tag + ", cooked=" + cooked + ", weight=" + weight + '}';
    }

    public String getBreed() {
        return breed;
    }

    public String getTag() {
        return tag;
    }

    public boolean isCooked() {
        return cooked;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.tag != null ? this.tag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turkey other = (Turkey) obj;
        if ((this.tag == null) ? (other.tag != null) : !this.tag.equals(other.tag)) {
            return false;
        }
        return true;
    }

    public int compareTo(Object o) {
        Turkey in = (Turkey)o;
        return new CompareToBuilder()
                .append(this.getTag(), in.getTag())
                .toComparison();
    }
    
    
    public static void main(String[] args) {
        Set<Turkey> set = new TreeSet<Turkey>();
        set.add(new Turkey("Red","a12",5.6));
        set.add(new Turkey("Brown","b42",12.4));
        set.add(new Turkey("Red","c71",7.2));
        List<Turkey> list = new ArrayList<Turkey>(set);
        list.add(new Turkey("Red","a12",5.6));
        //Collections.sort(list);
        Collections.sort(list, new TurkeyByWeight());
        for(Turkey t:list){
            System.out.println(t);
        }
    }
}
