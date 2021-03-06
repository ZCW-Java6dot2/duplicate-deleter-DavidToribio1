package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    public StringDuplicateDeleter(String[] intArray){
        super(intArray);
    }
    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
//count how many indexes to delete
        int indexNumToDelete = 0;
        Integer[] numOfDupes = countRepeats();
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] >= maxNumberOfDuplications){
                indexNumToDelete++;
            }
        }
        //create new array
        String[] answer = new String[array.length-indexNumToDelete];
        //add all (non deleted) indexes
        if (answer.length == 0) return answer;
        int j=0;
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] < maxNumberOfDuplications){
                answer[j] = array[i];
                j++;
            }
        }
        return answer;    }




    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        //count how many indexes to delete
        int indexNumToDelete = 0;
        Integer[] numOfDupes = countRepeats();
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] == exactNumberOfDuplications){
                indexNumToDelete++;
            }
        }
        //create new array
        String[] answer = new String[array.length-indexNumToDelete];
        //add all (non deleted) indexes
        int j=0;
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] != exactNumberOfDuplications){
                answer[j] = array[i];
                j++;
            }
        }
        return answer;
    }
    public Integer[] countRepeats(){
        Integer[] numOfDupes = new Integer[array.length];
        for (int i=0; i<array.length; i++){
            int counter = 1;
            for (int j=0; j<array.length; j++){
                if (i != j){
                    if (array[i] == array[j]){
                        counter++;
                    }
                }
            }
            numOfDupes[i] = counter;
        }
        return numOfDupes;
    }

    }

