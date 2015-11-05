package sortable.lab.turkey;

import java.util.Comparator;
import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 *
 * @author zsummers
 */
public class TurkeyByWeight implements Comparator<Turkey>{

    public int compare(Turkey t1, Turkey t2) {
        return new CompareToBuilder()
                .append(t1.getWeight(), t2.getWeight())
                //.append(t1.isCooked(), t2.isCooked())
                .append(t1.getTag(), t2.getTag())
                .toComparison();
    }
    
}
