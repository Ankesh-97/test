package src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.groupingBy;

public class UTFConverter {


    public static void main(String[] args) {
        Process process = new Process();
        System.out.println(process.getseggregatedItems());
    }
}

class Process{
    private final List<InvoiceItem> itemList = new ArrayList<>();
    private final Map<InvoiceItemType, List<InvoiceItem>> seggregatedItems;

    public Process(){
        this.seggregatedItems = this.itemList.stream()
                .collect(groupingBy(i -> isNull(i.getType()) ? InvoiceItemType.MONDAY: i.getType()));
    }

    public Map<InvoiceItemType, List<InvoiceItem>> getseggregatedItems(){
        return this.seggregatedItems;
    }
}

class InvoiceItem{
    private InvoiceItemType type;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

    public InvoiceItemType getType(){
        return InvoiceItemType.TUESDAY;
    }

    public void setType(InvoiceItemType type){
        this.type = type;
    }
}

enum InvoiceItemType{
    MONDAY,
    TUESDAY;
}


