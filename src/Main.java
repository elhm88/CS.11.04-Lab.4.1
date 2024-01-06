public class Main {

    public static void main(String [] args){
        // Test methods with given examples
        System.out.println(parenthesesCheck("()"));
        System.out.println(parenthesesCheck(")(()))"));
        System.out.println(parenthesesCheck("("));
        System.out.println(parenthesesCheck("(())((()())())"));
    }


    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s){
        int balance = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                balance++;
            } else if (s.charAt(i) == ')'){
                balance--;
            }
            if (balance < 0){
                return false;
            }
        }
        return balance == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        return sb.reverse().toString();
    }

    // 3. encryptThis
    public static String encryptThis(String s){
        StringBuilder encrypted = new StringBuilder();

        int start = 0;
        for (int end = s.indexOf(' '); end != -1; end = s.indexOf(' ', start)){
            String word = s.substring(start, end);
            encrypted.append(encryptWord(word) + " ");
            start = end + 1;
        }

        encrypted.append(encryptWord(s.substring(start)));

        return encrypted.toString();
    }

    private static String encryptWord(String word){
        StringBuilder sb = new StringBuilder(word);

        if (word.length() > 2){
            char temp = word.charAt(1);
            sb.setCharAt(1, sb.charAt(sb.length()-1));
            sb.setCharAt(sb.length()-1, temp);
        }

        return ((int) sb.charAt(0)) + sb.substring(1);
    }

    // 4. decipherThis
    public static String decipherThis(String s){
        StringBuilder deciphered = new StringBuilder();

        int start = 0;
        for (int end = s.indexOf(' '); end != -1; end = s.indexOf(' ', start)){
            String word = s.substring(start, end);
            deciphered.append(decipherWord(word) + " ");
            start = end + 1;
        }

        deciphered.append(decipherWord(s.substring(start)));

        return deciphered.toString();
    }

    private static String decipherWord(String word){
        int i = 0;
        while (i < word.length() && Character.isDigit(word.charAt(i))) {
            i++;
        }
        int charCode = Integer.parseInt(word.substring(0, i));

        StringBuilder sb = new StringBuilder(word);
        sb.replace(0, i, String.valueOf((char) charCode));

        if (sb.length() > 2) {
            char temp = sb.charAt(1);
            sb.setCharAt(1, sb.charAt(sb.length() - 1));
            sb.setCharAt(sb.length() - 1, temp);
        }

        return sb.toString();
    }

}