package in.ineuron;

public class Question5 {

	public static int compressCharacter(char[] chars) {
        int write = 0; // write pointer
        int count = 1; // consecutive occurrence count
  
        for(int i=0;i<chars.length;i++) {
        	if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                chars[write] = chars[i];
                write++;

                if (count > 1) {                
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[write] = c;
                        write++;
                    }
                }

                count = 1; 
            } else 
                count++;
        }

        return write;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = compressCharacter(chars);

        System.out.println("New length: " + newLength);
        System.out.print("Compressed array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
    }
}

