package regulators.json.parser;

public class SampleExpression {
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
            "          \"title\": \"Senior Software Developer\",\n" +
            "          \"companyName\": \"Arvato Lojistik Anonim Şirketi\",\n" +
            "          \"jobUrl\": \"/is-ilani/arvato-lojistik-anonim-sirketi-senior-software-developer-3213313\",\n" +  //first assersion****************************
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
            "              \"code\": \"016007000\",\n" +  //fifth assertion*************************
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
            "          \"id\": 3609107,\n" + //second assersion************************************
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
            "      \"companyProfileItems\": [],\n" +
            "      \"currentPage\": 1\n" +
            "    },\n" +
            "    \"filters\": {\n" +
            "      \"companySectors\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Bilişim\",\n" +
            "            \"value\": \"001000000\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Üretim / Endüstriyel Ürünler\",\n" +
            "            \"value\": \"002000000\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Elektrik & Elektronik\",\n" +
            "            \"value\": \"003000000\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Güvenlik\",\n" +
            "            \"value\": \"004000000\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"positionLevels\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Üst düzey yönetici\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Orta düzey yönetici\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Yönetici adayı\",\n" +
            "            \"value\": \"3\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Uzman\",\n" +
            "            \"value\": \"4\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"departments\": null,\n" +
            "      \"workAreas\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Akademik\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"AR-GE\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Arşiv / Dokümantasyon\",\n" +
            "            \"value\": \"3\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Bakım / Onarım\",\n" +
            "            \"value\": \"4\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"workTypes\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Sürekli / Tam zamanlı\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Dönemsel / Proje bazlı\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Stajyer\",\n" +
            "            \"value\": \"3\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"educationLevels\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Doktora - Mezun\",\n" +
            "            \"value\": \"DM\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Doktora - Öğrenci\",\n" +
            "            \"value\": \"DO\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Yüksek Lisans - Mezun\",\n" +
            "            \"value\": \"MM\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"companyProperties\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"ISO 500 Şirketleri\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"İK Danışmanlığı Yapmayan Şirketler\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Adını Gizlemeyen Şirketlerin İlanları\",\n" +
            "            \"value\": \"3\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"İnsana Saygı Ödüllü Şirketler\",\n" +
            "            \"value\": \"4\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"jobProperties\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Sana Uygun İlanlar\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Kaydettiğin İlanlar\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Takip Ettiğin Şirketin İlanları\",\n" +
            "            \"value\": \"3\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"positions\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Yazılım Geliştirme Uzmanı\",\n" +
            "            \"value\": \"3193\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": true\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Yazılım Uzmanı\",\n" +
            "            \"value\": \"2024\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": true\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Muhasebe Uzmanı\",\n" +
            "            \"value\": \"1327\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"jobLanguages\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Türkçe\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"İngilizce\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": true\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"handicappedStatus\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Tümü\",\n" +
            "            \"value\": \"10\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Sadece engelli ilanlarını göster\",\n" +
            "            \"value\": \"20\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Engelli ilanlarını gösterme\",\n" +
            "            \"value\": \"30\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"dates\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Bugünün ilanları\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Son 3 saat\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Son 8 saat\",\n" +
            "            \"value\": \"3\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"workExperience\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Deneyimli\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Deneyimsiz\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ],\n" +
            "        \"minValue\": 0,\n" +
            "        \"maxValue\": 0\n" +
            "      },\n" +
            "      \"locations\": {\n" +
            "        \"countries\": [\n" +
            "          {\n" +
            "            \"name\": \"Türkiye\",\n" +
            "            \"value\": \"10\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Kıbrıs\",\n" +
            "            \"value\": \"20\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Yurt Dışı\",\n" +
            "            \"value\": \"30\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ],\n" +
            "        \"cities\": [\n" +
            "          {\n" +
            "            \"name\": \"İstanbul\",\n" +
            "            \"value\": \"998\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"İstanbul(Avr.)\",\n" +
            "            \"value\": \"34\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"İstanbul(Asya)\",\n" +
            "            \"value\": \"82\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ],\n" +
            "        \"districts\": []\n" +
            "      },\n" +
            "      \"sortType\": null,\n" +
            "      \"searchCustomFilter\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"Uzaktan Çalışma\",\n" +
            "            \"value\": \"Uzaktan Çalışma\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Hızlı Başvuru\",\n" +
            "            \"value\": \"Hızlı Başvuru\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"cityListDetail\": [],\n" +
            "      \"searchForRetiredKeyword\": false,\n" +
            "      \"searchForRelatedJob\": false,\n" +
            "      \"earthquakeEmploymentProductType\": false,\n" +
            "      \"workModels\": {\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"name\": \"İş Yerinde\",\n" +
            "            \"value\": \"0\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Uzaktan / Remote\",\n" +
            "            \"value\": \"1\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Hibrit\",\n" +
            "            \"value\": \"2\",\n" +
            "            \"count\": 0,\n" +
            "            \"isSelected\": false\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"dontShowAppliedJobs\": null,\n" +
            "      \"dontShowInspectedJobs\": null\n" +
            "    },\n" +
            "    \"jobSortType\": \"SortByDate\",\n" +
            "    \"jobSeo\": {\n" +
            "      \"searchResultTitle\": \"İngilizce İş İlanları\",\n" +
            "      \"metaTitle\": \"İngilizce Bilen İş İlanları - İngilizce İş Fırsatları\",\n" +
            "      \"metaDescription\": \"İngilizce bilen iş ilanları kariyer.net'te. En güncel İngilizce iş ilanlarını incele, sana uygun ilanlara başvur ve İngilizce iş fırsatlarını kaçırma!\",\n" +
            "      \"canonicalUrl\": \"https://www.kariyer.net/is-ilanlari/ingilizce\",\n" +
            "      \"positionTitle\": null,\n" +
            "      \"positionDescription\": null,\n" +
            "      \"nextPageLink\": \"https://www.kariyer.net/is-ilanlari/ingilizce-2\",\n" +  //fourth assertion**********************
            "      \"previousPageLink\": null,\n" +
            "      \"content\": null,\n" +
            "      \"contentTitle\": null,\n" +
            "      \"faqHtmlContent\": null,\n" +
            "      \"noScriptUrlResponse\": {\n" +
            "        \"text\": null,\n" +
            "        \"noScriptUrlLinks\": []\n" +
            "      }\n" +
            "    },\n" +
            "    \"searchUrl\": \"/is-ilanlari/ingilizce#&pst=3193,2024&lg=02\",\n" +
            "    \"locationText\": \"\",\n" +
            "    \"blueCollarJobs\": {\n" +
            "      \"items\": [],\n" +
            "      \"total\": 0\n" +
            "    },\n" +
            "    \"isSearched\": false,\n" +
            "    \"currentPage\": 1,\n" +
            "    \"noScriptUrls\": {\n" +
            "      \"text\": null,\n" +
            "      \"noScriptUrlLinks\": []\n" +
            "    },\n" +
            "    \"suggestions\": [\n" +
            "      {\n" +
            "        \"title\": \"İlanları konuma göre filtrele!\",\n" +
            "        \"suggestionType\": \"Location\",\n" +
            "        \"suggestionSubType\": \"City\",\n" +
            "        \"rules\": {\n" +
            "          \"index\": 13,\n" +
            "          \"maxLineWeb\": 2,\n" +
            "          \"maxLineMobileWeb\": 3,\n" +
            "          \"maxLineMobileApp\": 3\n" +
            "        },\n" +
            "        \"items\": [\n" +
            "          {\n" +
            "            \"id\": 82,\n" +
            "            \"name\": \"İstanbul(Asya)\",\n" +
            "            \"count\": 80,\n" +
            "            \"filterType\": 18,\n" +
            "            \"title\": null,\n" +
            "            \"url\": null\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 34,\n" +
            "            \"name\": \"İstanbul(Avr.)\",\n" +
            "            \"count\": 79,\n" +
            "            \"filterType\": 18,\n" +
            "            \"title\": null,\n" +
            "            \"url\": null\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 6,\n" +
            "            \"name\": \"Ankara\",\n" +
            "            \"count\": 23,\n" +
            "            \"filterType\": 18,\n" +
            "            \"title\": null,\n" +
            "            \"url\": null\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"message\": null,\n" +
            "  \"error\": null\n" +  //third assertion***************************
            "}";

    //same as the above string but minified
    public static final String MINIFIED_JSON = "{\"statusCode\":\"Success\",\"status\":\"Success\",\"data\":{\"breadCrumb\":{\"items\":[{\"text\":\"Ana Sayfa\",\"url\":\"https://www.kariyer.net\"},{\"text\":\"İş İlanları\",\"url\":\"https://www.kariyer.net/is-ilanlari\"},{\"text\":\"İngilizce İş İlanları\",\"url\":\"https://www.kariyer.net/is-ilanlari/ingilizce\"}]},\"totalJobCount\":148,\"totalJobCountWithOutSponsored\":148,\"title\":\"İngilizce Bilen İş İlanları - İngilizce İş Fırsatları\",\"jobs\":{\"items\":[{\"id\":3213313,\"title\":\"Senior Software Developer\",\"companyName\":\"Arvato Lojistik Anonim Şirketi\",\"jobUrl\":\"/is-ilani/arvato-lojistik-anonim-sirketi-senior-software-developer-3213313\",\"companyUrl\":\"/firma-profil/arvato-lojistik-anonim-sirketi-60191-222615\",\"logoUrl\":\"yeni.jpg.jpg\",\"fullPathLogoUrl\":\"https://img-kariyer.mncdn.com/UploadFiles/Clients/Logolar/yeni.jpg.jpg\",\"locationText\":\"İstanbul(Asya)\",\"isSponsored\":false,\"humanReward\":false,\"workType\":\"FullTime\",\"workTypeText\":\"Full-Time\",\"jobDateText\":\"1 gün önce\",\"memberJobStatus\":\"Inspected\",\"isHandicapped\":false,\"isFavorite\":false,\"hasVideo\":false,\"hasIso\":false,\"companyId\":60191,\"profileId\":222615,\"jobDateStatus\":\"Default\",\"postingDate\":\"2023-10-12\",\"confidential\":false,\"sectors\":[{\"code\":\"016007000\",\"name\":\"Lojistik\"}],\"onlyPublishedOnKariyerNet\":true,\"isLogoSelected\":0,\"showTime\":\"2023-09-17T09:45\",\"positionLevel\":3,\"allLocations\":\"İstanbul(Asya)\",\"squareLogoUrl\":\"https://img-kariyer.mncdn.com/mnresize/150/150/UploadFiles/Clients/SquareLogo/191/60191_254912.jpg\",\"isDisaster\":false,\"workModel\":\"OnSite\",\"isEasyApply\":false,\"locations\":[{\"countryId\":\"65\",\"countryName\":\"Türkiye\",\"cityId\":\"82\",\"cityName\":\"İstanbul(Asya)\",\"jobTownLocationList\":[{\"townId\":\"457\",\"townName\":\"Kadıköy\"}]}]},{\"id\":3609107,\"title\":\"Mobile Application Developer\",\"companyName\":\"Smartiks Yazılım A.Ş.\",\"jobUrl\":\"/is-ilani/smartiks-yazilim-a-s-mobile-application-developer-3609107\",\"companyUrl\":\"/firma-profil/smartiks-yazilim-a-s-13078-3368\",\"logoUrl\":\"13078_1242901.jpg\",\"fullPathLogoUrl\":\"https://img-kariyer.mncdn.com/UploadFiles/Clients/Logolar/13078_1242901.jpg\",\"locationText\":\"İstanbul (Tümü)\",\"isSponsored\":false,\"humanReward\":false,\"workType\":\"FullTime\",\"workTypeText\":\"Full-Time\",\"jobDateText\":\"2 gün önce\",\"memberJobStatus\":\"Inspected\",\"isHandicapped\":false,\"isFavorite\":false,\"hasVideo\":false,\"hasIso\":false,\"companyId\":13078,\"profileId\":3368,\"jobDateStatus\":\"Default\",\"postingDate\":\"2023-10-11\",\"confidential\":false,\"sectors\":[{\"code\":\"001000000\",\"name\":\"Bilişim\"}],\"onlyPublishedOnKariyerNet\":true,\"isLogoSelected\":0,\"showTime\":\"2023-09-19T16:32\",\"positionLevel\":0,\"allLocations\":\"İstanbul(Asya), İstanbul(Avr.) ...\",\"squareLogoUrl\":\"\",\"isDisaster\":false,\"workModel\":\"Remote\",\"isEasyApply\":false,\"locations\":[{\"countryId\":\"65\",\"countryName\":\"Türkiye\",\"cityId\":\"34\",\"cityName\":\"İstanbul(Avr.)\",\"jobTownLocationList\":[]},{\"countryId\":\"65\",\"countryName\":\"Türkiye\",\"cityId\":\"82\",\"cityName\":\"İstanbul(Asya)\",\"jobTownLocationList\":[]}]}],\"companyItems\":[],\"companyProfileItems\":[],\"currentPage\":1},\"filters\":{\"companySectors\":{\"items\":[{\"name\":\"Bilişim\",\"value\":\"001000000\",\"count\":0,\"isSelected\":false},{\"name\":\"Üretim / Endüstriyel Ürünler\",\"value\":\"002000000\",\"count\":0,\"isSelected\":false},{\"name\":\"Elektrik & Elektronik\",\"value\":\"003000000\",\"count\":0,\"isSelected\":false},{\"name\":\"Güvenlik\",\"value\":\"004000000\",\"count\":0,\"isSelected\":false}]},\"positionLevels\":{\"items\":[{\"name\":\"Üst düzey yönetici\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"Orta düzey yönetici\",\"value\":\"2\",\"count\":0,\"isSelected\":false},{\"name\":\"Yönetici adayı\",\"value\":\"3\",\"count\":0,\"isSelected\":false},{\"name\":\"Uzman\",\"value\":\"4\",\"count\":0,\"isSelected\":false}]},\"departments\":null,\"workAreas\":{\"items\":[{\"name\":\"Akademik\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"AR-GE\",\"value\":\"2\",\"count\":0,\"isSelected\":false},{\"name\":\"Arşiv / Dokümantasyon\",\"value\":\"3\",\"count\":0,\"isSelected\":false},{\"name\":\"Bakım / Onarım\",\"value\":\"4\",\"count\":0,\"isSelected\":false}]},\"workTypes\":{\"items\":[{\"name\":\"Sürekli / Tam zamanlı\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"Dönemsel / Proje bazlı\",\"value\":\"2\",\"count\":0,\"isSelected\":false},{\"name\":\"Stajyer\",\"value\":\"3\",\"count\":0,\"isSelected\":false}]},\"educationLevels\":{\"items\":[{\"name\":\"Doktora - Mezun\",\"value\":\"DM\",\"count\":0,\"isSelected\":false},{\"name\":\"Doktora - Öğrenci\",\"value\":\"DO\",\"count\":0,\"isSelected\":false},{\"name\":\"Yüksek Lisans - Mezun\",\"value\":\"MM\",\"count\":0,\"isSelected\":false}]},\"companyProperties\":{\"items\":[{\"name\":\"ISO 500 Şirketleri\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"İK Danışmanlığı Yapmayan Şirketler\",\"value\":\"2\",\"count\":0,\"isSelected\":false},{\"name\":\"Adını Gizlemeyen Şirketlerin İlanları\",\"value\":\"3\",\"count\":0,\"isSelected\":false},{\"name\":\"İnsana Saygı Ödüllü Şirketler\",\"value\":\"4\",\"count\":0,\"isSelected\":false}]},\"jobProperties\":{\"items\":[{\"name\":\"Sana Uygun İlanlar\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"Kaydettiğin İlanlar\",\"value\":\"2\",\"count\":0,\"isSelected\":false},{\"name\":\"Takip Ettiğin Şirketin İlanları\",\"value\":\"3\",\"count\":0,\"isSelected\":false}]},\"positions\":{\"items\":[{\"name\":\"Yazılım Geliştirme Uzmanı\",\"value\":\"3193\",\"count\":0,\"isSelected\":true},{\"name\":\"Yazılım Uzmanı\",\"value\":\"2024\",\"count\":0,\"isSelected\":true},{\"name\":\"Muhasebe Uzmanı\",\"value\":\"1327\",\"count\":0,\"isSelected\":false}]},\"jobLanguages\":{\"items\":[{\"name\":\"Türkçe\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"İngilizce\",\"value\":\"2\",\"count\":0,\"isSelected\":true}]},\"handicappedStatus\":{\"items\":[{\"name\":\"Tümü\",\"value\":\"10\",\"count\":0,\"isSelected\":false},{\"name\":\"Sadece engelli ilanlarını göster\",\"value\":\"20\",\"count\":0,\"isSelected\":false},{\"name\":\"Engelli ilanlarını gösterme\",\"value\":\"30\",\"count\":0,\"isSelected\":false}]},\"dates\":{\"items\":[{\"name\":\"Bugünün ilanları\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"Son 3 saat\",\"value\":\"2\",\"count\":0,\"isSelected\":false},{\"name\":\"Son 8 saat\",\"value\":\"3\",\"count\":0,\"isSelected\":false}]},\"workExperience\":{\"items\":[{\"name\":\"Deneyimli\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"Deneyimsiz\",\"value\":\"2\",\"count\":0,\"isSelected\":false}],\"minValue\":0,\"maxValue\":0},\"locations\":{\"countries\":[{\"name\":\"Türkiye\",\"value\":\"10\",\"count\":0,\"isSelected\":false},{\"name\":\"Kıbrıs\",\"value\":\"20\",\"count\":0,\"isSelected\":false},{\"name\":\"Yurt Dışı\",\"value\":\"30\",\"count\":0,\"isSelected\":false}],\"cities\":[{\"name\":\"İstanbul\",\"value\":\"998\",\"count\":0,\"isSelected\":false},{\"name\":\"İstanbul(Avr.)\",\"value\":\"34\",\"count\":0,\"isSelected\":false},{\"name\":\"İstanbul(Asya)\",\"value\":\"82\",\"count\":0,\"isSelected\":false}],\"districts\":[]},\"sortType\":null,\"searchCustomFilter\":{\"items\":[{\"name\":\"Uzaktan Çalışma\",\"value\":\"Uzaktan Çalışma\",\"count\":0,\"isSelected\":false},{\"name\":\"Hızlı Başvuru\",\"value\":\"Hızlı Başvuru\",\"count\":0,\"isSelected\":false}]},\"cityListDetail\":[],\"searchForRetiredKeyword\":false,\"searchForRelatedJob\":false,\"earthquakeEmploymentProductType\":false,\"workModels\":{\"items\":[{\"name\":\"İş Yerinde\",\"value\":\"0\",\"count\":0,\"isSelected\":false},{\"name\":\"Uzaktan / Remote\",\"value\":\"1\",\"count\":0,\"isSelected\":false},{\"name\":\"Hibrit\",\"value\":\"2\",\"count\":0,\"isSelected\":false}]},\"dontShowAppliedJobs\":null,\"dontShowInspectedJobs\":null},\"jobSortType\":\"SortByDate\",\"jobSeo\":{\"searchResultTitle\":\"İngilizce İş İlanları\",\"metaTitle\":\"İngilizce Bilen İş İlanları - İngilizce İş Fırsatları\",\"metaDescription\":\"İngilizce bilen iş ilanları kariyer.net'te. En güncel İngilizce iş ilanlarını incele, sana uygun ilanlara başvur ve İngilizce iş fırsatlarını kaçırma!\",\"canonicalUrl\":\"https://www.kariyer.net/is-ilanlari/ingilizce\",\"positionTitle\":null,\"positionDescription\":null,\"nextPageLink\":\"https://www.kariyer.net/is-ilanlari/ingilizce-2\",\"previousPageLink\":null,\"content\":null,\"contentTitle\":null,\"faqHtmlContent\":null,\"noScriptUrlResponse\":{\"text\":null,\"noScriptUrlLinks\":[]}},\"searchUrl\":\"/is-ilanlari/ingilizce#&pst=3193,2024&lg=02\",\"locationText\":\"\",\"blueCollarJobs\":{\"items\":[],\"total\":0},\"isSearched\":false,\"currentPage\":1,\"noScriptUrls\":{\"text\":null,\"noScriptUrlLinks\":[]},\"suggestions\":[{\"title\":\"İlanları konuma göre filtrele!\",\"suggestionType\":\"Location\",\"suggestionSubType\":\"City\",\"rules\":{\"index\":13,\"maxLineWeb\":2,\"maxLineMobileWeb\":3,\"maxLineMobileApp\":3},\"items\":[{\"id\":82,\"name\":\"İstanbul(Asya)\",\"count\":80,\"filterType\":18,\"title\":null,\"url\":null},{\"id\":34,\"name\":\"İstanbul(Avr.)\",\"count\":79,\"filterType\":18,\"title\":null,\"url\":null},{\"id\":6,\"name\":\"Ankara\",\"count\":23,\"filterType\":18,\"title\":null,\"url\":null}]}]},\"message\":null,\"error\":null}";
}
