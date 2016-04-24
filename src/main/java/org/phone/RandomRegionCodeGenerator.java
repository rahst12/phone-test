package org.phone;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by ryana on 4/11/2016.
 */
public class RandomRegionCodeGenerator {
    public static RegionCountry generateRandomCountryCode(List<String> regions){
        Collections.shuffle(regions, new Random(System.nanoTime()));
        String region = regions.get(0);
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        int countryCode = phoneNumberUtil.getCountryCodeForRegion(region);
        RegionCountry regionCountry = new RegionCountry(countryCode, region);
        return regionCountry;
    }
}
