package org.blockchain.identity.feature;

public class ServerKeys {

    private static final KeyUtils.StringKeyPair keyPair;

    private static final String trustedAppPublicKey;

    static {
        keyPair = new KeyUtils.StringKeyPair("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4IBKqAmoH6saPHJ0pi" +
                "/ggzvr9XUXIvC8zDZG5OxACAdfRl0ubKzqeR/Hhov0JxngLSkZTGXori5D5zDMEzZXSs4Z" +
                "/dY2LKZckbQVI7rySQMAE9bS00jXT14CNEqh1S/OU3q///ePWchE4y7kPo0gRXtvzOTA7/PuUMHO9YccSicUL7icq3scCgzpBNYtOIMJuhhK0dwA7ch248mQtiEC+fC/Twu+E/qw2WI2IkexmjpObz0KDpdD3KJ5Zq9/KqcxjbgX0J5shnB9keEY++s18m2kvphp5/kfq97fK45u6tG0jYm4nHQxsGaY1HYLGbaV8nGHbXWPXMMsLzfm/iPAvAgMBAAECggEARJF9Id7gSa5+31DSnmRHtUAfbDdOA6FBGowVFpwOLBEvpBfpyhFhNQyp4VNnVDqa/eldIxk7y/eft8b5wPImt16v2cuXOJn2dVQ8QZrWksiWOcKe1y/pZ8i7UM3/+h6cyXXcqUKNlJDKJRKJCm/OKNngo0VK1ywxLFCW6ZH+JsKR3lUQXAW5bdJiwCJ7MRMPyzMtJEaLWGol0kkF/yvY21/wjN4zREb5UFZRkBlf8ktrEUibMTdt/62OTf828wgfxLYZODB1F1lfbIZnb97JDZ1Uw5YU8zWnXvm3oxAvTAzuiWfQreuRSYXqa0+iNG+ZUudf+Lj7Gby+I2q1BKx3sQKBgQDfprh7la+CjvCpvbNqnioPfJ1aJGJu88+lxpTb9bbA/Feqnvr/cfHFZ3U2QDHToaII8Aja0HgxNxa/+ExYy7lLXsPATgJeIRPCbMag7M+7sfhKd8AUDK6cJqs04L7ZR/6TQFSndU6wp1nbV9S8UoDVprTJNMoePhk120/tHSXxIwKBgQDSwcx6IApEZK4E8EokrYxpv5ey12kNOz3f2TQOBDvmxU1S/wwdyAzHrvEVN5qQLplea4rc/gXWDUZw20ixXqciSrFM8kz1QgBkyyiSsHFr6Sgj7q90XIsIrHoXVDZmDnkSBY9GdMGXReFA8G/iVRwZjG5KK1Z/yOH2kdgwbhfDhQKBgQCtj6l9JtWUYS882t2gcOu9JvzJ1pCZABZ11NzysgXIUEwMOeIZWKjChB4/IqRIUxf3Daghf0S3FMRP5/X/tuGuLvWEiEVoHQ1DhbzDZ+NyCpPf3nyuUoUy4wNcPsl8v1U9mt/XML8HcmfWQ5vxJambpAqKVrA/tftEg1TMcyFdtwKBgFgGMUzgjOk706KkaZMgGQEh0E4Vwf6Qu6r+oMsp4Yrk5QLBG2Jk51GPM4nVC20kyVGyQPFD91QLf1wrehT6n3unDp5ApPvacSen4m5B211iqC05x3YmILuireuIdJ/zc4WfZNPcd+6idQ4WXeR9/5p8GKRJrXr5f8bn6w9vK+WxAoGBAJZWg3Km+GJdH3kHPxtudbhA0lHOH2VDNOhFy+zX0gtebrtE+MFAtWrJErlrh1ZGLgkDvahEn2MMQI+4LUPoJlkcRNOHCt81qtXFSWj7i75bqBhlbXLQgk724jgWRUYtcQFh5hq09NuNPD/EQfZzd3Fs5EHsWFR3LsARUOS6m7FG", "-----BEGIN CERTIFICATE-----\n" +
                "MIIC6TCCAdGgAwIBAgIJAKKwaxCpBXXSMA0GCSqGSIb3DQEBCwUAMDQxCzAJBgNV\n" +
                "BAYTAklOMQswCQYDVQQKEwJDQTELMAkGA1UECxMCQ0ExCzAJBgNVBAMTAkNBMB4X\n" +
                "DTE4MDUwOTA5NTAxOFoXDTI4MDUwNjA5NTAxOFowNDELMAkGA1UEBhMCSU4xCzAJ\n" +
                "BgNVBAoTAkNBMQswCQYDVQQLEwJDQTELMAkGA1UEAxMCQ0EwggEiMA0GCSqGSIb3\n" +
                "DQEBAQUAA4IBDwAwggEKAoIBAQC4IBKqAmoH6saPHJ0pi/ggzvr9XUXIvC8zDZG5\n" +
                "OxACAdfRl0ubKzqeR/Hhov0JxngLSkZTGXori5D5zDMEzZXSs4Z/dY2LKZckbQVI\n" +
                "7rySQMAE9bS00jXT14CNEqh1S/OU3q///ePWchE4y7kPo0gRXtvzOTA7/PuUMHO9\n" +
                "YccSicUL7icq3scCgzpBNYtOIMJuhhK0dwA7ch248mQtiEC+fC/Twu+E/qw2WI2I\n" +
                "kexmjpObz0KDpdD3KJ5Zq9/KqcxjbgX0J5shnB9keEY++s18m2kvphp5/kfq97fK\n" +
                "45u6tG0jYm4nHQxsGaY1HYLGbaV8nGHbXWPXMMsLzfm/iPAvAgMBAAEwDQYJKoZI\n" +
                "hvcNAQELBQADggEBADhwn7Z3UTF/nDBhTmCSZOD/hHuFihP0qWJ/CM58GB7nqryy\n" +
                "jA3rILTc3ytKZ7yLS+iOrXfmpRZg1bbzJ3VUdNG32lT20Bacbo0Y5Pdi1QkVZ93/\n" +
                "zEduMKXNaGkwfibGr1wpl5umYIYwRrN39nl+SWlad2JnXoUkqPhORnUX/XXUupUJ\n" +
                "F/fS3V5bfGiNUo1E+gK1UXZIEozHQTYogtSPH8Wi1XuPajZ35ZY63w09w/sNudvS\n" +
                "blMi7MPq1HNX6WrtdpuoKL6ZgLBRFxbF5xAKQHVNeLG/eD6cXJVkJk3z69rfsHhw\n" +
                "94b2J1vbyrasW6Djg8GRUKsVqiyOL5aXLc2XNJg=\n" +
                "-----END CERTIFICATE-----");

        trustedAppPublicKey = "-----BEGIN CERTIFICATE-----\n" +
                "MIIC6TCCAdGgAwIBAgIJAMHq0xBQLizBMA0GCSqGSIb3DQEBCwUAMDQxCzAJBgNV\n" +
                "BAYTAklOMQswCQYDVQQKEwJDQTELMAkGA1UECxMCQ0ExCzAJBgNVBAMTAkNBMB4X\n" +
                "DTE4MDUwOTA5NDcwNVoXDTI4MDUwNjA5NDcwNVowNDELMAkGA1UEBhMCSU4xCzAJ\n" +
                "BgNVBAoTAkNBMQswCQYDVQQLEwJDQTELMAkGA1UEAxMCQ0EwggEiMA0GCSqGSIb3\n" +
                "DQEBAQUAA4IBDwAwggEKAoIBAQCS7JCqoObPGB7NW3tGn2r+sL0y0LLALRLY+L1L\n" +
                "vGFQZy5Mlw7fp1GBeGkSClBAt+fUOL09q5vSsf+x/MjdQmMHvIYOks784hkvVBVQ\n" +
                "BnnO7f9CaAfXnavjTw4BuovCGLA44t76HnzAlnn9gEl2oxTUO6xW4zUT4XhUDG5E\n" +
                "LdiNMN9lAuzn3xmk6jc0eGApCXvhoF1ujC9PLYMYv9usATRw1U0SCtuZAQlQitRh\n" +
                "lSyrMPixNoAxgz8fEgcvAAgcUqkheERsmtLgjFoDh2nyIFgvkNrAwFMdtM/A9eb0\n" +
                "R/9YqYI9k3+CuPw3zNePm6kp7LQ0X2jcclklmOmRiVdlgbY/AgMBAAEwDQYJKoZI\n" +
                "hvcNAQELBQADggEBAHS0Ahl0mRUPA8VAwvJYEpgJmuLkSC3J86+n6qeQx0c62LQY\n" +
                "ZZoFqFAbZ7+IHzGkYKuce15KJKgu9wBny/j6rSXjmj1J/z42wMdRff6q3jRpea73\n" +
                "HistEbFBdgAHV5zfL4k1eGNoXoB2/q9YpHBhEtZ6lYGt9j1Y79ZG0KLyIbAAD+m7\n" +
                "faG9HA+AaPIUVNl8AzdXah81lqSwUICKLEIpNjdl9nhq1VgKL+nEEih7GjAhg4lP\n" +
                "bIXF/9+Gj0DqAhgs3t2drtS3LhqURFt+OFrpxkKpNqkQOLJcKriotmZgtc5ZILxl\n" +
                "kY47Qmfg5hIUEBsvjeOjwv5rcxH8NvXgsWs2llY=\n" +
                "-----END CERTIFICATE-----";
    }

    public static String getServerPublicKey() {
        return keyPair.getPublicKey();
    }

    public static String getServerPrivateKey() {
        return keyPair.getPrivateKey();
    }

    public static String getTrustedAppPublicKey() {
        return trustedAppPublicKey;
    }
}
