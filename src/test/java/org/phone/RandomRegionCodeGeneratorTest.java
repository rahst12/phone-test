package org.phone;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import org.junit.Test;

import java.text.Collator;
import java.util.*;

/**
 * Created by ryan on 4/11/2016.
 */
public class RandomRegionCodeGeneratorTest {
    private PhoneNumberUtil phoneNumberUtil;

    @org.junit.Before
    public void setUp() throws Exception {
        phoneNumberUtil = PhoneNumberUtil.getInstance();
    }

    @Test
    public void genNumber(){
        //Get all regions
        Set<String> allRegionsSet = phoneNumberUtil.getSupportedRegions();
        //Place the regions in a list
        List<String> allRegions = new ArrayList<>();
        allRegions.addAll(allRegionsSet);

        //Sort the list to view all the regions
        Collections.sort(allRegions, Collator.getInstance());

        System.out.println("size of regions: " + allRegions.size());
        for (String region : allRegions){
            int countryCode = phoneNumberUtil.getCountryCodeForRegion(region);
            StringBuilder sb = new StringBuilder();
            sb.append("cc: ").append(countryCode).append("  ");
            sb.append("region: ").append(region);

            String nddPrefixForRegion = phoneNumberUtil.getNddPrefixForRegion(region, false);

            sb.append("  nddPrefix: ").append(nddPrefixForRegion);

            boolean portable = phoneNumberUtil.isMobileNumberPortableRegion(region);
            sb.append("  mobileNumberPortableRegion: ").append(portable);
            System.out.println(sb.toString());
        }

        //Call the random function and print a few examples
        for (int i = 0;  i < 10; i++){
            System.out.println("rand : " + RandomRegionCodeGenerator.generateRandomCountryCode(allRegions));
        }
    }
}