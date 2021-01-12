import java.util.*;

public class InterviewTask {

    public boolean isPasswordPermissible(String password, int maxAllowedRepetitionCount, int maxAllowedSequenceLength) {
        // This method accepts a password (String) and calculates two password strength parameters:
        // Repetition count - the number of occurrences of the *most* repeated character within the password
        //     eg: "password" has a repetition count of 2 - for the 2 consecutive "s" characters
        //     eg2: "Melbourne" has a repetition count of 2 - for the 2 non-consecutive "e" characters.
        //     eg3: "lucky" has a repetition count of 1 - each character appears only once.
        //     eg4: "Example" has a repetition count of 1 - as the two "e" characters have different cases (ie one "E", one "e")
        // The repitition count should be case-sensitive.
        //
        // Max Sequence length - The length of the longest ascending/descending sequence of alphabetical or numeric characters
        //     eg: "1234" and "4321" would both have sequence length of 4
        //     eg2: "abcdef" would have a sequence length of 6
        //     eg3: "password123" would have a max. sequence length of 3 - for the sequence of "123".
        //     eg4: "AbCdEf" would have a sequence length of 6, even though it is mixed case.
        //
        // Check the supplied password.  Return true if the repetition count and sequence length are below the
        // specified maximum.  Otherwise, return false.

        Map<Integer,Integer> character = new HashMap<>();
        for (int i=0;i<password.length();i++){
            int c = password.codePointAt(i);
            if (character.containsKey(c)){
                int size = character.get(c);
                size++;
                character.put(c,size);
            } else {
                character.put(c,1);
            }
        }

        boolean allPass=true;
        for (int key:character.keySet()){
            int size = character.get(key);
            if (size>maxAllowedRepetitionCount) {
                allPass=false;
            }
        }
        if (!allPass) return false;


        //Sequency

        String number = "0123456789";
        String number2= "9876543210";
        String string="abcdefghijklmnopqrstuvwxyz";
        String string2="zyxwvutsrqponmlkjihgfedcba";
        if (isSeq(password,number,maxAllowedSequenceLength)
                || isSeq(password,number2,maxAllowedSequenceLength)
                || isSeq(password,string,maxAllowedSequenceLength)
                || isSeq(password,string2,maxAllowedSequenceLength)){
            return false;
        }
        return true;

    }

    private boolean isSeq(String input, String string, int maxAllowedSequenceLength) {
        input = input.toLowerCase();
        for (int i=0;i<string.length()-1;i++){
            for (int j=i+1;j<=string.length();j++){
                String phase = string.substring(i,j);
                if (input.contains(phase) && phase.length()>maxAllowedSequenceLength){
                    return true;
                }
            }
        }
        return false;
    }




}
