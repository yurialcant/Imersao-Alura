public class GerarUrl {
    private static String url = "https://api.mocki.io/v2/549a5d8b/";
    private static String topMovies = "Top250Movies/";
    //private static String topSeries = "Top250TVs/";
    private static String url2 = "https://api.nasa.gov/planetary/apod?api_key=NHyHQzN4l1NtsoObOEemJdnfFCAVncJusxAWHcBr";
    private static String data = "&start_date=2022-06-12&end_date=2022-06-14";
    private static String url3 = "https://yuri-alura-linguagens-api.herokuapp.com/";
    private static String complemento = "linguas";

    public static String setUrl(int opcaoDesejada){
        if(opcaoDesejada == 1){
            url = "https://api.mocki.io/v2/549a5d8b/" + topMovies;
            return url;
        }else if(opcaoDesejada == 2){
            url2 =  "https://api.nasa.gov/planetary/apod?api_key=NHyHQzN4l1NtsoObOEemJdnfFCAVncJusxAWHcBr" + data;
            return url2;
        }else if (opcaoDesejada ==3){
            url3 = "https://yuri-alura-linguagens-api.herokuapp.com/" + complemento;
            return url3;
        }
        return null;
       
        

    }
}
