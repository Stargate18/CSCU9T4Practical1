// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
	   boolean found = false;
       for (Entry x : tr) {
          if (x.getName().equalsIgnoreCase(e.getName()) && x.getDay() == e.getDay() && x.getMonth() == e.getMonth() && x.getYear() == e.getYear()) {
        	 found = true;
            }
       }
       if (!found) tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   // look up all entries of a given day and month
   public String lookupAllEntries (int d, int m, int y) {
       boolean found = false;
       String result = "";
       for (Entry x : tr) {
          if (x.getDay() == d && x.getMonth() == m && x.getYear() == y) {
        	 result = result + x.getEntry();
          	found = true;
            }
       }
       if (found) {
    	   return result;
       } else {
    	   return "Sorry couldn't find anything for this date";
       }
   } // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord