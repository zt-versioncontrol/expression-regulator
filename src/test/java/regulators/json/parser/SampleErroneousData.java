package regulators.json.parser;

public class SampleErroneousData {
    public static final String INDENTED_JSON = "{\n" +
            "  \"statusCode\": \"Success\",\n" +
            "  \"status\": \"Success\",\n" +
            "  \"data\": {\n" +
            "    \"breadCrumb\": {\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"text\": \"Ana Sayfa\",\n" +
            "          \"url\": \"https://www.kariyer.net\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": \"İş İlanları\",\n" +
            "          \"url\": \"https://www.kariyer.net/is-ilanlari\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": \"İngilizce İş İlanları\",\n" +
            "          \"url\": \"https://www.kariyer.net/is-ilanlari/ingilizce\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"totalJobCount\": 148,\n" +
            "    \"totalJobCountWithOutSponsored\": 148,\n" +
            "    \"title\": \"İngilizce Bilen İş İlanları - İngilizce İş Fırsatları\",\n" +
            "    \"jobs\": {\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"id\": 3213313,\n" +
            "          \"title\"\"Senior Software Developer\",\n" +  //first error*******************************************
            "          companyName: \"Arvato Lojistik Anonim Şirketi\",\n" +  //second error*********************************
            "          \"jobUrl\": \"/is-ilani/arvato-lojistik-anonim-sirketi-senior-software-developer-3213313\",\n" +
            "          \"companyUrl\": \"/firma-profil/arvato-lojistik-anonim-sirketi-60191-222615\",\n" +
            "          \"logoUrl\": \"yeni.jpg.jpg\",\n" +
            "          \"fullPathLogoUrl\": \"https://img-kariyer.mncdn.com/UploadFiles/Clients/Logolar/yeni.jpg.jpg\",\n" +
            "          \"locationText\": \"İstanbul(Asya)\",\n" +
            "          \"isSponsored\": false,\n" +
            "          \"humanReward\": false,\n" +
            "          \"workType\": \"FullTime\",\n" +
            "          \"workTypeText\": \"Full-Time\",\n" +
            "          \"jobDateText\": \"1 gün önce\",\n" +
            "          \"memberJobStatus\": \"Inspected\",\n" +
            "          \"isHandicapped\": false,\n" +
            "          \"isFavorite\": false,\n" +
            "          \"hasVideo\": false,\n" +
            "          \"hasIso\": false,\n" +
            "          \"companyId\": 60191,\n" +
            "          \"profileId\": 222615,\n" +
            "          \"jobDateStatus\": \"Default\",\n" +
            "          \"postingDate\": \"2023-10-12\",\n" +
            "          \"confidential\": false,\n" +
            "          \"sectors\": [\n" +
            "            {\n" +
            "              \"code\": \"016007000\",\n" +
            "              \"name\": \"Lojistik\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"onlyPublishedOnKariyerNet\": true,\n" +
            "          \"isLogoSelected\": 0,\n" +
            "          \"showTime\": \"2023-09-17T09:45\",\n" +
            "          \"positionLevel\": 3,\n" +
            "          \"allLocations\": \"İstanbul(Asya)\",\n" +
            "          \"squareLogoUrl\": \"https://img-kariyer.mncdn.com/mnresize/150/150/UploadFiles/Clients/SquareLogo/191/60191_254912.jpg\",\n" +
            "          \"isDisaster\": false,\n" +
            "          \"workModel\": \"OnSite\",\n" +
            "          \"isEasyApply\": false,\n" +
            "          \"locations\": [\n" +
            "            {\n" +
            "              \"countryId\": \"65\",\n" +
            "              \"countryName\": \"Türkiye\",\n" +
            "              \"cityId\": \"82\",\n" +
            "              \"cityName\": \"İstanbul(Asya)\",\n" +
            "              \"jobTownLocationList\": [\n" +
            "                {\n" +
            "                  \"townId\": \"457\",\n" +
            "                  \"townName\": \"Kadıköy\"\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 3609107,\n" +
            "          \"title\": \"Mobile Application Developer\",\n" +
            "          \"companyName\": \"Smartiks Yazılım A.Ş.\",\n" +
            "          \"jobUrl\": \"/is-ilani/smartiks-yazilim-a-s-mobile-application-developer-3609107\",\n" +
            "          \"companyUrl\": \"/firma-profil/smartiks-yazilim-a-s-13078-3368\",\n" +
            "          \"logoUrl\": \"13078_1242901.jpg\",\n" +
            "          \"fullPathLogoUrl\": \"https://img-kariyer.mncdn.com/UploadFiles/Clients/Logolar/13078_1242901.jpg\",\n" +
            "          \"locationText\": \"İstanbul (Tümü)\",\n" +
            "          \"isSponsored\": false,\n" +
            "          \"humanReward\": false,\n" +
            "          \"workType\": \"FullTime\",\n" +
            "          \"workTypeText\": \"Full-Time\",\n" +
            "          \"jobDateText\": \"2 gün önce\",\n" +
            "          \"memberJobStatus\": \"Inspected\",\n" +
            "          \"isHandicapped\": false,\n" +
            "          \"isFavorite\": false,\n" +
            "          \"hasVideo\": false,\n" +
            "          \"hasIso\": false,\n" +
            "          \"companyId\": 13078,\n" +
            "          \"profileId\": 3368,\n" +
            "          \"jobDateStatus\": \"Default\",\n" +
            "          \"postingDate\": \"2023-10-11\",\n" +
            "          \"confidential\": false,\n" +
            "          \"sectors\": [\n" +
            "            {\n" +
            "              \"code\": \"001000000\",\n" +
            "              \"name\": \"Bilişim\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"onlyPublishedOnKariyerNet\": true,\n" +
            "          \"isLogoSelected\": 0,\n" +
            "          \"showTime\": \"2023-09-19T16:32\",\n" +
            "          \"positionLevel\": 0,\n" +
            "          \"allLocations\": \"İstanbul(Asya), İstanbul(Avr.) ...\",\n" +
            "          \"squareLogoUrl\": \"\",\n" +
            "          \"isDisaster\": false,\n" +
            "          \"workModel\": \"Remote\",\n" +
            "          \"isEasyApply\": false,\n" +
            "          \"locations\": [\n" +
            "            {\n" +
            "              \"countryId\": \"65\",\n" +
            "              \"countryName\": \"Türkiye\",\n" +
            "              \"cityId\": \"34\",\n" +
            "              \"cityName\": \"İstanbul(Avr.)\",\n" +
            "              \"jobTownLocationList\": []\n" +
            "            },\n" +
            "            {\n" +
            "              \"countryId\": \"65\",\n" +
            "              \"countryName\": \"Türkiye\",\n" +
            "              \"cityId\": \"82\",\n" +
            "              \"cityName\": \"İstanbul(Asya)\",\n" +
            "              \"jobTownLocationList\": []\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"companyItems\": [],\n" +
            "      \"companyProfileItems\": **,\n" +
            "      \"currentPage\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  \"message\": null,\n" +
            "  \"error\": null\n" +
            "}";

