public class GerarUrl {
    private static String url = "https://api.mocki.io/v2/549a5d8b/";
    private static String topMovies = "Top250Movies/";
    private static String topSeries = "Top250TVs/";

    public static String setUrl(int opcaoDesejada){
        if(opcaoDesejada == 1){
            url = "https://api.mocki.io/v2/549a5d8b/" + topMovies;
            return url;
        }else if(opcaoDesejada == 2){
            url =  "https://api.mocki.io/v2/549a5d8b/" + topSeries;
            return url;
        }
        return null;
       
        

    }
}
