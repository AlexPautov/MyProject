
public class Decoder {

    static char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y','z'};

    public static String decode(String text, int key) {
        char[] chars = text.toCharArray();
        StringBuilder DecryptedText = new StringBuilder();

        for (Character symbol : chars) {
            if (Character.isAlphabetic(symbol)) {
                if (Character.isLowerCase(symbol)) {
                    for (int i = 0; i < alphabet.length; i++) {
                        if (symbol.equals(alphabet[i])) {
                            char c = alphabet[(i + key) % alphabet.length];
                            DecryptedText.append(c);
                        }
                    }
                } else {
                    symbol = Character.toLowerCase(symbol);
                    for (int i = 0; i < alphabet.length; i++) {
                        if (symbol.equals(alphabet[i])) {
                            char c = alphabet[(i + key) % alphabet.length];
                            c = Character.toUpperCase(c);
                            DecryptedText.append(c);
                        }
                    }
                }
            } else DecryptedText.append(symbol);
        }
        return DecryptedText.toString();
    }

    public static String incrypt(String text, int key) {
        return decode(text, alphabet.length - key);
    }
}