    public static final String MINIFIED_JSON = "{\"statusCode\":\"Success\",\"status\":\"Success\",\"data\":{\"breadCrumb\":{\"items\":[{\"text\":\"Ana Sayfa\",\"url\":\"https://www.kariyer.net\"},{\"text\":\"İş İlanları\",\"url\":\"https://www.kariyer.net/is-ilanlari\"},{\"text\":\"İngilizce İş İlanları\",\"url\":\"https://www.kariyer.net/is-ilanlari/ingilizce\"}]},\"totalJobCount\":148,\"totalJobCountWithOutSponsored\":148,\"title\":\"İngilizce Bilen İş İlanları - İngilizce İş Fırsatları\",\"jobs\":{\"items\":[{\"id\":3213313,\"title\"\"Senior Software Developer\",companyName:\"Arvato Lojistik Anonim Şirketi\",\"jobUrl\":\"/is-ilani/arvato-lojistik-anonim-sirketi-senior-software-developer-3213313\",\"companyUrl\":\"/firma-profil/arvato-lojistik-anonim-sirketi-60191-222615\",\"logoUrl\":\"yeni.jpg.jpg\",\"fullPathLogoUrl\":\"https://img-kariyer.mncdn.com/UploadFiles/Clients/Logolar/yeni.jpg.jpg\",\"locationText\":\"İstanbul(Asya)\",\"isSponsored\":false,\"humanReward\":false,\"workType\":\"FullTime\",\"workTypeText\":\"Full-Time\",\"jobDateText\":\"1 gün önce\",\"memberJobStatus\":\"Inspected\",\"isHandicapped\":false,\"isFavorite\":false,\"hasVideo\":false,\"hasIso\":false,\"companyId\":60191,\"profileId\":222615,\"jobDateStatus\":\"Default\",\"postingDate\":\"2023-10-12\",\"confidential\":false,\"sectors\":[{\"code\":\"016007000\",\"name\":\"Lojistik\"}],\"onlyPublishedOnKariyerNet\":true,\"isLogoSelected\":0,\"showTime\":\"2023-09-17T09:45\",\"positionLevel\":3,\"allLocations\":\"İstanbul(Asya)\",\"squareLogoUrl\":\"https://img-kariyer.mncdn.com/mnresize/150/150/UploadFiles/Clients/SquareLogo/191/60191_254912.jpg\",\"isDisaster\":false,\"workModel\":\"OnSite\",\"isEasyApply\":false,\"locations\":[{\"countryId\":\"65\",\"countryName\":\"Türkiye\",\"cityId\":\"82\",\"cityName\":\"İstanbul(Asya)\",\"jobTownLocationList\":[{\"townId\":\"457\",\"townName\":\"Kadıköy\"}]}]},{\"id\":3609107,\"title\":\"Mobile Application Developer\",\"companyName\":\"Smartiks Yazılım A.Ş.\",\"jobUrl\":\"/is-ilani/smartiks-yazilim-a-s-mobile-application-developer-3609107\",\"companyUrl\":\"/firma-profil/smartiks-yazilim-a-s-13078-3368\",\"logoUrl\":\"13078_1242901.jpg\",\"fullPathLogoUrl\":\"https://img-kariyer.mncdn.com/UploadFiles/Clients/Logolar/13078_1242901.jpg\",\"locationText\":\"İstanbul (Tümü)\",\"isSponsored\":false,\"humanReward\":false,\"workType\":\"FullTime\",\"workTypeText\":\"Full-Time\",\"jobDateText\":\"2 gün önce\",\"memberJobStatus\":\"Inspected\",\"isHandicapped\":false,\"isFavorite\":false,\"hasVideo\":false,\"hasIso\":false,\"companyId\":13078,\"profileId\":3368,\"jobDateStatus\":\"Default\",\"postingDate\":\"2023-10-11\",\"confidential\":false,\"sectors\":[{\"code\":\"001000000\",\"name\":\"Bilişim\"}],\"onlyPublishedOnKariyerNet\":true,\"isLogoSelected\":0,\"showTime\":\"2023-09-19T16:32\",\"positionLevel\":0,\"allLocations\":\"İstanbul(Asya), İstanbul(Avr.) ...\",\"squareLogoUrl\":\"\",\"isDisaster\":false,\"workModel\":\"Remote\",\"isEasyApply\":false,\"locations\":[{\"countryId\":\"65\",\"countryName\":\"Türkiye\",\"cityId\":\"34\",\"cityName\":\"İstanbul(Avr.)\",\"jobTownLocationList\":[]},{\"countryId\":\"65\",\"countryName\":\"Türkiye\",\"cityId\":\"82\",\"cityName\":\"İstanbul(Asya)\",\"jobTownLocationList\":[]}]}],\"companyItems\":[],\"companyProfileItems\":**,\"currentPage\":1}},\"message\":null,\"error\":null}";

}
