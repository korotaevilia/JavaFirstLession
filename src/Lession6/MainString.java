package Lession6;

class MainString {
    public static void main(String[] args) {

        String str1 = " Предложение один    Теперь предложение два     Предложение три Предложение четыре";
        System.out.println(str1);

        String str2 = str1.replaceAll(" +", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);
        int count = 0;
        for (int i = 2; i < str2.length(); i++) {
            if (str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Я') {
                stringBuilder.setCharAt(i - 1+count, '.');
                stringBuilder.insert(i+count, ' ');
                count++;
            }
        }

        stringBuilder.append('.');

        System.out.println(stringBuilder.toString());

    }
}