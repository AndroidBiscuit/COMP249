public class TST {
    private static String authorList1 = "J. Park and J. N. James and Q. Li and Y. Xu and W. Huang";
    private static String authorList2 = "T. Jackson and A. H. Peterson and N. Wang";
    private static String authorList3 = "S. Simon and K. Tomson";
    private static String andSpace = " and ";

    public static String generateAuthorFormat(String format, String authors){
        String authorList = "";
        int oldIndex = 0;

        switch (format){
            case "IEEE":
                for (int i = authors.indexOf(andSpace);i >= 0; i = authors.indexOf(andSpace, i + 1)) {
                    if (oldIndex == 0){
                        authorList += authors.substring(oldIndex, i);
                    }
                    else {
                        authorList += authors.substring(oldIndex + andSpace.length(), i);
                    }

                    authorList += ", ";

                    oldIndex = i;
                }
                authorList += authors.substring(oldIndex + andSpace.length()) + ".";
                break;

            case "ACM" :
                authorList += authors.substring(0, authors.indexOf(andSpace)) + " et al.";
                break;

            case "NJ" :
                for (int i = authors.indexOf(andSpace);i >= 0; i = authors.indexOf(andSpace, i + 1)) {
                    if (oldIndex == 0){
                        authorList += authors.substring(oldIndex, i);
                    }
                    else {
                        authorList += authors.substring(oldIndex + andSpace.length(), i);
                    }

                    authorList += " & ";

                    oldIndex = i;
                }
                authorList += authors.substring(oldIndex + andSpace.length()) + ".";
                break;

            default:
                authorList += "Error - Invalid format";
                break;
        }

        return authorList;
    }

    public static void main(String args[]){
        System.out.println(generateAuthorFormat("IEEE", authorList1));
        System.out.println(generateAuthorFormat("ACM", authorList2));
        System.out.println(generateAuthorFormat("NJ", authorList3));
    }
}
