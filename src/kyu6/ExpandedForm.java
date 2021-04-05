package kyu6;

/**
 * You will be given a number and you will need to return it as a string in Expanded Form
 */
public class ExpandedForm {

    public static void main(String[] args) {
        System.out.println(expandedForm(70304));
        System.out.println(expandedForm(42));
        System.out.println(expandedForm(403034573));
    }

    public static String expandedForm(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        StringBuilder sb = new StringBuilder();
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            if (digits[i] != '0') {
                //Конкатенируем произведение цифры на соответствующий разряд
                sb.append(Integer.valueOf(String.valueOf(digits[i])) * (int) Math.pow(10, length - i - 1));
                sb.append(" + ");
            }
        }

        String result = sb.toString();
        return result.substring(0, result.lastIndexOf('+') - 1); //Убираем последний плюс
    }
}
