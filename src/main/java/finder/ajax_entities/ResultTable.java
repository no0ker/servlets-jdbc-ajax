package finder.ajax_entities;

import com.google.gson.Gson;

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

    public void addRow(Row row){
        rows.add(row);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
