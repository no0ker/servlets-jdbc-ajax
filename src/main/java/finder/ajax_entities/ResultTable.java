package finder.ajax_entities;

import java.util.HashSet;
import java.util.Set;

public class ResultTable {
    private Set<Row> rows = new HashSet<Row>();

    public Set<Row> getRows() {
        return rows;
    }

    public void setRows(Set<Row> rows) {
        this.rows = rows;
    }
}
