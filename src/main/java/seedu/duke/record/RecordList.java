package seedu.duke.record;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class RecordList {
    private ArrayList<Record> recordList;

    public RecordList() {
        recordList = new ArrayList<>();
    }

    public RecordList(ArrayList<Record> recordList) {
        this.recordList = recordList;
    }

    public void addRecord(Record recordToAdd, Ui ui, Storage storage) {
        recordList.add(recordToAdd);
        Ui.printSuccessfulAdd(recordToAdd);
        try {
            storage.saveFile(recordList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public Record getRecordAt(int recordIndex) {
        return recordList.get(recordIndex);
    }

    public Record deleteRecordAt(int recordIndex) {
        return recordList.remove(recordIndex);
    }

    public void deleteAllRecords() {
        recordList.clear();
    }

    public int indexOfRecord(Record record) {
        return recordList.indexOf(record);
    }

    public boolean isEmpty() {
        return recordList.isEmpty();
    }

    public int getRecordCount() {
        return recordList.size();
    }

    public void listExpenses(Ui ui) {
        ui.printMessage("List expenses!");
        for (Record r : recordList) {
            System.out.println(r.getDescription());
        }
    }

    public void listLoans(Ui ui) {
        ui.printMessage("List loans!");
    }

    public void listSavings(Ui ui) {
        ui.printMessage("List savings!");
    }
}
